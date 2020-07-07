package com.alibaba.craftsman.tunnel.database.craftsman1;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @Description UserProfileTunnel1Test
 * @Author springCat
 * @Date 2020/7/7 18:48
 */
public class UserProfileTunnel1Test {
    private static UserProfileTunnel1 mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserProfileTunnel1Test.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserProfileTunnel1TestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(UserProfileTunnel1.class, builder.openSession(true));
    }

    @Test
    public void testCreate() throws FileNotFoundException {
       // mapper.create();
    }
}
