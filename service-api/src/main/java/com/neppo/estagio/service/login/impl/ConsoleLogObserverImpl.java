package com.neppo.estagio.service.login.impl;

import com.neppo.estagio.log.Logger;
import com.neppo.estagio.service.login.LoginObserver;
import com.neppo.estagio.data.model.User;
import org.springframework.stereotype.Service;

@Service
public class ConsoleLogObserverImpl implements LoginObserver {

    @Override
    public void notifyLogin(User user, boolean success) {
        if(success){
            Logger.log("User login success " + user.getLogin());
        }else{
            Logger.error("User login failed " + user.getLogin());
        }
    }
}
