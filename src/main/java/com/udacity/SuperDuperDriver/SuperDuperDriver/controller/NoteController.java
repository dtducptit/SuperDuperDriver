package com.udacity.SuperDuperDriver.SuperDuperDriver.controller;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.Note;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.NoteService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

        private NoteService noteService;
        private UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @PostMapping
    public String addNote(Authentication authentication, @ModelAttribute("newNote")NoteForm newNote , Model model, RedirectAttributes redirectAttributes) {
        try {
            String currentUser = authentication.getName();
            Integer userId = userService.getCurrentUser(currentUser).getUserId();
            noteService.addNote(newNote, userId);
            redirectAttributes.addFlashAttribute("message", "Note successfully uploaded");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message" , "The note was not uploaded, try again");

        }
        return "redirect:/home";

    }
    @PutMapping
    public String editNote(@ModelAttribute("newNote") NoteForm newNote , RedirectAttributes redirectAttributes) {
       try{
           noteService.updateNote(newNote);
           redirectAttributes.addFlashAttribute("message", "Note successfully edited");

       }catch (Exception e){
           redirectAttributes.addFlashAttribute("message" , "The note was not edited, try again");

       }
        return "redirect:/home";

    }
    @DeleteMapping("/delete/{noteId}")
    public String handleNoteDelete( @PathVariable String noteId ,Authentication authentication , Model model , RedirectAttributes redirectAttributes) throws IOException {
        try{
            Integer noteAsNumber = Integer.parseInt(noteId) ;
            noteService.deleteNote(noteAsNumber);
            redirectAttributes.addFlashAttribute("message", "Note successfully deleted");

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message" , "The note was not deleted, try again");

        }
        return "redirect:/home";
    }


}
