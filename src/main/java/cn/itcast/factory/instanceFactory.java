package cn.itcast.factory;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.impl.AccountDaoImpl;

public class instanceFactory {

    public AccountDao getAccountDao(){
        return new AccountDaoImpl();
    }
}
