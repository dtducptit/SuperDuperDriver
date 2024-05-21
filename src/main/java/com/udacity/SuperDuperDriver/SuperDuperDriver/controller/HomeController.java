package com.udacity.SuperDuperDriver.SuperDuperDriver.controller;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.*;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.CredentialsService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.FileService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.NoteService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private UserService userService;
    private FileService fileService;
    private NoteService noteService;
    private CredentialsService credentialsService;

    public HomeController(UserService userService, FileService fileService, NoteService noteService, CredentialsService credentialsService) {
        this.userService = userService;
        this.fileService = fileService;
        this.noteService = noteService;
        this.credentialsService = credentialsService;
    }



    @GetMapping
    public String HomeView(Authentication authentication, @ModelAttribute("newFile") FileForm newFile, @ModelAttribute("newNote") NoteForm newNote, @ModelAttribute("newCredential") CredentialForm newCredential, Model model) {
        String userName = authentication.getName();
        User user = userService.getCurrentUser(userName);
        Integer userId = user.getUserId();
        model.addAttribute("files" , this.fileService.getAllFiles(userId));
        model.addAttribute("notes" , this.noteService.getNotes(userId));
        model.addAttribute("credential" , this.credentialsService.getCredentials(userId));
        return "home";
    }



}
