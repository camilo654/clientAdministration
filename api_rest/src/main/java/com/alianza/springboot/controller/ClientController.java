package com.alianza.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.springboot.dto.Client;
import com.alianza.springboot.service.IClientService;

/**
 *
 * @author cctorresr
 */
@RestController
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	IClientService clientService;

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@GetMapping(path = "/client", produces = "application/json")
	public ResponseEntity<List<Client>> getClients() {
		logger.info("getClients");
		return clientService.getClients();
	}

}
