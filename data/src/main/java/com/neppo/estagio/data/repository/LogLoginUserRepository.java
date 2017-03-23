package com.neppo.estagio.data.repository;

import com.neppo.estagio.data.model.LogLoginUser;
import com.neppo.estagio.data.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogLoginUserRepository extends CrudRepository<LogLoginUser, Long> {
    List<LogLoginUser> findByUser(User user);
}