package com.alianza.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.springboot.dto.ClientDTO;
import com.alianza.springboot.service.IClientService;

/**
 *
 * @author cctorresr
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

	@Autowired
	IClientService clientService;

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ClientDTO>> getClients() {
		logger.info("getClients");
		return clientService.getClients();
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
		logger.info("createClient - ClientDTO: {}", clientDTO);
		return clientService.createClient(clientDTO);
	}

}
