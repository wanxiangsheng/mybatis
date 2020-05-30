package cn.itcast.dao;

import cn.itcast.domain.Account;
import cn.itcast.domain.AccountUser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountDao {
    List<Account> findAll();

    List<AccountUser> findAccountUser();

    void saveAccountDao();

     List<Account> find ();

     void update(Account account);

     Account findByName(String name);
}
