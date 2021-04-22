package com.alianza.springboot.serviceimpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alianza.springboot.dto.Client;
import com.alianza.springboot.service.IClientService;

/**
 *
 * @author cctorresr
 */
@Service
public class ClientService implements IClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Override
	public ResponseEntity<List<Client>> getClients() {

		List<Client> clientList = new ArrayList<>();
		try {
			clientList = getClientsList();
			logger.info("getClients - clientList: {}", clientList);
			return new ResponseEntity<>(clientList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(clientList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private List<Client> getClientsList() {
		logger.info("getClientsList");
		Client[] clientArray = {
				new Client("jgutierrez", "Juliana Gutierrez", "jgutierrez@gmail.com", BigInteger.valueOf(3219876543L),
						new Date()),
				new Client("mmartinez", "Manuel Martinez", "mmartinez@gmail.com", BigInteger.valueOf(3219876543L),
						new Date()),
				new Client("aruiz", "Ana Ruiz", "aruiz@gmail.com", BigInteger.valueOf(3219876543L), new Date()),
				new Client("ogarcia", "Oscar Garcia", "ogarcia@gmail.com", BigInteger.valueOf(3219876543L),
						new Date()) };

		logger.info("exit getClientsList");
		return Arrays.asList(clientArray);
	}

}
