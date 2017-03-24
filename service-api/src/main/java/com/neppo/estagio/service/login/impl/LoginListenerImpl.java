package com.neppo.estagio.service.login.impl;

import com.neppo.estagio.service.login.LoginListener;
import com.neppo.estagio.service.login.LoginObserver;
import com.neppo.estagio.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginListenerImpl implements LoginListener {

    private final List<LoginObserver> observers;

    @Autowired
    public LoginListenerImpl(){
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
