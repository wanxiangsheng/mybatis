package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
     void saveAccount();

     List<Account>  find();

      void transfer(String sourceName, String targetName, Float money);
}
