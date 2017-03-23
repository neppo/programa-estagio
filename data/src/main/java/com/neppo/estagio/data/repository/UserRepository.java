package com.neppo.estagio.data.repository;

import com.neppo.estagio.data.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByLogin(String login);
}
