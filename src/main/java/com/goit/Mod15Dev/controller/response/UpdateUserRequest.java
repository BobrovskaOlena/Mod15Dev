package com.goit.Mod15Dev.controller.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String oldUsername;

    @NotBlank
    @Size(min = 3, max = 100)
    private String oldPassword;

    @NotBlank
    @Size(min = 3, max = 100)
    private String newUsername;

    @NotBlank
    @Size(min = 3, max = 100)
    private String newPassword;
}
