package com.alianza.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.alianza.springboot.dto.Client;

/**
 *
 * @author cctorresr
 */
public interface IClientService {

	public ResponseEntity<List<Client>> getClients();

}
