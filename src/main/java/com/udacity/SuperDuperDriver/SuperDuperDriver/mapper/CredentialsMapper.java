package com.udacity.SuperDuperDriver.SuperDuperDriver.mapper;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.CredentialForm;
import com.udacity.SuperDuperDriver.SuperDuperDriver.model.NoteForm;
import org.apache.ibatis.annotations.*;

import com.udacity.SuperDuperDriver.SuperDuperDriver.model.Credential;

import java.util.List;

@Mapper
public interface CredentialsMapper {

    @Insert("INSERT INTO CREDENTIALS (url, username, `key`, password, userId) VALUES (#{url}, #{username}, #{key}, #{password}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insertCredential(Credential credential);

    @Select("SELECT * FROM credentials WHERE userId = #{userId}")
    List<Credential> getCredentialsByUserId(int userId);

    @Select("SELECT * FROM credentials WHERE credentialId = #{credentialId}")
    Credential findCredentialById(Integer id);
    @Select("SELECT * FROM credentials WHERE username = #{username}")
    Credential findCredentialByUsername(String username);
    @Update("UPDATE credentials SET url = #{url}, username = #{username} , password = #{password} , `key` = #{key}  WHERE credentialId = #{credentialId}")
    void update(Credential credential );
    @Delete("DELETE FROM credentials WHERE credentialId = #{credentialId}")
    void deleteCredential(int id);
}