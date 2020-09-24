package com.example.demo.service;

import com.example.demo.component.Converter;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.exception.TraineeIsNotExistException;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
