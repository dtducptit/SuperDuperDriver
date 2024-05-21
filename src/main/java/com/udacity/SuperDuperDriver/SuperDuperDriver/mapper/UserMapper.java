package com.udacity.SuperDuperDriver.SuperDuperDriver.mapper;


import com.udacity.SuperDuperDriver.SuperDuperDriver.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE username=#{username}")
    User getUserByName(String username);
    @Select("SELECT * FROM USERS WHERE username=#{userId}")
    User getUserById(String username);

    @Insert("INSERT INTO USERS (username, salt, password, firstName, lastName) VALUES (#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

}
