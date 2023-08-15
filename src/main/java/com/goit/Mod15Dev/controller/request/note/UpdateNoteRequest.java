package com.goit.Mod15Dev.controller.request.note;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNoteRequest extends NoteRequest {

    public UpdateNoteRequest () {
    }

    public UpdateNoteRequest (String title, String content) {
        super(title, content);
    }
}
