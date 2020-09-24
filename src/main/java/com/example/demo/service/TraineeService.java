package com.example.demo.service;

import com.example.demo.component.Converter;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

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
}