package EsempioJWT;

import EsempioJWT.Service.ServiceUtente;
import EsempioJWT.domain.Role;
import EsempioJWT.domain.Utente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class EsempioJWT {

	public static void main(String[] args) {
		SpringApplication.run(EsempioJWT.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(ServiceUtente userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUtente(new Utente(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUtente(new Utente(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUtente(new Utente(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUtente(new Utente(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			userService.addRoleToUtente("john", "ROLE_USER");
			userService.addRoleToUtente("will", "ROLE_MANAGER");
			userService.addRoleToUtente("jim", "ROLE_ADMIN");
			userService.addRoleToUtente("arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUtente("arnold", "ROLE_ADMIN");
			userService.addRoleToUtente("arnold", "ROLE_USER");
		};
	}
}
