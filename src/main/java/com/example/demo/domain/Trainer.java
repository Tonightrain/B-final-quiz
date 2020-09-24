package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static com.example.demo.component.ErrorMessage.NAME_INVALID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainer {

    private long id;

    @NotBlank(message = NAME_INVALID)
    private String name;
}
