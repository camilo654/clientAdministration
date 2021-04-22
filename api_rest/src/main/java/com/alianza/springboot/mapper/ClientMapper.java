package com.alianza.springboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.alianza.springboot.dto.ClientDTO;
import com.alianza.springboot.entity.Client;

/**
 *
 * @author cctorresr
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

	/**
	 * Mapea Client entity a ClientDTO.
	 * 
	 * @param client entity
	 * @return ClientDTO 
	 */
	ClientDTO clientToClientDTO(Client client);

	/**
	 * Mapea ClientDTO a Client entity.
	 * 
	 * @param clientDTO
	 * @return Client entity
	 */
	Client clientDTOToClient(ClientDTO clientDTO);

	/**
	 * Mapea lista de Client entity a lista ClientDTO.
	 * 
	 * @param clientList
	 * @return ClientDTO 
	 */
	List<ClientDTO> clientListToClientDTOList(List<Client> clientList);
	
}
