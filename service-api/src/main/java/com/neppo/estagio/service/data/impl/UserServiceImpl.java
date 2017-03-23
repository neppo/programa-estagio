package com.neppo.estagio.service.data.impl;

import com.neppo.estagio.service.data.UserService;
import com.neppo.estagio.data.model.User;
import com.neppo.estagio.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findByUsername(String username) {

        List<User> users = userRepository.findByLogin(username);

        if( users.size() > 0){
            return users.get(0);
        }

        return null;

    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
