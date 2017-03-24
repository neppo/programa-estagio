package com.neppo.estagio;

import com.neppo.estagio.data.model.User;
import com.neppo.estagio.service.data.UserService;
import com.neppo.estagio.service.login.LoginListener;
import com.neppo.estagio.service.login.LoginService;
import com.neppo.estagio.service.login.impl.ConsoleLogObserverImpl;
import com.neppo.estagio.service.login.impl.DatabaseLogObserverImpl;
import com.neppo.estagio.service.login.impl.LoginServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Mock
    private UserService userService;

    @Mock
    private ConsoleLogObserverImpl consoleLogObserver;

    @Mock
    private DatabaseLogObserverImpl databaseLogObserver;

    @Mock
    private LoginListener loginListener;


    @Before
    public void init(){

        when(userService.findByUsername(any()))
                .thenReturn(
                        new User("teste", "lalala", "Teste", "Testado"));
    }


    @Test
    public void testSuccess(){
        LoginService loginService = new LoginServiceImpl(userService, loginListener, consoleLogObserver, databaseLogObserver);

        boolean success = loginService.login("teste", "lalala");

        assertTrue(success);

    }

    @Test
    public void testFail(){
        LoginService loginService = new LoginServiceImpl(userService, loginListener, consoleLogObserver, databaseLogObserver);

        boolean success = loginService.login("teste", "lalal");

        assertFalse(success);

    }
}
