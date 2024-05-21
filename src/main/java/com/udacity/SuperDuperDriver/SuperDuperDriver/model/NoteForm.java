package com.udacity.SuperDuperDriver.SuperDuperDriver.model;

public class NoteForm {

    private Integer noteId;
    private String noteTitle;
    private String noteDescription;

    public NoteForm(){}
    public NoteForm(Integer noteId,String noteTitle, String noteDescription) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }
    public NoteForm(String noteTitle, String noteDescription) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
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

    public Integer getNoteId() {
        return noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }
}
