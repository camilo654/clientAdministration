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
	 * @param entity
	 * @return ClientDTO 
	 * Mapea Client entity a ClientDTO
	 */
	ClientDTO clientToClientDTO(Client client);

	/**
	 * @param ClientDTO
	 * @return Client entity
	 * Mapea ClientDTO a Client entity
	 */
	Client clientDTOToClient(ClientDTO client);

	/**
	 * @param entityList
	 * @return ClientDTO 
	 * Mapea lista de Client entity a lista ClientDTO
	 */
	List<ClientDTO> clientListToClientDTOList(List<Client> client);
	
}
