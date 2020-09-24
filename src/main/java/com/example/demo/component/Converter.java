package com.example.demo.component;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;

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
}
