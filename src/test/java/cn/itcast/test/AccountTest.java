package cn.itcast.test;

import cn.itcast.dao.AccountDao;
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

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void after() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List accounts = accountDao.findAll();
        for (Object o : accounts) {
            System.out.println(o);
        }
    }

        @Test
    public void findAccountUser(){
            List accountUser = accountDao.findAccountUser();
            for (Object o : accountUser) {
                System.out.println(o);
            }
        }
}
