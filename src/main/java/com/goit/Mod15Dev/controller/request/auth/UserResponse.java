package com.goit.Mod15Dev.controller.request.auth;

import com.goit.Mod15Dev.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String username;
    private Set<UserRole> roles = new HashSet<>();
}
