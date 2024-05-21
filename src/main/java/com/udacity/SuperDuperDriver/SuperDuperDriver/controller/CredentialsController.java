package com.udacity.SuperDuperDriver.SuperDuperDriver.controller;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.Credential;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.CredentialForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.CredentialsService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.EncryptionService;
import com.udacity.SuperDuperDriver.SuperDuperDriver.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/credentials")
public class CredentialsController {

    private CredentialsService credentialsService;
    private UserService userService;
    private EncryptionService encryptionService;

    public CredentialsController(CredentialsService credentialsService, UserService userService, EncryptionService encryptionService) {
        this.credentialsService = credentialsService;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @PostMapping
    public String addCredential(Authentication authentication, @ModelAttribute("newCredential") CredentialForm newCredential , Model model, RedirectAttributes redirectAttributes) throws NoSuchAlgorithmException {
        try{
            String currentUser = authentication.getName();
            Integer userId = userService.getCurrentUser(currentUser).getUserId();
            String key = encryptionService.generateKey();
            String hashedPassword = encryptionService.encryptValue(newCredential.getPassword(),key);
            newCredential.setPassword(hashedPassword);
            credentialsService.addCredentials(newCredential,key,userId);
            redirectAttributes.addFlashAttribute("message", "Credential successfully added");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message" , e.getMessage());

        }
        return "redirect:/home";
    }

    @PutMapping
    public String editCredential(@ModelAttribute("newCredential") CredentialForm newCredential , RedirectAttributes redirectAttributes) {
        try{
            String key = encryptionService.generateKey();
            String hashedPassword = encryptionService.encryptValue(newCredential.getPassword(),key);
            newCredential.setPassword(hashedPassword);
            Credential credential = new Credential(newCredential , key );
            credentialsService.updateCredential(credential );
            redirectAttributes.addFlashAttribute("message", "Credential successfully edited");

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message" , "The Credential was not edited, try again");

        }
        return "redirect:/home";

    }
    @DeleteMapping("/delete/{credentialId}")
    public String handleCredentialDelete( @PathVariable String credentialId ,Authentication authentication , Model model , RedirectAttributes redirectAttributes) throws IOException {

        try{
            Integer CredentialIdAsNumber = Integer.parseInt(credentialId) ;
            credentialsService.deleteCredential(CredentialIdAsNumber);
            redirectAttributes.addFlashAttribute("message", "Credential successfully deleted");

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message" , "The Credential was not deleted, try again");

        }
        return "redirect:/home";
    }

}
