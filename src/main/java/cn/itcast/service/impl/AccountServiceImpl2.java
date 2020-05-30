package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

public class AccountServiceImpl2  implements AccountService {
    private String[] str;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties pro;


    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(str));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(pro);
    }

    @Override
    public List<Account> find() {
        return null;
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }
}
