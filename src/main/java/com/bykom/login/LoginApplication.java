package com.bykom.login;

import com.bykom.login.models.Client;
import com.bykom.login.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}


	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository){
		return args -> {

			Client client1 = new Client("Julian","Alvarez","julian@gmail.com",passwordEncoder.encode("1234"));
			Client client2 = new Client("Enzo","Fernandes","enzo@gmail.com",passwordEncoder.encode("1234"));
			Client client3 = new Client("Emiliano","Martinez","emiliano@gmail.com",passwordEncoder.encode("1234"));


			clientRepository.save(client1);
			clientRepository.save(client2);
			clientRepository.save(client3);

		};
	}


}


