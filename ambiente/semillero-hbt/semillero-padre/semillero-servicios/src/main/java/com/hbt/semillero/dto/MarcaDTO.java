package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Objeto de transferencia que mapea los atributos de la entidad Marca
 * 
 * @author Johnny Soto
 *
 */
public class MarcaDTO implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificar único de la marca.
	 */
	private Long idMarca;

	/**
	 * Nombre de la Marca
	 */
	private String nombre;

	/**
	 * Método que obtiene el valor de la propiedad idMarca
	 * 
	 * @return the idMarca
	 */
	public Long getIdMarca() {
		return idMarca;
	}

	/**
	 * Método que asigna el valor de la propiedad idMarca
	 * 
	 * @param idMarca the idMarca to set
	 */
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	/**
	 * Método que obtiene el valor de la propiedad nombre
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que asigna el valor de la propiedad nombre
	 * 
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
