package com.alianza.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.alianza.springboot.entity.Client;

/**
 *
 * @author cctorresr
 */
public interface ClientRepository extends CrudRepository<Client, String> {

	Client findByBussinessID(String string);

}
