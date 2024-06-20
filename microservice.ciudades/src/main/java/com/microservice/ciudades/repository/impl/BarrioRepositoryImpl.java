/**
 * BarrioRepositoryImpl.java
 */
package com.microservice.ciudades.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.microservice.ciudades.entities.Barrio;
import com.microservice.ciudades.entities.Comuna;
import com.microservice.ciudades.repository.custom.CustomRepositoryImpl;
import com.microservice.ciudades.repository.interf.BarrioRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version
 */
@Log4j2
@Repository(value = "barrioRepository")
public class BarrioRepositoryImpl extends CustomRepositoryImpl<Barrio, Integer> implements BarrioRepository {

	/**
	 * @see com.microservice.ciudades.repository.interf.BarrioRepository#getAllById(java.lang.Integer)
	 */
	@Override
	public Optional<Barrio> getAllById(Integer id) {
		log.debug("Inicio método: getAllById");
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Barrio> criteriaQuery = criteriaBuilder.createQuery(Barrio.class);
		Root<Barrio> root = criteriaQuery.from(Barrio.class);
		root.fetch("comuna", JoinType.LEFT);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
		log.debug("Fin método: getAllById");
		return this.entityManager.createQuery(criteriaQuery).getResultList().stream().findFirst();
	}

	/**
	 * @see com.microservice.ciudades.repository.interf.BarrioRepository#getAllByComunaId(java.lang.Integer)
	 */
	@Override
	public List<Barrio> getAllByComunaId(Integer comunaId) {
		log.debug("Inicio método: getAllByComunaId");
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Barrio> criteriaQuery = criteriaBuilder.createQuery(Barrio.class);
		Root<Barrio> root = criteriaQuery.from(Barrio.class);
		Join<Barrio, Comuna> joinComuna = root.join("comuna", JoinType.LEFT);
		criteriaQuery.select(root).where(criteriaBuilder.equal(joinComuna.get("id"), comunaId))
				.orderBy(criteriaBuilder.asc(root.get("nombre")));
		log.debug("Fin método: getAllByComunaId");
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

}
