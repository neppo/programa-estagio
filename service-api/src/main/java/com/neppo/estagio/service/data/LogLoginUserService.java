package com.neppo.estagio.service.data;

import com.neppo.estagio.data.model.LogLoginUser;

public interface LogLoginUserService {

    LogLoginUser save(LogLoginUser logLoginUser);

    void delete(LogLoginUser logLoginUser);

    Iterable<LogLoginUser> findAll();
}
