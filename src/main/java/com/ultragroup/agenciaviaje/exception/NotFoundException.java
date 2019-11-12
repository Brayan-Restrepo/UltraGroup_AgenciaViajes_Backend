package com.ultragroup.agenciaviaje.exception;

import org.springframework.core.NestedRuntimeException;

public class NotFoundException extends NestedRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6174834935725638124L;

	public NotFoundException(String msg) {
        super(String.format("User with  Id '%s' not founded", msg));
	}

}
