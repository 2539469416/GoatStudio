package com.goat;



import com.goat.entity.TagGY;
import com.goat.service.impl.TagGYServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

@SpringBootTest
@MapperScan("com.goat.dao")
class BlogApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("默认数据源："+dataSource.getClass());
        Connection con = dataSource.getConnection();
        System.out.println("连接对象："+con);
        if(con!=null){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        //释放资源
        con.close();
    }


    @Autowired
    private TagGYServiceImpl tagGYServiceImpl;
    @Test
    void tagfindAll(){
        List<TagGY> list = tagGYServiceImpl.findAllTag();
        for(TagGY tagGY:list){
            System.out.println(tagGY.toString());
        }
    }

//    @Test
//    void contextLoads() throws SQLException {
//        System.out.println("默认数据源："+dataSource.getClass());
//        Connection con = dataSource.getConnection();
//        System.out.println("连接对象："+con);
//        if(con!=null){
//            System.out.println("success");
//        }else{
//            System.out.println("fail");
//        }
//        //释放资源
//        con.close();
//    }

}
