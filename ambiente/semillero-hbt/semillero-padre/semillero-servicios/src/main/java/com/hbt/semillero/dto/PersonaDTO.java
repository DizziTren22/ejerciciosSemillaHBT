package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Objeto de transferencia que mapea los atributos de la entidad Persona
 * 
 * @author Johnny Soto
 *
 */
public class PersonaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador de la persona.
	 */
	private Long idPersona;

	/**
	 * Numero Identificación
	 */
	private String numeroIdentificacion;
	/**
	 * Tipo de Identificación
	 */
	private String tipoIdentificacion;

	/**
	 * Número telefónico
	 */
	private String numeroTelefonico;

	/**
	 * Nombres
	 */
	private String nombres;

	/**
	 * Apellidos
	 */
	private String apellidos;

	/**
	 * Edad
	 */
	private Long edad;

	/**
	 * Indica si la persona está registrada como comprador.
	 */
	private boolean comprador;

	/**
	 * Indica si la persona está registrada como vendedor.
	 */
	private boolean vendedor;

	/**
	 * Método que obtiene el valor de la propiedad idPersona
	 * 
	 * @return the idPersona
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * Método que asigna el valor de la propiedad idPersona
	 * 
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * Método que obtiene el valor de la propiedad numeroIdentificacion
	 * 
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método que asigna el valor de la propiedad numeroIdentificacion
	 * 
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método que obtiene el valor de la propiedad tipoIdentificacion
	 * 
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * Método que asigna el valor de la propiedad tipoIdentificacion
	 * 
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * Método que obtiene el valor de la propiedad numeroTelefonico
	 * 
	 * @return the numeroTelefonico
	 */
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	/**
	 * Método que asigna el valor de la propiedad numeroTelefonico
	 * 
	 * @param numeroTelefonico the numeroTelefonico to set
	 */
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	/**
	 * Método que obtiene el valor de la propiedad nombres
	 * 
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Método que asigna el valor de la propiedad nombres
	 * 
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Método que obtiene el valor de la propiedad apellidos
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Método que asigna el valor de la propiedad apellidos
	 * 
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Método que obtiene el valor de la propiedad edad
	 * 
	 * @return the edad
	 */
	public Long getEdad() {
		return edad;
	}

	/**
	 * Método que asigna el valor de la propiedad edad
	 * 
	 * @param edad the edad to set
	 */
	public void setEdad(Long edad) {
		this.edad = edad;
	}

	/**
	 * Método que obtiene el valor de la propiedad comprador
	 * 
	 * @return the comprador
	 */
	public boolean isComprador() {
		return comprador;
	}

	/**
	 * Método que asigna el valor de la propiedad comprador
	 * 
	 * @param comprador the comprador to set
	 */
	public void setComprador(boolean comprador) {
		this.comprador = comprador;
	}

	/**
	 * Método que obtiene el valor de la propiedad vendedor
	 * 
	 * @return the vendedor
	 */
	public boolean isVendedor() {
		return vendedor;
	}

	/**
	 * Método que asigna el valor de la propiedad vendedor
	 * 
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}

}
