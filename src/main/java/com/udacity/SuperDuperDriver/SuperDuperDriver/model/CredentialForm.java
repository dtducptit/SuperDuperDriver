package com.udacity.SuperDuperDriver.SuperDuperDriver.model;

public class CredentialForm {
    private Integer credentialId;
    private String url;
    private String password;
    private String username;

    public CredentialForm(Integer credentialId, String url, String password, String username) {
        this.credentialId = credentialId;
        this.url = url;
        this.password = password;
        this.username = username;
    }

    public void setId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return credentialId;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}