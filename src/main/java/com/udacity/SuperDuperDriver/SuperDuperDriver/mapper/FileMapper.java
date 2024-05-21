package com.udacity.SuperDuperDriver.SuperDuperDriver.mapper;

import org.apache.ibatis.annotations.*;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.File;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("INSERT INTO FILES (filename,contenttype,filesize,userid,filedata) VALUES (#{fileName},#{contentType},#{fileSize},#{userId},#{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    void insertFile(File file);

    @Select("SELECT * FROM files WHERE userId = #{userId}")
    List<File> getFilesByUserId(Integer userId);
    @Select("SELECT * FROM files WHERE filename = #{filename}")
    File findFileByName(String filename);

    @Select("SELECT * FROM files WHERE fileId = #{fileId}")
    File findById(int fileId);

    @Delete("DELETE FROM files WHERE fileId = #{fileId}")
    void deleteFile(Integer fileId);
}