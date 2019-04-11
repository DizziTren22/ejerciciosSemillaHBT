package com.hbt.semillero.servicios.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.dto.PersonaDTO;

@Local
public interface IConsultasBeanLocal {
	
	public List<Marca> consultarMarcas();
	
	public List<Linea> consultarLineas(Long idMarca);
	
	public void crearPersona(PersonaDTO persona);
	
	public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion);
	
	public void editarPersona(PersonaDTO persona);
}
