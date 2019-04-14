package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase que determina la entidad del vendedor
 * @author Dizzi
 *
 */
@Entity
@Table(name = "VENDEDOR")
public class Vendedor implements Serializable {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "ID_VENDEDOR")
	private Long idVendedor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONA")
	private Persona persona;

	@Column(name = "FECHA_INGRESO")
	private Calendar fechaIngreso;

	public String mostrarFechaIngreso() {
		return fechaIngreso.getTime().toString();
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
