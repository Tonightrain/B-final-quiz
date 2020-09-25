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

    @DeleteMapping("/trainees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // GTB: - @PathVariable应该显式写明value属性
    public void deleteTrainee(@PathVariable long id){
        traineeService.deleteTrainee(id);
    }

    @GetMapping("/trainees")
    @ResponseStatus(HttpStatus.OK)
    // GTB: - 接口错误：应该查询所有未分组学员，而非所有学员
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

}
