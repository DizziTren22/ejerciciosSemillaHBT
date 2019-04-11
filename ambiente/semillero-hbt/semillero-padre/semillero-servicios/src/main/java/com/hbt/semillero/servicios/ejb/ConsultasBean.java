package com.hbt.semillero.servicios.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.dto.PersonaDTO;
import com.hbt.semillero.servicios.ejb.interfaces.IConsultasBeanLocal;
/**
 * Clase encargada de los metodos a usar en los servicios
 * @author Dizzi
 *
 */
@Stateless
public class ConsultasBean implements IConsultasBeanLocal{

	@PersistenceContext
	private EntityManager em;

/**
 * Metodo encargado de consultar todas las marcas
 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {

		// jpql
		return em.createQuery("select ma from Marca ma").getResultList();
	}
/**
 * Metodo encargado de consultar las lineas por id de marca
 */
	public List<Linea> consultarLineas(Long idMarca) {

		Query query = em.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca");

		query.setParameter("idMarca", idMarca).getResultList();

		return query.getResultList();

	}
	
	/**
	 * Metodo encargado de crear una persona
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		 Persona persona = new Persona();
		 persona.setNombres(personaDTO.getNombres());
		 persona.setApellidos(personaDTO.getApellidos());
		 persona.setEdad(personaDTO.getEdad());
		 persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		 persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		 persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		 
		 em.persist(persona);
		 
		 if (personaDTO.isComprador()) {
			 Comprador comprador = new Comprador();
			 comprador.setFechaAfiliacion(Calendar.getInstance());
			 comprador.setPersona(persona);
			 em.persist(comprador);
		 }
		 
		 if (personaDTO.isVendedor()) {
			 Vendedor vendedor = new Vendedor();
			 vendedor.setFechaIngreso(Calendar.getInstance());
			 vendedor.setPersona(persona);
			 em.persist(vendedor);
		 }
	}
	/**
	 * Metodo encargado de consultar las personas por los datos parametrizados
	 */
	public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion) {

		Query query = em.createQuery("Select per from Persona per where per.tipoIdentificacion=:tipoIdentificacion and per.numeroIdentificacion=:numeroIdentificacion");

		query.setParameter("tipoIdentificacion", tipoIdentificacion);
		
		query.setParameter("numeroIdentificacion", numeroIdentificacion);

		return query.getResultList();

	}
	/**
	 * Metodo encargado de editar una persona
	 */
	public void editarPersona(PersonaDTO personaDTO) {
		Persona personaActual = em.find(Persona.class, personaDTO.getIdPersona());
		
		personaActual.setNombres(personaDTO.getNombres());
		personaActual.setApellidos(personaDTO.getApellidos());
		personaActual.setEdad(personaDTO.getEdad());
		personaActual.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		personaActual.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		 
		 em.merge(personaActual);
		 
		 if (personaDTO.isComprador()) {
			 Comprador comprador = new Comprador();
			 comprador.setFechaAfiliacion(Calendar.getInstance());
			 comprador.setPersona(personaActual);
			 em.persist(comprador);
		 }
		 
		 if (personaDTO.isVendedor()) {
			 Vendedor vendedor = new Vendedor();
			 vendedor.setFechaIngreso(Calendar.getInstance());
			 vendedor.setPersona(personaActual);
			 em.persist(vendedor);
		 }
	}
}
