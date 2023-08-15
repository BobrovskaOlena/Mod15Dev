package com.goit.Mod15Dev.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {

    private String oldUsername;
    private String oldPassword;
    private String newUsername;
    private String newPassword;
}
