package net.purocodigo.backendcursojava;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.purocodigo.backendcursojava.dto.UserDto;
import net.purocodigo.backendcursojava.models.responses.UserRest;
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

	//crear una instancia del mapper y desp no crear a cada rato
	@Bean
	public ModelMapper modelMapper (){

		ModelMapper mapper = new ModelMapper();

		//se saltea el userrest al mapear para no entrar en ciclo infinito de user-post-user-post
		mapper.typeMap(UserDto.class, UserRest.class).addMappings(m -> m.skip(UserRest::setPosts));
		return mapper;
	}

}
