package com.ultragroup.agenciaviaje.model.hotel;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotel")
public class Hotel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7925035277376945398L;

	@Id
    @NotNull
    private String id;

    @NotNull
	private boolean activo;
    
    @NotNull
	private String nombre;
    
    @NotNull
	private String ciudad;
    
    @NotNull
	private String direccion;
    
    @NotNull
	private String estrella;
    
    @NotNull
	private String portadaUrl;
    
    @NotNull
	private List<Habitacion> habitaciones;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstrella() {
		return estrella;
	}

	public void setEstrella(String estrella) {
		this.estrella = estrella;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getPortadaUrl() {
		return portadaUrl;
	}

	public void setPortadaUrl(String portadaUrl) {
		this.portadaUrl = portadaUrl;
	}
    
}
