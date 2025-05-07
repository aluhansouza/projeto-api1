package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@SpringBootApplication
public class ProjetoBackend1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBackend1Application.class, args);
	}

}
