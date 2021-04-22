package com.alianza.springboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.alianza.springboot.entity.Client;

/**
 *
 * @author cctorresr
 */
public interface ClientRepository extends CrudRepository<Client, String> {

	/**
	 * Retrieves an entity by its sharedKey.
	 *
	 * @param sharedKey must not be {@literal null}
	 * @return the entity with the given sharedKey or {@literal Optional#empty()} if none found
	 * @throws IllegalArgumentException if {@literal sharedKey} is {@literal null}
	 */
	Optional<Client> findBySharedKey(String sharedKey);

}
