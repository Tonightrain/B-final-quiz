package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static com.example.demo.component.ErrorMessage.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainee {
    private long id;

    @NotBlank(message = NAME_INVALID)
    private String name;

    @NotBlank(message = OFFICE_INVALID)
    private String office;

    @NotBlank(message = EMAIL_INVALID)
    @Email(message = EMAIL_WRONG_FORMAT)
    private String email;

    @NotBlank(message = GITHUB_INVALID)
    private String github;

    @NotBlank(message = ZOOM_ID_INVALID)
    private String zoomId;
}
