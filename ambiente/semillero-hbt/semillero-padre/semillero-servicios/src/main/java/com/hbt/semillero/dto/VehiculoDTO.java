package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Clase que determina el dto del vehiculo
 * @author Dizzi
 *
 */
public class VehiculoDTO implements Serializable {

	/**
	 * Atributo que determina el serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que determina el idVehiculo
	 */
	private Long idVehiculo;

	/**
	 * Atributo que determina el modelo
	 */
	private int modelo;

	/**
	 * Atributo que determina el placa
	 */
	private String placa;

	/**
	 * Atributo que determina el linea
	 */
	private LineaDTO linea;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LineaDTO getLinea() {
		return linea;
	}

	public void setLinea(LineaDTO linea) {
		this.linea = linea;
	}
}
