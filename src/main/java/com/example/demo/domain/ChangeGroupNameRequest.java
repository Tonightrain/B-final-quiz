package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeGroupNameRequest {
        // GTB: - 修改组名时只需要传入新组名就行
        @JsonProperty(value = "oldName")
        private String oldName;

        @JsonProperty(value = "newName")
        private String newName;
}
