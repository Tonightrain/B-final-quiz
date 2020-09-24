package com.example.demo.service;

import com.example.demo.component.Converter;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public TrainerEntity addTrainer(Trainer trainer) {
        TrainerEntity trainerEntity = Converter.trainerConvertToTrainerEntity(trainer);
        return trainerRepository.save(trainerEntity);
    }
}
