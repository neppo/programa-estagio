package com.neppo.estagio.service.login;

import com.neppo.estagio.data.model.User;


public interface LoginHandler {

    void register(LoginObserver obj);

    void unregister(LoginObserver obj);

    void notifyObservers(User user, boolean success);
}
