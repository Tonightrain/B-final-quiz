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
        traineeRepository.save(TraineeEntity.builder()
                .name("迈克")
                .office("西安")
                .email("805560812@qq.com")
                .github("http://github1.com")
                .zoomId("666")
                .build());
        traineeRepository.save(TraineeEntity.builder()
                .name("黛西")
                .office("武汉")
                .email("602560812@qq.com")
                .github("http://github2.com")
                .zoomId("888")
                .build());
        traineeRepository.save(TraineeEntity.builder()
                .name("杰瑞")
                .office("程度")
                .email("965260812@qq.com")
                .github("http://github3.com")
                .zoomId("999")
                .build());
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
                // GTB: - 可以使用lambda表达式简化代码
                .map((traineeEntity -> Converter.traineeEntityConvertToTrainee(traineeEntity)))
                .collect(Collectors.toList());
        return traineeList;
    }
}
