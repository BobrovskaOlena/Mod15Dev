package com.goit.Mod15Dev.controller;

import com.goit.Mod15Dev.controller.config.jwt.JwtUtils;
import com.goit.Mod15Dev.controller.config.jwt.UserDetailsImpl;
import com.goit.Mod15Dev.controller.request.auth.UserResponse;
import com.goit.Mod15Dev.controller.response.UpdateUserRequest;
import com.goit.Mod15Dev.controller.response.UpdateUserRoleRequest;
import com.goit.Mod15Dev.service.UserService;
import com.goit.Mod15Dev.service.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Validated
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private JwtUtils jwtUtils;
    @Autowired private UserMapper userMapper;

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetailsImpl authentication = (UserDetailsImpl) context.getAuthentication().getPrincipal();
        return ResponseEntity.ok(userMapper.toUserResponse(
                userService.updateUser(authentication.getId(), userMapper.toUpdateUserDto(updateUserRequest))));
    }

    @PutMapping("/update/roles")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<UserResponse> updateUserRole(@Valid @RequestBody UpdateUserRoleRequest updateUserRoleRequest) {
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetailsImpl authentication = (UserDetailsImpl) context.getAuthentication().getPrincipal();
        return ResponseEntity.ok(userMapper.toUserResponse(
                userService.updateUserRoles(authentication.getId(), updateUserRoleRequest.getRoles())));
    }
}
