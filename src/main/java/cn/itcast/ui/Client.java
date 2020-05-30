package cn.itcast.ui;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {

    public static void main(String[] args) {

//        ApplicationContext ac =new ClassPathXmlApplicationContext("bean2.xml");
//        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
//        AccountService accountService = ac.getBean("accountService", AccountService.class);
//        AccountService accountService = (AccountService) ac.getBean("accountService");
//        AccountService accountService2 = (AccountService) ac.getBean("accountService");
//        accountService.saveAccount();
//        accountService2.saveAccount();


        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService acc = ac.getBean("accountService", AccountService.class);
        List<Account> accounts = acc.find();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
