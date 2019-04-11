package com.hbt.semillero.servicios.dto;

import java.io.Serializable;

/**
 * DTO de la entidad Persona
 * @author Dizzi
 *
 */
public class PersonaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPersona;

	private String numeroIdentificacion;

	private String tipoIdentificacion;

	private String numeroTelefonico;

	private String nombres;
	
	private String apellidos;

	private Long edad;
	private boolean comprador;
	private boolean vendedor;
	/**
	 * Obtiene el nombre completo de la persona.
	 * 
	 * @return
	 */
	protected String obtenerNombreCompleto() {
		return getNombres() + " " + getApellidos();
	}

	/*
	 * M�todos de acceso y modificadores de atributos
	 */

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

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

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public boolean isComprador() {
		return comprador;
	}

	public void setComprador(boolean comprador) {
		this.comprador = comprador;
	}

	public boolean isVendedor() {
		return vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}
}
