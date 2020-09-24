package com.example.demo.service;

import com.example.demo.component.Converter;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.exception.TraineeIsNotExistException;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository){
        this.traineeRepository = traineeRepository;
    }

    public TraineeEntity addTrainee(Trainee trainee) {
        TraineeEntity traineeEntity = Converter.traineeConvertToTraineeEntity(trainee);
        return traineeRepository.save(traineeEntity);
    }

    public void deleteTrainee(long id) {
        if (!traineeRepository.existsById(id)) {
            throw new TraineeIsNotExistException();
        }
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getAllTrainees() {
        List<TraineeEntity> traineeEntityList = traineeRepository.findAll();
        List<Trainee> traineeList = traineeEntityList.stream()
                .map((traineeEntity -> Converter.traineeEntityConvertToTrainee(traineeEntity)))
                .collect(Collectors.toList());
        return traineeList;
    }
}
