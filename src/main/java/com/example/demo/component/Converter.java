package com.example.demo.component;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;

public class Converter {

    public static TraineeEntity traineeConvertToTraineeEntity(Trainee trainee) {
        return TraineeEntity.builder()
                .name(trainee.getName())
                .office(trainee.getOffice())
                .email(trainee.getEmail())
                .github(trainee.getGithub())
                .zoomId(trainee.getZoomId())
                .build();
    }

    public static Trainee traineeEntityConvertToTrainee(TraineeEntity traineeEntity) {
        return Trainee.builder()
                .id(traineeEntity.getId())
                .name(traineeEntity.getName())
                .office(traineeEntity.getOffice())
                .email(traineeEntity.getEmail())
                .github(traineeEntity.getGithub())
                .zoomId(traineeEntity.getZoomId())
                .build();
    }

    public static TrainerEntity trainerConvertToTrainerEntity(Trainer trainer){
        return TrainerEntity.builder()
                .name(trainer.getName())
                .build();
    }

    public static Trainer trainerEntityConvertToTrainer(TrainerEntity trainerEntity) {
        return Trainer.builder()
                .id(trainerEntity.getId())
                .name(trainerEntity.getName())
                .build();
    }
}
