package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trainee")
public class TraineeEntity {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String office;

    private String email;

    private String github;

    private String zoomId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private GroupEntity groupEntity;
}
