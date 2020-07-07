package com.alibaba.craftsman.tunnel.database.craftsman;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @Description UserProfileTunnelTest
 * @Author springCat
 * @Date 2020/7/7 18:47
 */
public class UserProfileTunnelTest {
    private static UserProfileTunnel mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserProfileTunnelTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserProfileTunnelTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(UserProfileTunnel.class, builder.openSession(true));
    }

    @Test
    public void testCreate() throws FileNotFoundException {
        //mapper.create();
    }
}
