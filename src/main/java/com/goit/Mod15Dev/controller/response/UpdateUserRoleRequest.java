package com.goit.Mod15Dev.controller.response;

import com.goit.Mod15Dev.utils.UserRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UpdateUserRoleRequest {

    @NotEmpty
    Set<UserRole> roles = new HashSet<>();
}
