package com.neppo.estagio.service.data;

import com.neppo.estagio.data.model.User;

public interface UserService {

    User save(User user);

    void delete(User user);

    User findByUsername(String username);

    Iterable<User> findAll();

}
