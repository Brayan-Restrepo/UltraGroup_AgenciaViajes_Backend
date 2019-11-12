package com.ultragroup.agenciaviaje.model.hotel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ContactoEmergencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -369386018847033758L;

	@NotNull
	private String nombreCompleto;

	@NotNull
	private String telefono;

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
