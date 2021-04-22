package com.alianza.springboot;

import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alianza.springboot.entity.Client;
import com.alianza.springboot.repository.ClientRepository;

/**
 *
 * @author cctorresr
 */
@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Bean
	public CommandLineRunner createClients(ClientRepository clientRepository) {
		return args -> {
			logger.info("createClients");

			// Cliente 1
			clientRepository.save(new Client("jgutierrez", "Juliana Gutierrez", "jgutierrez@gmail.com",
					BigInteger.valueOf(3219876543L), new Date()));
			// Cliente 2
			clientRepository.save(new Client("mmartinez", "Manuel Martinez", "mmartinez@gmail.com",
					BigInteger.valueOf(3219876543L), new Date()));
			// Cliente 3
			clientRepository.save(new Client("aruiz", "Ana Maria Ruiz", "aruiz@gmail.com",
					BigInteger.valueOf(3219876543L), new Date()));
			// Cliente 4
			clientRepository.save(new Client("ogarcia", "Oscar Garcia", "ogarcia@gmail.com",
					BigInteger.valueOf(3219876543L), new Date()));

			logger.info("exit createClients");
		};
	}

}
