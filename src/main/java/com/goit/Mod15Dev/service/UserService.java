package com.goit.Mod15Dev.service;

import com.goit.Mod15Dev.service.dto.UpdateUserDto;
import com.goit.Mod15Dev.service.dto.UserDto;
import com.goit.Mod15Dev.utils.UserRole;

import java.util.Collection;

public interface UserService {
    void registerUser(String username,String password);

    UserDto updateUser(Long userId, UpdateUserDto updateUserDto);

    UserDto updateUserRoles(Long userId, Collection<UserRole> roles);
}
