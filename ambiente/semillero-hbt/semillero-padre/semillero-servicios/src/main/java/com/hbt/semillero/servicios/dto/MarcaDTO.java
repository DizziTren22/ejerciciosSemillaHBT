package com.hbt.semillero.servicios.dto;

import java.io.Serializable;

/**
 * DTO de la entidad Marca
 * @author Dizzi
 *
 */
public class MarcaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

		private Long idMarca;
		
		private String nombre;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Long getIdMarca() {
			return idMarca;
		}

		public void setIdMarca(Long idMarca) {
			this.idMarca = idMarca;
		}
}
