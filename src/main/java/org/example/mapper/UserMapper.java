package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    User selectById(Integer id);

    int insert(User user);

    //传入username，password，模糊查询
    List<User> selectByLike(@Param("username") String username,
                            @Param("password") String password);

}

