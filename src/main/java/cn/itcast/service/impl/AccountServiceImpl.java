package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import cn.itcast.utils.TransterManager;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    private TransterManager transterManager;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        accountDao.saveAccountDao();

        System.out.println(name + "23" + age + "23" + birthday);
    }

    @Override
    public List<Account> find() {
        return accountDao.find();
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void transfer(String sourceName, String targetName, Float money) {

        transterManager.beginTranster();

        try {
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() - money);

            accountDao.update(source);

            accountDao.update(target);
            int i = 1 / 0;
            transterManager.commit();
        } catch (Exception e) {
            transterManager.rollback();
        } finally {
            transterManager.release();
        }

    }
}
