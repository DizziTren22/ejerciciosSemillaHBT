package com.hbt.semillero.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad de vehiculo.
 */
@Entity
@Table(name = "VEHICULO")
public class Vehiculo {

	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "ID_VEHICULO")
	private Long idVehiculo;

	@Column(name = "MODELO")
	private int modelo;

	@Column(name = "PLACA")
	private String placa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LINEA")
	private Linea linea;

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

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

}
