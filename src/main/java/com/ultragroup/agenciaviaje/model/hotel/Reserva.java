package com.ultragroup.agenciaviaje.model.hotel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reserva")
public class Reserva implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4219276929889189770L;

	@Id
    @NotNull
    private String id = ObjectId.get().toHexString();

    @NotNull
    private String habitacionId;
	
	@NotNull
	private Date fechaEntrada;
	
	@NotNull
	private Date fechaSalida;
	
	@NotNull
	private List<Huesped> huespedes;
	
	@NotNull
	private ContactoEmergencia contactoEmergencia;

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

	public List<Huesped> getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(List<Huesped> huespedes) {
		this.huespedes = huespedes;
	}

	public ContactoEmergencia getContactoEmergencia() {
		return contactoEmergencia;
	}

	public void setContactoEmergencia(ContactoEmergencia contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHabitacionId() {
		return habitacionId;
	}

	public void setHabitacionId(String habitacionId) {
		this.habitacionId = habitacionId;
	}
	
}
