package com.neppo.estagio.service.login.impl;

import com.neppo.estagio.service.data.LogLoginUserService;
import com.neppo.estagio.service.login.LoginObserver;
import com.neppo.estagio.data.model.LogLoginUser;
import com.neppo.estagio.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class DatabaseLogObserverImpl implements LoginObserver {

    private LogLoginUserService logLoginUserService;


    @Autowired
    public DatabaseLogObserverImpl(LogLoginUserService logLoginUserService){
        this.logLoginUserService = logLoginUserService;
    }

    @Override
    public void notifyLogin(User user, boolean success) {
        if(success){
            final LogLoginUser logLoginUser = new LogLoginUser();
            logLoginUser.setUser(user);
            logLoginUser.setDate(new Date());
            logLoginUserService.save(logLoginUser);
        }
    }
}
