package cn.itcast.dao;

import cn.itcast.domain.Account;
import cn.itcast.domain.AccountUser;

import java.util.List;

public interface AccountDao<list> {
    List<Account> findAll();

    List<AccountUser> findAccountUser();

}
