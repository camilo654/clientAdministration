package com.alianza.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * Retorna el listado de todos los clientes almacenados en la tabla
	 * {@literal Client}.
	 *
	 * @return {@code ResponseEntity<List<ClientDTO>>} con {@code HttpStatus} 200 si
	 *         se obtuvo con exito el listado de {@code Client} de la DB, o un
	 *         {@code HttpStatus} 500 si no fue posible
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ClientDTO>> getClients() {
		logger.info("getClients");
		return clientService.getClients();
	}

	/**
	 * Busca un {@literal Client} por su sharedKey y lo retorna si lo encuentra en
	 * DB.
	 *
	 * @return {@code ResponseEntity<ClientDTO>} con {@code HttpStatus} 200 si se
	 *         obtuvo con exito el {@code Client} de la DB, o un {@code HttpStatus}
	 *         500 si no fue posible
	 */
	@GetMapping(path = "/{sharedKey}", produces = "application/json")
	public ResponseEntity<ClientDTO> getClientBySharedKey(@PathVariable String sharedKey) {
		logger.info("getClientBySharedKey - sharedKey: {}", sharedKey);
		return clientService.getClientBySharedKey(sharedKey);
	}

	/**
	 * Recibe un {@literal ClientDTO} para almacenarlo en la tabla
	 * {@literal Client}.
	 *
	 * @param clientDTO Contiene la información del cliente que se guardará en DB
	 * @return {@code ResponseEntity<ClientDTO>} con {@code HttpStatus} 200 si se
	 *         almacenó en la DB, o un {@code HttpStatus} 500 si no fue posible
	 */
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
		logger.info("createClient - ClientDTO: {}", clientDTO);
		return clientService.createClient(clientDTO);
	}

}
