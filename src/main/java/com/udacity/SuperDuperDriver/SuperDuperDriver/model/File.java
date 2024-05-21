package com.udacity.SuperDuperDriver.SuperDuperDriver.model;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class File {
    private Integer fileId;
    private String fileName;
    private String contentType;
    private String fileSize;
    private Integer userId;
    private byte[] fileData;

    public File(Integer fileId, String fileName, String contentType, String fileSize, Integer userId, byte[] fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }
    public File(MultipartFile file, Integer userId) throws IOException {
        this.fileName = file.getOriginalFilename();
        this.contentType = file.getContentType();
        this.fileSize = String.valueOf(file.getSize());
        this.fileData = file.getBytes();
        this.userId = userId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public Integer getUserId() {
        return userId;
    }

    public byte[] getFileData() {
        return fileData;
    }
}

