package com.example.demo.api;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.service.TraineeService;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @PostMapping("/trainers")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerEntity addTrainer(@RequestBody @Valid Trainer trainer){
        return trainerService.addTrainer(trainer);
    }

    @DeleteMapping("/trainers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable long id){
        trainerService.deleteTrainer(id);
    }

    @GetMapping("/trainers")
    @ResponseStatus(HttpStatus.OK)
    public List<Trainer> getAllTrainer() {
        return trainerService.getAllTrainer();
    }

}
