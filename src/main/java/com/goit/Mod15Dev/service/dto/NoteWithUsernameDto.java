package com.goit.Mod15Dev.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteWithUsernameDto {

    private Long id;
    private String title;
    private String content;
    private String username;
}
