package EnterpriseJavaDevelopment408;

import EnterpriseJavaDevelopment408.repositories.RoleRepository;
import EnterpriseJavaDevelopment408.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {


	@Autowired
	UserRepository userRepository;
	@Autowired
    RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}
}
