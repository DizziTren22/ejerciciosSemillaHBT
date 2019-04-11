package com.hbt.semillero.servicios.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.dto.LineaDTO;
import com.hbt.semillero.servicios.dto.MarcaDTO;
import com.hbt.semillero.servicios.dto.PersonaDTO;
import com.hbt.semillero.servicios.dto.ResultadoDTO;
import com.hbt.semillero.servicios.ejb.interfaces.IConsultasBeanLocal;

/**
 * Clase encargada de contener los servicios a usar
 * @author Dizzi
 *
 */
@Path("/ServiciosRest")
public class ServiciosRest {

	/**
	 * Instancia del ejb 
	 */
	@EJB
	private IConsultasBeanLocal consultasBeanLocal;

	/**
	 * Metodo encargado de consultar las marcas
	 * @return retorno
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas() {

		List<Marca> marcas = consultasBeanLocal.consultarMarcas();

		List<MarcaDTO> retorno = new ArrayList<>();
		for (Marca marca : marcas) {
	MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}
		return retorno;

	}
	
	/**
	 * Metodo encargado de consultar las lineas por datos parametrizados
	 * @return retorno
	 */
	@GET
	@Path("/consultarLineas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineas(@QueryParam(value = "idMarca") Long idMarca) {

		List<Linea> lineas = consultasBeanLocal.consultarLineas(idMarca);

		List<LineaDTO> retorno = new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setCilindraje(linea.getCilindraje());
			lineaDTO.setNombre(linea.getNombre());
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);
			retorno.add(lineaDTO);
		}
		return retorno;

	}
	
	/**
	 * metodo encargado de construir el dto a partir de la entidad
	 * @param marca
	 * @return
	 */
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO lineaDTO = new MarcaDTO();
		lineaDTO.setIdMarca(marca.getIdMarca());
		lineaDTO.setNombre(marca.getNombre());
		return lineaDTO;
	}
	
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		
		try {
			consultasBeanLocal.crearPersona(personaDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensaje("No se pudo crear una persona" + e);
		}
		
		return resultadoDTO;
	}
	
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(@QueryParam(value = "tipoIdentificacion") String tipoIdentificacion, @QueryParam(value = "numeroIdentificacion")  String numeroIdentificacion ) {

		List<Persona> personas = consultasBeanLocal.consultarPersonas(tipoIdentificacion, numeroIdentificacion);

		List<PersonaDTO> retorno = new ArrayList<>();
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setIdPersona(persona.getIdPersona());
			personaDTO.setEdad(persona.getEdad());
			personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
			retorno.add(personaDTO);
		}
		return retorno;
	}
	
	@PUT
	@Path("/editarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO editarPersona(PersonaDTO personaDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		
		try {
			consultasBeanLocal.editarPersona(personaDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensaje("No se pudo editar una persona" + e);
		}
		
		return resultadoDTO;
	}
}
