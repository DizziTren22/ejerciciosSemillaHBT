package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Objeto de transferencia que mapea los atributos de la entidad Linea
 * 
 * @author Johnny Soto
 *
 */
public class LineaDTO implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador único de la línea
	 */
	private Long idLinea;

	/**
	 * Nombre de la línea.
	 */
	private String nombre;
	/**
	 * Cilindraje
	 */
	private int cilindraje;

	/**
	 * Marca
	 */
	private MarcaDTO marca;

	/**
	 * Método que obtiene el valor de la propiedad idLinea
	 * 
	 * @return the idLinea
	 */
	public Long getIdLinea() {
		return idLinea;
	}

	/**
	 * Método que asigna el valor de la propiedad idLinea
	 * 
	 * @param idLinea the idLinea to set
	 */
	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
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

	/**
	 * Método que obtiene el valor de la propiedad cilindraje
	 * 
	 * @return the cilindraje
	 */
	public int getCilindraje() {
		return cilindraje;
	}

	/**
	 * Método que asigna el valor de la propiedad cilindraje
	 * 
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * Método que obtiene el valor de la propiedad marca
	 * 
	 * @return the marca
	 */
	public MarcaDTO getMarca() {
		return marca;
	}

	/**
	 * Método que asigna el valor de la propiedad marca
	 * 
	 * @param marca the marca to set
	 */
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}

}
