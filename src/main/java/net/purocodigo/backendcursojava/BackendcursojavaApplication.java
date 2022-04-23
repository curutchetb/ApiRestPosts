package net.purocodigo.backendcursojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.purocodigo.backendcursojava.security.AppProperties;

@SpringBootApplication
@EnableJpaAuditing //permite crearfechas automaticamente en bd
public class BackendcursojavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendcursojavaApplication.class, args);
		System.out.println("Funcionando");
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext () {
		return new SpringApplicationContext();
	}

	@Bean(name ="AppProperties")
	public AppProperties appProperties () {
		return new AppProperties();
	}
}
