package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Query;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void after() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void fillAll() {
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void save() throws IOException {
        User user = new User();
        user.setAddress("sajdflkaj");
        user.setSex("女");
        user.setUsername("sjfklaj");
        user.setBirthday(new Date());
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(41);
        user.setBirthday(new Date());
        user.setUsername("jskladfaffasfaf");
        user.setAddress("jsklfasdfasdfajk");
        user.setSex("男阿萨");

        userDao.update(user);
    }

    @Test
    public void delete() {
        userDao.deleteUser(41);
    }

    @Test
    public void findID() {
        User user = userDao.findById(42);
        System.out.println(user);

    }

    ;

    @Test
    public void findByName() {
        User user = new User();

        List<User> users = userDao.findByName("%jsk%");
        for (User user1 : users) {
            System.out.println(user);
        }
    }

    @Test
    public void cou() {
        int cou = userDao.count();
        System.out.println(cou);
    }

    @Test
    public void Query() {
        Query query = new Query();
        User user = new User();
        user.setUsername("%jsk%");
        query.setUser(user);

        List<User> users = userDao.query(query);

        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void findUserByCondition(){
        User user = new User();
        user.setUsername("%jsk%");
        user.setSex("女");
        List<User> users = userDao.findUserByConditon(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void findByIds(){
        Query query = new Query();
        ArrayList<Integer> list  =new ArrayList<>();
        list.add(23);
        list.add(42);
        list.add(45);
        list.add(44);
        query.setIds(list);

        List<User> users = userDao.findByIds(query);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
