package com.example.demo.api;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService){
        this.traineeService = traineeService;
    }

    @PostMapping("/trainees")
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeEntity addTrainee(@RequestBody @Valid Trainee trainee){
        return traineeService.addTrainee(trainee);
    }


}
