package com.goit.Mod15Dev.service.mapper;

import com.goit.Mod15Dev.controller.request.auth.UserResponse;
import com.goit.Mod15Dev.controller.response.UpdateUserRequest;
import com.goit.Mod15Dev.data.entity.RolesEntity;
import com.goit.Mod15Dev.data.entity.UserEntity;
import com.goit.Mod15Dev.service.dto.UpdateUserDto;
import com.goit.Mod15Dev.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toUserDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles().stream()
                .map(RolesEntity::getName).collect(Collectors.toSet()));
        return dto;
    }

    public UpdateUserDto toUpdateUserDto(UpdateUserRequest request) {
        UpdateUserDto dto = new UpdateUserDto();
        dto.setOldUsername(request.getOldUsername());
        dto.setOldPassword(request.getOldPassword());
        dto.setNewUsername(request.getNewUsername());
        dto.setNewPassword(request.getNewPassword());
        return dto;
    }

    public UserResponse toUserResponse(UserDto dto) {
        UserResponse response = new UserResponse();
        response.setId(dto.getId());
        response.setUsername(dto.getUsername());
        response.setRoles(dto.getRoles());
        return response;
    }
}
