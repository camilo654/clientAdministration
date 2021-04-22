package com.alianza.springboot.dto;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author cctorresr
 */
@Data
public class Client {

	private String sharedKey;
	private String bussinessID;
	private String email;
	private BigInteger phone;
	private Date dataAdded;

	public Client() {
	}

	public Client(String sharedKey, String bussinessID, String email, BigInteger phone, Date dataAdded) {
		this.sharedKey = sharedKey;
		this.bussinessID = bussinessID;
		this.email = email;
		this.phone = phone;
		this.dataAdded = dataAdded;
	}
}
