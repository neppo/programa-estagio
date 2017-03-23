package com.neppo.estagio.service.login;

import com.neppo.estagio.data.model.User;

public interface LoginObserver {
    void notifyLogin(User user, boolean success);
}
