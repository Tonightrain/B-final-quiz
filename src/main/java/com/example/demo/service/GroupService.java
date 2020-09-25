package com.example.demo.service;

import com.example.demo.component.Converter;
import com.example.demo.domain.ChangeGroupNameRequest;
import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.exception.GroupIsNotExistException;
import com.example.demo.exception.GroupNameIsExistException;
import com.example.demo.exception.TrainerNumberIsLessThanTwoException;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;

    public GroupService(GroupRepository groupRepository, TraineeRepository traineeRepository, TrainerRepository trainerRepository) {
        this.groupRepository = groupRepository;
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<GroupEntity> autoGrouping() {
        List<TrainerEntity> teachers = trainerRepository.findAll();
        List<TraineeEntity> students = traineeRepository.findAll();
        groupRepository.deleteAll();
        if (teachers.size() < 2) {
            throw new TrainerNumberIsLessThanTwoException();
        }
        int groupNum = teachers.size()/2;
        for (int i = 1; i <= groupNum; i++) {
            GroupEntity groupEntity = GroupEntity.builder().name(i+"组").build();
            groupRepository.save(groupEntity);

        }
        Collections.shuffle(teachers);
        Collections.shuffle(students);
        List<GroupEntity> groups = groupRepository.findAll();

        long traineeGroup = 1;
        for (TraineeEntity traineeEntity : students){
            GroupEntity groupEntity = groupRepository.findById(traineeGroup).get();
            groupEntity.getTraineeList().add(traineeEntity);

            traineeEntity.setGroupEntity(groupEntity);
            traineeRepository.save(traineeEntity);

            groupRepository.save(groupEntity);
            if (traineeGroup == groupNum) {
                traineeGroup = 1;
            }else {
                traineeGroup++;
            }
        }

        long trainerGroup = 1;
        for (TrainerEntity trainerEntity : teachers){
            GroupEntity groupEntity = groupRepository.findById(trainerGroup).get();
            groupEntity.getTrainerList().add(trainerEntity);
            trainerEntity.setGroupEntity(groupEntity);
            trainerRepository.save(trainerEntity);
            groupRepository.save(groupEntity);
            if (trainerGroup == groupNum) {
                trainerGroup = 1;
            }else {
                trainerGroup++;
            }
        }

        return groups;
    }

    public List<GroupEntity> getAllGroups() {
        return groupRepository.findAll();
    }

    public void changeGroupName(long id,ChangeGroupNameRequest request) {
        GroupEntity group = groupRepository.findById(id).orElseThrow(GroupIsNotExistException::new);
        List<GroupEntity> groupEntities = groupRepository.findAll();
        List<GroupEntity> repeatName = groupEntities.stream()
                .filter(groupEntity -> groupEntity.getName().equals(request.getNewName()))
                .collect(Collectors.toList());
        if (repeatName.size() > 0) {
            throw new GroupNameIsExistException();
        }
        group.setName(request.getNewName());
        groupRepository.save(group);
    }

}
