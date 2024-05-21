package com.udacity.SuperDuperDriver.SuperDuperDriver.controller;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.CredentialForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.File;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.FileForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.FileService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    private FileService fileService;
    private UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<byte[]> viewFile(@PathVariable String fileId) {
        Integer fileIdAsNumber = Integer.parseInt(fileId) ;
        try{
            File file = fileService.getFile(fileIdAsNumber);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                    .body(file.getFileData());
        }catch (Exception e){
            return ResponseEntity.status(404).body("<h1>File is not found</h1>".getBytes());

        }
    }
    @PostMapping
    public String handleFileUpload(Authentication authentication, @ModelAttribute("newFile") FileForm newFile
            , Model model , RedirectAttributes redirectAttributes) throws IOException {
        try{
            String username = authentication.getName();
            Integer userId = userService.getCurrentUser(username).getUserId();
            fileService.addFile(newFile , userId);
            redirectAttributes.addFlashAttribute("message", "File successfully uploaded");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message" , "The file was not uploaded, try again");
        }

        return "redirect:/home";
    }

    @DeleteMapping("/delete/{fileId}")
    public String handleFileDelete( @PathVariable String fileId ,Authentication authentication , Model model , RedirectAttributes redirectAttributes) throws IOException {
        try {

            Integer fileIdAsNumber = Integer.parseInt(fileId);
            fileService.deleteFile(fileIdAsNumber);
            redirectAttributes.addFlashAttribute("message", "File successfully deleted");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message" , "The file was not deleted, try again");

        }
        return "redirect:/home";
    }

}
