package com.udacity.SuperDuperDriver.SuperDuperDriver.service;

import com.udacity.SuperDuperDriver.SuperDuperDriver.mapper.NoteMapper;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.Note;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public List<Note> getNotes(Integer userId){
        return noteMapper.getNotesByUserId(userId);
    }
    public Note getNote(Integer noteId){
        return noteMapper.getNoteById(noteId);
    }

    public void addNote(NoteForm noteForm , Integer userId){
        Note note = new Note(noteForm,userId);
        noteMapper.insert(note);
    }

    public void deleteNote(Integer noteId){
        noteMapper.delete(noteId);
    }

    public void updateNote(NoteForm note){
        noteMapper.update(note);
    }
}
