package com.neppo.estagio.service.data.impl;

import com.neppo.estagio.service.data.LogLoginUserService;
import com.neppo.estagio.data.model.LogLoginUser;
import com.neppo.estagio.data.repository.LogLoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogLoginUserServiceImpl implements LogLoginUserService {

    private final LogLoginUserRepository logLoginUserRepository;


    @Autowired
    public LogLoginUserServiceImpl(LogLoginUserRepository logLoginUserRepository){
        this.logLoginUserRepository = logLoginUserRepository;
    }

    @Override
    public LogLoginUser save(LogLoginUser logLoginUser) {
        return logLoginUserRepository.save(logLoginUser);
    }

    @Override
    public void delete(LogLoginUser logLoginUser) {
        logLoginUserRepository.delete(logLoginUser);
    }

    @Override
    public Iterable<LogLoginUser> findAll() {
        return logLoginUserRepository.findAll();
    }
}
