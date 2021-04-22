package com.alianza.springboot.dto;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author cctorresr
 */
@Data
public class ClientDTO {

	private String sharedKey;
	private String bussinessID;
	private String email;
	private BigInteger phone;
	private Date dataAdded;

	public ClientDTO() {
	}

}
