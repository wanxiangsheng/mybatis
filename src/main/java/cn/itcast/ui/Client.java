package cn.itcast.ui;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

//        AccountService accountService = ac.getBean("accountService", AccountService.class);
        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.saveAccount();


//        System.out.println(accountDao);
    }
}
