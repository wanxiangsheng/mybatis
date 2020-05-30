package cn.itcast.dao.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.AccountUser;
import cn.itcast.domain.Query;
import cn.itcast.utils.ConnectUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private ConnectUtils connectUtils;

    @Autowired
    private QueryRunner runner;

    public List<Account> findAll() {
        return null;
    }

    public List<AccountUser> findAccountUser() {
        return null;
    }



    @PreDestroy
    public void init() {
        System.out.println("初始化方法");

    }

    @PostConstruct
    public void destroy() {
        System.out.println("销毁了");
    }

    @Override
    public void saveAccountDao() {

    }

    @Override
    public List<Account> find() {
        try {
            return runner.query("select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            runner.update( connectUtils.getThreadConnection(),"update  account set money =? where id =?", account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findByName(String name) {
        List<Account> accouns = null;
        try {
            accouns = runner.query( connectUtils.getThreadConnection(), "select * from account where name =?", new BeanListHandler<Account>(Account.class), name);
            if (accouns == null && accouns.size() == 0) {
                return null;
            }
            if (accouns.size() > 1) {
                throw new RuntimeException("结果集不唯一");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accouns.get(0);
    }
}
