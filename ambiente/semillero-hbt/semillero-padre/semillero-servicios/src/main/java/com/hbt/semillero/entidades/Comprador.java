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
 * Clase que determina la entidad del comprador
 */
@Entity
@Table(name = "COMPRADOR")
public class Comprador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (generator = "SEQ")
	@Column(name = "ID_COMPRADOR")
	private Long idComprador;

	@Column(name = "FECHA_AFILIACION")
	private Calendar fechaAfiliacion;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONA")
	private Persona persona;

	public String mostrarFechaIngreso() {
		return fechaAfiliacion.getTime().toString();
	}

	public Calendar getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(Calendar fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
