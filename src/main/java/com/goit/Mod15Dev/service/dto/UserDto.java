package com.goit.Mod15Dev.service.dto;

import com.goit.Mod15Dev.utils.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private Set<UserRole> roles = new HashSet<>();
}
