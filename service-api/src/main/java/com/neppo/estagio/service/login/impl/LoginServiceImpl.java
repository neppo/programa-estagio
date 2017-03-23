package com.neppo.estagio.service.login.impl;

import com.neppo.estagio.service.data.UserService;
import com.neppo.estagio.service.login.LoginHandler;
import com.neppo.estagio.service.login.LoginService;
import com.neppo.estagio.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class LoginServiceImpl implements LoginService {

    private final UserService userService;

    private final LoginHandler loginHandler;

    @Autowired
    public LoginServiceImpl(UserService userService, LoginHandler loginHandler,
                            ConsoleLogObserverImpl consoleLogObserver,
                            DatabaseLogObserverImpl databaseLogObserver){
        this.userService = userService;
        this.loginHandler = loginHandler;
        loginHandler.register(consoleLogObserver);
        loginHandler.register(databaseLogObserver);
    }

    @Override
    @Transactional
    public boolean login(String username, String password) {
        User user = userService.findByUsername(username);
        boolean success = user != null && user.getPassword().equals(password);
        loginHandler.notifyObservers(user, success);
        return success;
    }
}
