package com.udacity.SuperDuperDriver.SuperDuperDriver.model;

public class Note {

    private Integer noteId;
    private String noteTitle;
    private String noteDescription;
    private Integer userId;


    public Note(Integer noteId, String noteTitle, String noteDescription , Integer userId) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.userId = userId;
    }
    public Note(NoteForm noteForm , Integer userId) {
        this.noteTitle = noteForm.getNoteTitle();
        this.noteDescription = noteForm.getNoteDescription();
        this.userId = userId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public Integer getUserId() {
        return userId;
    }
}
