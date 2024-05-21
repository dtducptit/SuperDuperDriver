package com.udacity.SuperDuperDriver.SuperDuperDriver.mapper;

import java.util.List;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import org.apache.ibatis.annotations.*;


import com.udacity.SuperDuperDriver.SuperDuperDriver.model.Note;

@Mapper
public interface NoteMapper {
    @Insert("INSERT INTO notes (notetitle, notedescription, userid) VALUES (#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Note note);

    @Select("SELECT * FROM notes WHERE userId = #{userId}")
    List<Note> getNotesByUserId(int userId);

    @Select("SELECT * FROM notes WHERE noteId = #{noteId}")
    Note getNoteById(int noteId);

    @Delete("DELETE FROM notes WHERE noteId =  #{noteId}")
    void delete(int noteId);
    @Update("UPDATE notes SET notetitle = #{noteTitle}, notedescription = #{noteDescription} WHERE noteId = #{noteId}")
    void update(NoteForm note);

}
