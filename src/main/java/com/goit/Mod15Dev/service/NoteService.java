package com.goit.Mod15Dev.service;

import com.goit.Mod15Dev.data.entity.NoteEntity;
import com.goit.Mod15Dev.data.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostConstruct
    private void init() {
        log.info("===>>>     Init my NoteService!");
    }

    public List<NoteEntity> listAll() {
        return noteRepository.findAll();
    }

    public NoteEntity add(NoteEntity note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void update(NoteEntity note) {
        NoteEntity updatingNote = getById(note.getId());
        if (updatingNote == null) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist");
        }
        updatingNote.setTitle(note.getTitle());
        updatingNote.setContent(note.getContent());
        noteRepository.save(updatingNote);
    }

    public NoteEntity getById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @PreDestroy
    public void cleanup() {
        log.info("===>>>     My NoteService cleanup");
    }
}