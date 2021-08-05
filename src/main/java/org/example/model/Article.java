package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer viewCount;
    private Integer userId;
    private Date createTime;

}


//mybatis中占位符，（1）#{变量名}：实现原理为，先替换为带？的预编译的sql语句，然后再以jdbc中，操作命令对象.set类型(占位符的索引,
// 替换的值)；---满足预编译的特性，防止sql注入，预编译提高性能
//（2）${变量名}：实现原理为，以字符串拼接的方式，拼接预编译的sql语句，${变量名}，
