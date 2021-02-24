package io.github.ammar257ammar.psnpbind.webapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("io.github.ammar257ammar.psnpbind.webapp.repository")
public class PSnpBindApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PSnpBindApplication.class, args);
	}	
}
