package com.hbt.semillero.servicios.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;

@Stateless
public class ConsultasBean {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {

		// jpql
		return em.createQuery("select ma from Marca ma").getResultList();
	}

	public List<Linea> consultarLineas(Long idMarca) {

		Query query = em.createQuery("select ln from Linea ln where ln.marca.idLinea =:ID_LINEA");

		query.setParameter("ID_LINEA", idMarca).getResultList();

		return query.getResultList();

	}
}
