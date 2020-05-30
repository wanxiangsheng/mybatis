package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private AccountService acc = null;

    @Test
    public void test() {
        List<Account> accounts = acc.find();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void test1(){

        acc.transfer("aaa","bbb",231F);
    }
}
