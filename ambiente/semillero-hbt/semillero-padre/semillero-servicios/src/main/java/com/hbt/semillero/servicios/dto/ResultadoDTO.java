package com.hbt.semillero.servicios.dto;

import java.io.Serializable;

/**
 * DTO para retornar boolean o mensajes sobre algun servicio
 * @author Dizzi
 *
 */
public class ResultadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean exitoso;
	
	private String mensaje;

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
