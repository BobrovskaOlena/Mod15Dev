package com.goit.Mod15Dev.controller.request.note;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNoteRequest extends NoteRequest {

    public CreateNoteRequest () {
    }

    public CreateNoteRequest (String title, String content) {
        super(title, content);
    }
}
