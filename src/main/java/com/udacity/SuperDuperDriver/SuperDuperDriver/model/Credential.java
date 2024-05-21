package com.udacity.SuperDuperDriver.SuperDuperDriver.model;

public class Credential {
    private Integer credentialId;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userId;
    private String decryptedPassword;

    public Credential(Integer credentialId, String url, String username, String key, String password, Integer userId) {
        this.credentialId = credentialId;
        this.url = url;
        this.username = username;
        this.key = key;
        this.password = password;
        this.userId = userId;
    }

    public Credential(CredentialForm credentialForm, String key,Integer userId) {
        this.credentialId = credentialForm.getId();
        this.url = credentialForm.getUrl();
        this.username = credentialForm.getUsername();
        this.key = key;
        this.password = credentialForm.getPassword();
        this.userId = userId;
    }
    public Credential(CredentialForm credentialForm, String key) {
        this.credentialId = credentialForm.getId();
        this.url = credentialForm.getUrl();
        this.username = credentialForm.getUsername();
        this.key = key;
        this.password = credentialForm.getPassword();
    }
    public Credential(String url, String username ,String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setDecryptedPassword(String decryptedPassword) {
        this.decryptedPassword = decryptedPassword;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserId() {
        return userId;
    }
    public String getDecryptedPassword() {
        return decryptedPassword;
    }

}