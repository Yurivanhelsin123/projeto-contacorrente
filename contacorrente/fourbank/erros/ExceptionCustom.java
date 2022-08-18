package com.contacorrente.fourbank.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ExceptionCustom extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8542371574044625406L;

	public ExceptionCustom(String message) {
		super(message);
	}

}
