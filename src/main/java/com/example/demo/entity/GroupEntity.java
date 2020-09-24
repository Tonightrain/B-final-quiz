package com.example.demo.entity;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "groups")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "groupEntity")
    @Builder.Default
    private List<TraineeEntity> traineeList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "groupEntity")
    @Builder.Default
    private List<TrainerEntity> trainerList = new ArrayList<>();
}
