package com.neppo.estagio.service.login.impl;

import com.neppo.estagio.service.login.LoginHandler;
import com.neppo.estagio.service.login.LoginObserver;
import com.neppo.estagio.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginHandlerImpl implements LoginHandler {

    private final List<LoginObserver> observers;

    @Autowired
    public LoginHandlerImpl(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(LoginObserver obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(LoginObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers(User user, boolean success) {
        observers.forEach(observer -> observer.notifyLogin(user, success));
    }
}
