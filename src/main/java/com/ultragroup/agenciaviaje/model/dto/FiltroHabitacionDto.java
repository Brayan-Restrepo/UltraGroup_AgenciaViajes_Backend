package com.ultragroup.agenciaviaje.model.dto;

import java.io.Serializable;
import java.util.Date;


public class FiltroHabitacionDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7856907824187205938L;
	
	private String ciudad;	
	private String cantidadPersona;	
	private Date fechaEntrada;
	private Date fechaSalida;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCantidadPersona() {
		return cantidadPersona;
	}

	public void setCantidadPersona(String cantidadPersona) {
		this.cantidadPersona = cantidadPersona;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}	
}
