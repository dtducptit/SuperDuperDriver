package com.udacity.SuperDuperDriver.SuperDuperDriver.service;

import com.udacity.SuperDuperDriver.SuperDuperDriver.mapper.CredentialsMapper;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.Credential;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.CredentialForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CredentialsService {

    private CredentialsMapper credentialsMapper;
    private EncryptionService encryptionService;

    public CredentialsService(CredentialsMapper credentialsMapper, EncryptionService encryptionService) {
        this.credentialsMapper = credentialsMapper;
        this.encryptionService = encryptionService;
    }

    public void addCredentials(CredentialForm newCredential,String key, Integer userId ) throws Exception {
          String newUsername = newCredential.getUsername();
            Credential lookForDuplicate = credentialsMapper.findCredentialByUsername(newUsername);
        if (lookForDuplicate != null && newUsername.equals(lookForDuplicate.getUsername())) {
            throw new Exception("The username already exist");
        }
          Credential credential = new Credential(newCredential,key,userId);
          credentialsMapper.insertCredential(credential);
    }
    public List<Credential> getCredentials(Integer userId){
        List<Credential> credentialsList = credentialsMapper.getCredentialsByUserId(userId);
        for(Credential cre : credentialsList){
            cre.setDecryptedPassword(encryptionService.decryptValue(cre.getPassword(),cre.getKey()));
        }
        return credentialsList;
    }
    public void deleteCredential(Integer credentialId){
        credentialsMapper.deleteCredential(credentialId);
    }
    public void updateCredential(Credential newCre){
        credentialsMapper.update(newCre);
    }

}
