package com.ultragroup.agenciaviaje.model.hotel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Huesped implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8058104573018616525L;

	@Id
    @NotNull
    private String id = ObjectId.get().toHexString();
	
	@NotNull
	private String nombres;
	
	@NotNull
	private String apellidos;
	
	@NotNull
	private String fechaNacimiento;
	
	@NotNull
	private String genero;
	
	@NotNull
	private String tipoDocumento;
	
	@NotNull
	private String numeroDocumento;
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefono;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
}
