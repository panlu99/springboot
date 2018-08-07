package com.example.springboot.mapper;

import com.example.springboot.domin.User;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM ")
    User findByName(@Param("name") String name);
}
