package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.AccountUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public List<Account> findAll() {
        return null;
    }

    public List<AccountUser> findAccountUser() {
        return null;
    }

    @Override
    public void saveAccountDao() {
        System.out.println("执行了accountDao中的方法");
    }

    @Override
    public List<Account> find() {
        return null;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public Account findByName(String name) {
        return null;
    }


}
