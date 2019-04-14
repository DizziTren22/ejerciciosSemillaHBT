package com.hbt.semillero.servicios.ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.VehiculoDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vehiculo;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal;

/**
 * EJB de consultas
 */
@Stateless
public class ConsultasEJB implements IConsultasEjbLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * {@link com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal#consultarMarcasExistentes()}
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<MarcaDTO> consultarMarcasExistentes() {
		List<Marca> marcas = em.createQuery("Select ma from Marca ma").getResultList();
		List<MarcaDTO> marcasRetorno = new ArrayList<>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDto = construirMarcaDTO(marca);
			marcasRetorno.add(marcaDto);
		}
		return marcasRetorno;
	}

	/**
	 * {@link com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal#consultarLineasPorMarca(Long)}
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<LineaDTO> consultarLineasPorMarca(Long idMarca) {
		List<Linea> lineas = em
				.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca ")
				.setParameter("idMarca", idMarca).getResultList();
		List<LineaDTO> lineasRetorno = new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setNombre(linea.getNombre());
			lineaDTO.setCilindraje(linea.getCilindraje());
			lineaDTO.setMarca(construirMarcaDTO(linea.getMarca()));
			lineasRetorno.add(lineaDTO);
		}
		return lineasRetorno;
	}

	/**
	 * {@link com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal#consultarPersonas(String, String)}
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas(String tipoID, String numID) {
		StringBuilder consulta = new StringBuilder("Select per FROM Persona per WHERE 1=1 ");
		Map<String, Object> parametros = new HashMap<>();
		if (tipoID != null) {
			consulta.append(" and per.tipoIdentificacion =:tipoID");
			parametros.put("tipoID", tipoID);
		}
		if (numID != null) {
			consulta.append(" and per.numeroIdentificacion =:numID");
			parametros.put("numID", numID);
		}
		Query query = em.createQuery(consulta.toString());

		for (Entry<String, Object> entry : parametros.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<Persona> personas = query.getResultList();
		List<PersonaDTO> personasRetorno = new ArrayList<>();
		for (Persona persona : personas) {
			PersonaDTO vehiculoDTO = new PersonaDTO();
			vehiculoDTO.setNombres(persona.getNombres());
			vehiculoDTO.setApellidos(persona.getApellidos());
			vehiculoDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			vehiculoDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			vehiculoDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			vehiculoDTO.setEdad(persona.getEdad());

			personasRetorno.add(vehiculoDTO);
		}
		return personasRetorno;
	}

	/**
	 * {@link com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal#crearPersona(PersonaDTO)}
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO crearPersona(PersonaDTO vehiculoDTO) {
		try {
			Persona persona = asignarAtributosBasicos(vehiculoDTO);
			em.persist(persona);
			if (vehiculoDTO.isComprador()) {
				Comprador comprador = new Comprador();
				comprador.setPersona(persona);
				comprador.setFechaAfiliacion(Calendar.getInstance());
				em.persist(comprador);
			}
			if (vehiculoDTO.isVendedor()) {
				Vendedor vendedor = new Vendedor();
				vendedor.setFechaIngreso(Calendar.getInstance());
				vendedor.setPersona(persona);
				em.persist(vendedor);
			}
		} catch (Exception e) {
			return new ResultadoDTO(false, e.getMessage());
		}

		return new ResultadoDTO(true, "Creado de forma exitosa");
	}

	/**
	 * Asigna los atributos básicos de la persona
	 * 
	 * @param persona
	 * @param vehiculoDTO
	 */
	private Persona asignarAtributosBasicos(PersonaDTO vehiculoDTO) {
		Persona persona = new Persona();
		persona.setNombres(vehiculoDTO.getNombres());
		persona.setApellidos(vehiculoDTO.getApellidos());
		persona.setNumeroIdentificacion(vehiculoDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(vehiculoDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(vehiculoDTO.getNumeroTelefonico());
		persona.setEdad(vehiculoDTO.getEdad());
		return persona;
	}

	/**
	 * Metodo encargado de consultar los vehiculos por id de linea
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<VehiculoDTO> consultarVehiculosPorLinea(Long idLinea) {
		List<Vehiculo> vehiculos = em
				.createQuery("Select vh from Vehiculo vh JOIN FETCH vh.linea where vh.linea.idLinea=:idLinea ")
				.setParameter("idLinea", idLinea).getResultList();
		List<VehiculoDTO> vehiculosRetorno = new ArrayList<>();
		for (Vehiculo vehiculo : vehiculos) {
			VehiculoDTO vehiculoDTO = new VehiculoDTO();

			vehiculoDTO.setModelo(vehiculo.getModelo());
			vehiculoDTO.setPlaca(vehiculo.getPlaca());
			vehiculoDTO.setIdVehiculo(vehiculo.getIdVehiculo());
			vehiculoDTO.setLinea(construirLineaDTO(vehiculo.getLinea()));
			vehiculosRetorno.add(vehiculoDTO);
		}
		return vehiculosRetorno;
	}

	/**
	 * Construye un DTO de LineaDTO
	 * 
	 * @param marca
	 * @return
	 */
	private LineaDTO construirLineaDTO(Linea linea) {
		LineaDTO lineaDTO = new LineaDTO();
		lineaDTO.setIdLinea(linea.getIdLinea());
		lineaDTO.setCilindraje(linea.getCilindraje());
		lineaDTO.setNombre(linea.getNombre());
		return lineaDTO;
	}

	/**
	 * Construye un DTO de MarcaDTO
	 * 
	 * @param marca
	 * @return
	 */
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDto = new MarcaDTO();
		marcaDto.setIdMarca(marca.getIdMarca());
		marcaDto.setNombre(marca.getNombre());
		return marcaDto;
	}

	/**
	 * Construye un DTO de MarcaDTO
	 * 
	 * @param marca
	 * @return marcaDto
	 */
	private MarcaDTO construirMarcaDTOLista(Marca marca) {
		MarcaDTO marcaDto = new MarcaDTO();
		marcaDto.setIdMarca(marca.getIdMarca());
		marcaDto.setNombre(marca.getNombre());
		return marcaDto;
	}

	/**
	 * Metodo encargado de editar una persona
	 */
	public void editarVehiculo(VehiculoDTO vehiculoDTO) {
		Vehiculo vehiculoActual = em.find(Vehiculo.class, vehiculoDTO.getIdVehiculo());

		vehiculoActual.setModelo(vehiculoDTO.getModelo());
		vehiculoActual.setPlaca(vehiculoDTO.getPlaca());

		em.merge(vehiculoActual);
	}

	/**
	 * metodo encargado de eliminar un vehiculo
	 */
	public void eliminarVehiculo(Long idVehiculo) {
		em.createQuery("DELETE FROM Vehiculo vh " + "where vh.idVehiculo =:idVehiculo ").setParameter("idVehiculo",
				idVehiculo);
		VehiculoDTO vehiculo = new VehiculoDTO();
		vehiculo.setIdVehiculo(idVehiculo);
		em.remove(vehiculo.getIdVehiculo());
	}
}
