package cn.itcast.service.impl;

import cn.itcast.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date  birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount(){
        System.out.println( name +"23"+age + "23"+birthday);
    }

}
