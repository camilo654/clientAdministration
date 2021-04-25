package com.alianza.springboot.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alianza.springboot.dto.ClientDTO;
import com.alianza.springboot.entity.Client;
import com.alianza.springboot.mapper.ClientMapper;
import com.alianza.springboot.repository.ClientRepository;
import com.alianza.springboot.service.IClientService;

/**
 *
 * @author cctorresr
 */
@Service
public class ClientService implements IClientService {

	@Autowired
	ClientMapper clientMapper;
	@Autowired
	ClientRepository clientRepository;

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Override
	public ResponseEntity<List<ClientDTO>> getClients() {
		try {
			List<Client> clientList = new ArrayList<>();
			logger.info("getClients - Se recuperan clientes de la DB");
			clientRepository.findAll().forEach(clientList::add);
			logger.info("getClients - clientList: {}", clientList);

			// Se mapea la lista de entidades a una lista de ClientDTO
			return new ResponseEntity<>(clientMapper.clientListToClientDTOList(clientList), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getClients - error: {}", e);
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ClientDTO> getClientBySharedKey(String sharedKey) {
		try {
			logger.info("getClientBySharedKey - Se recuperan clientes de la DB");
			Optional<Client> clientOpt = clientRepository.findBySharedKey(sharedKey);
			logger.info("getClientBySharedKey - client: {}", clientOpt);

			if (clientOpt.isPresent()) {
				Client client = clientOpt.get();
				// Se mapea entidad a ClienteDTO para retornarlo en el servicio
				return new ResponseEntity<>(clientMapper.clientToClientDTO(client), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ClientDTO(), HttpStatus.OK);
			}

		} catch (Exception e) {
			logger.error("getClientBySharedKey - error: {}", e);
			return new ResponseEntity<>(new ClientDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ClientDTO> createClient(ClientDTO clientDTO) {
		try {
			clientDTO.setDataAdded(LocalDate.now());
			logger.info("createClient - Se almacena cliente en la DB");
			Client cliente = clientRepository.save(clientMapper.clientDTOToClient(clientDTO));
			logger.info("createClient - cliente creado: {}", cliente);

			// Se mapea entidad a ClienteDTO para retornarlo en el servicio
			return new ResponseEntity<>(clientMapper.clientToClientDTO(cliente), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("createClient - error: {}", e);
			return new ResponseEntity<>(new ClientDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
