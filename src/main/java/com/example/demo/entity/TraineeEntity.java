package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
