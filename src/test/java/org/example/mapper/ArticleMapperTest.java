package org.example.mapper;

import org.example.Application;
import org.example.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@Transactional
public class ArticleMapperTest {


    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testSelectById(){
        Article a = articleMapper.selectById(1);
        System.out.println(a);

    }


    @Test
    public void testInsert(){
        Article a = new Article();
        a.setTitle("测试20210711");
        a.setContent("提前批冲刺");
        a.setUserId(1);
        articleMapper.insert(a);
    }



    @Test
    public void testSelectByCondition(){

        Article a = new Article();
        a.setTitle("测试a");
        List<Article> list = articleMapper.selectByCondition(a,1);

        System.out.println(list);
    }



    @Test
    public void testSelectLike(){

        //模拟用户在页面上输入标题，输入内容进行模糊查询
        String inputTitle = "排序";
        String inputContent = "private";

        List<Article> list = articleMapper.selectLike("%"+inputTitle+"%","%"+inputContent+"%");
        System.out.println(list);

    }


}
