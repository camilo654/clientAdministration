package com.alianza.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.alianza.springboot.dto.ClientDTO;

/**
 *
 * @author cctorresr
 */
public interface IClientService {

	/**
	 * Recupera de la DB el listado de todos los clientes almacenados en la tabla,
	 * mapea este listado de {@code Client Entity} a un listado de
	 * {@literal ClientDTO} y lo retorna.
	 *
	 * @return {@code ResponseEntity<List<ClientDTO>>} con {@code HttpStatus} 200 si
	 *         se obtuvo con exito el listado de {@code Client} de la DB, o un
	 *         {@code HttpStatus} 500 si no fue posible
	 */
	public ResponseEntity<List<ClientDTO>> getClients();

	/**
	 * Recibe un {@literal ClientDTO} para almacenarlo en la tabla
	 * {@literal Client}, si lo almacena con exito mapea el {@literal Client} a
	 * {@literal ClientDTO} y lo retorna.
	 *
	 * @param clientDTO Contiene la información del cliente que se guardará en DB
	 * @return {@code ResponseEntity<ClientDTO>} con {@code HttpStatus} 200 si se
	 *         almacenó en la DB, o un {@code HttpStatus} 500 si no fue posible
	 */
	public ResponseEntity<ClientDTO> createClient(ClientDTO clientDTO);

}
