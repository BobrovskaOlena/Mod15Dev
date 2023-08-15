package com.goit.Mod15Dev.data;

public interface NoteWithUserNameProjection {

    Long getNoteId();
    String getTitle();
    String getContent();
    String getUsername();
}
