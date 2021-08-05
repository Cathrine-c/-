package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;

//加上Mapper注解，扫描时带有Mapper注解的类会被生成代理类，而类里的方法会被织入
@Mapper
@Component
public interface ArticleMapper {

    Article selectById(Integer id);
    int insert(Article a);

    List<Article> selectByCondition(@Param("a") Article a,@Param("userId") Integer userId);


    List<Article> selectLike(@Param("title") String t,@Param("content") String c);


}
