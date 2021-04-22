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

import com.alianza.springboot.dto.ClientDTO;
import com.alianza.springboot.service.IClientService;

/**
 *
 * @author cctorresr
 */
@Service
public class ClientService implements IClientService {

	List<ClientDTO> clientList = new ArrayList<>();

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	{
		logger.info("createClientList");
		ClientDTO[] clientArray = {
				new ClientDTO("jgutierrez", "Juliana Gutierrez", "jgutierrez@gmail.com",
						BigInteger.valueOf(3219876543L), new Date()),
				new ClientDTO("mmartinez", "Manuel Martinez", "mmartinez@gmail.com", BigInteger.valueOf(3219876543L),
						new Date()),
				new ClientDTO("aruiz", "Ana Ruiz", "aruiz@gmail.com", BigInteger.valueOf(3219876543L), new Date()),
				new ClientDTO("ogarcia", "Oscar Garcia", "ogarcia@gmail.com", BigInteger.valueOf(3219876543L),
						new Date()) };

		clientList = Arrays.asList(clientArray);

		logger.info("exit createClientList");
	}

	@Override
	public ResponseEntity<List<ClientDTO>> getClients() {
		try {
			// En este punto se traerian los clientes de la DB
			clientList = getClientsList();
			logger.info("getClients - clientList: {}", clientList);

			return new ResponseEntity<>(clientList, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getClients - error: {}", e);
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ClientDTO> createClient(ClientDTO clientDTO) {
		try {
			clientDTO.setDataAdded(new Date());
			// En este punto se agregaria el nuevo cliente en la DB
			logger.info("createClient - clientDTO: {}", clientDTO);
			clientList.add(clientDTO);
			logger.info("createClient - cliente creado: {}", clientDTO);

			return new ResponseEntity<>(clientDTO, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("createClient - error: {}", e);
			return new ResponseEntity<>(new ClientDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private List<ClientDTO> getClientsList() {
		logger.info("getClientsList - clientList: {}", clientList);
		return clientList;
	}

}
