package com.hbt.semillero.servicios.dto;

import java.io.Serializable;

/**
 * 	DTO de la entidad Linea
 * @author Dizzi
 *
 */
public class LineaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

		private Long idLinea;

		private String nombre;

		private int cilindraje;

		private MarcaDTO marca;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getCilindraje() {
			return cilindraje;
		}

		public void setCilindraje(int cilindraje) {
			this.cilindraje = cilindraje;
		}

		public Long getIdLinea() {
			return idLinea;
		}

		public void setIdLinea(Long idLinea) {
			this.idLinea = idLinea;
		}

		public MarcaDTO getMarca() {
			return marca;
		}

		public void setMarca(MarcaDTO marca) {
			this.marca = marca;
		}
}
