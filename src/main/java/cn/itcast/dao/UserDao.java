package cn.itcast.dao;

import cn.itcast.domain.Query;
import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void saveUser(User user);

    void deleteUser(Integer id);

    void update(User user);

    User findById(Integer id);

    List<User> findByName(String name);

    int count();

    List<User> query(Query vo);

    List<User> findUserByConditon(User user);

    List<User> findByIds(Query vo);

}
