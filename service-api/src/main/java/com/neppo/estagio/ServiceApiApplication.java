package com.neppo.estagio;

import com.neppo.estagio.service.data.LogLoginUserService;
import com.neppo.estagio.service.data.UserService;
import com.neppo.estagio.log.Logger;
import com.neppo.estagio.service.login.LoginService;
import com.neppo.estagio.data.model.LogLoginUser;
import com.neppo.estagio.data.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserService userService, LogLoginUserService logLoginUserService, LoginService loginService) {
		return (args) -> {

			User user = userService.findByUsername("teste");
			if(user != null){
				user.setPassword("lalala");
				userService.save(user);
			}else{
				user = new User("teste", "lalala", "Teste", "Testado");
				userService.save(user);
			}

			//Test success
			Logger.log("TESTE LOGIN SUCCESS ---------------------------------------------");
			loginService.login("teste", "lalala");
			Logger.log("TESTE log_login_user rows ---------------------------------------");
			for (LogLoginUser logLoginUser : logLoginUserService.findAll()) {
				Logger.log(logLoginUser.toString());
			}

			//Test Fail
			Logger.log("TESTE LOGIN FAIL ------------------------------------------------");
			loginService.login("teste", "123");
		};
	}
}
