package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private RoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        roleDao = session.getMapper(RoleDao.class);
    }

    @After
    public void after() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void find (){
        Role role = new Role();

        List<Role> roles = roleDao.findAll();
        for (Role role1 : roles) {
            System.out.println(role1);
        }
    }
}
