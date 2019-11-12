package com.ultragroup.agenciaviaje.model.dto;

import java.io.Serializable;

public class HabilitarDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -662613853361877061L;

	private String idHotel;
	
	private String idHabitacin;
	
	private boolean activo;

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdHabitacin() {
		return idHabitacin;
	}

	public void setIdHabitacin(String idHabitacin) {
		this.idHabitacin = idHabitacin;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
