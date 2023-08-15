package com.goit.Mod15Dev.service.mapper;

import com.goit.Mod15Dev.controller.request.note.CreateNoteRequest;
import com.goit.Mod15Dev.controller.request.note.UpdateNoteRequest;
import com.goit.Mod15Dev.controller.response.NoteResponse;
import com.goit.Mod15Dev.data.NoteWithUserNameProjection;
import com.goit.Mod15Dev.data.entity.NoteEntity;
import com.goit.Mod15Dev.service.dto.NoteDto;
import com.goit.Mod15Dev.service.dto.NoteWithUsernameDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public List<NoteEntity> toNoteEntities(Collection<NoteDto> dtos) {
        return dtos.stream()
                .map(this::toNoteEntity)
                .collect(Collectors.toList());
    }

    public NoteEntity toNoteEntity(NoteDto dto) {
        NoteEntity entity = new NoteEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        return entity;
    }

    public List<NoteDto> toNoteDtos(Collection<NoteEntity> entities) {
        return entities.stream()
                .map(this::toNoteDto)
                .collect(Collectors.toList());
    }

    public NoteDto toNoteDto(NoteEntity entity) {
        NoteDto dto = new NoteDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }

    public List<NoteResponse> toNoteResponses(Collection<NoteDto> dtos) {
        return dtos.stream()
                .map(this::toNoteResponse)
                .collect(Collectors.toList());
    }

    public NoteResponse toNoteResponse(NoteDto dto) {
        NoteResponse response = new NoteResponse();
        response.setId(dto.getId());
        response.setTitle(dto.getTitle());
        response.setContent(dto.getContent());
        return response;
    }

    public List<NoteDto> requestsToNoteDtos(Collection<CreateNoteRequest> requests) {
        return requests.stream()
                .map(this::toNoteDto)
                .collect(Collectors.toList());
    }

    public NoteDto toNoteDto(CreateNoteRequest request) {
        NoteDto dto = new NoteDto();
        dto.setTitle(request.getTitle());
        dto.setContent(request.getContent());
        return dto;
    }

    public NoteDto toNoteDto(Long id, UpdateNoteRequest request) {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setTitle(request.getTitle());
        dto.setContent(request.getContent());
        return dto;
    }

    public NoteWithUsernameDto toNoteWithUsernameDto(NoteWithUserNameProjection proj) {
        NoteWithUsernameDto dto = new NoteWithUsernameDto();
        dto.setId(proj.getNoteId());
        dto.setTitle(proj.getTitle());
        dto.setContent(proj.getContent());
        dto.setUsername(proj.getUsername());
        return dto;
    }

    public List<NoteWithUsernameDto> toNoteWithUsernameDtoList(Collection<NoteWithUserNameProjection> projs) {
        return projs.stream().map(this::toNoteWithUsernameDto).toList();
    }

    public NoteWithUsernameDto toNoteWithUsernameDto(NoteEntity entity) {
        NoteWithUsernameDto dto = new NoteWithUsernameDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }

    public List<NoteWithUsernameDto> toNoteWithUsernameDtoList1(Collection<NoteEntity> proj) {
        return proj.stream().map(this::toNoteWithUsernameDto).toList();
    }
}
