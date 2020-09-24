package com.example.demo.service;

import com.example.demo.component.Converter;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.exception.TraineeIsNotExistException;
import com.example.demo.exception.TrainerIsNotExistException;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
        trainerRepository.save(TrainerEntity.builder().name("张老师").build());
        trainerRepository.save(TrainerEntity.builder().name("杜老师").build());
        trainerRepository.save(TrainerEntity.builder().name("董老师").build());
        trainerRepository.save(TrainerEntity.builder().name("王老师").build());
    }

    public List<TrainerEntity> addTrainer(String name) {
        TrainerEntity trainerEntity = TrainerEntity.builder().name(name).build();
        trainerRepository.save(trainerEntity);
        return trainerRepository.findAll();
    }

    public void deleteTrainer(long id) {
        if (!trainerRepository.existsById(id)){
            throw new TrainerIsNotExistException();
        }
        trainerRepository.deleteById(id);
    }

    public List<Trainer> getAllTrainer() {
        List<TrainerEntity> trainerEntityList = trainerRepository.findAll();
        List<Trainer> trainerList = trainerEntityList.stream()
                .map(trainerEntity -> Converter.trainerEntityConvertToTrainer(trainerEntity))
                .collect(Collectors.toList());
        return trainerList;
    }
}
