package com.alianza.springboot.entity;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 *
 * @author cctorresr
 */
@Data
@Entity
public class Client {

	@Id
	private String sharedKey;
	private String bussinessID;
	private String email;
	private BigInteger phone;
	private LocalDate dataAdded;

	public Client() {
	}

	public Client(String sharedKey, String bussinessID, String email, BigInteger phone, LocalDate dataAdded) {
		this.sharedKey = sharedKey;
		this.bussinessID = bussinessID;
		this.email = email;
		this.phone = phone;
		this.dataAdded = dataAdded;
	}
}
