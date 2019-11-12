package com.ultragroup.agenciaviaje.model.hotel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Habitacion implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7600974343347245226L;

	@Id
    @NotNull
    private String id = ObjectId.get().toHexString();
	 
	@NotNull
	private boolean activo;
    
    @NotNull
	private String costoBase;
    
    @NotNull
	private String impuesto;
    
    @NotNull
	private String tipoHabitacion;
    
    @NotNull
	private String piso;
    
    @NotNull
	private String nuemeroHabitacion;
    
    @NotNull
	private String cantidadPersona;
    
//    @NotNull
//	private List<Reserva> reservas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(String costoBase) {
		this.costoBase = costoBase;
	}

	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getNuemeroHabitacion() {
		return nuemeroHabitacion;
	}

	public void setNuemeroHabitacion(String nuemeroHabitacion) {
		this.nuemeroHabitacion = nuemeroHabitacion;
	}

	public String getCantidadPersona() {
		return cantidadPersona;
	}

	public void setCantidadPersona(String cantidadPersona) {
		this.cantidadPersona = cantidadPersona;
	}
//
//	public List<Reserva> getReservas() {
//		return reservas;
//	}
//
//	public void setReservas(List<Reserva> reservas) {
//		this.reservas = reservas;
//	}
    
}
