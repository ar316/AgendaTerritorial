package com.microservice.ciudades.repository.custom;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import com.microservice.ciudades.utils.ValidacionesUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * <b>Descripción:<b> Clase que determina la implementacion de los metodos
 * genericos de la interfaz CustomRepository y metodos necesarios para la
 * persistencia y consulta de la informacion con la base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version
 * @param <T> clase entity
 * @param <K> Tipo de dato del identificador de la clase Entity
 */
@Log4j2
public abstract class CustomRepositoryImpl<T, K extends Serializable> implements CustomRepository<T, K> {

	/**
	 * Atributo correspondiente EntityManager para la persitencia
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Clase Entity para la persistencia
	 */
	private Class<T> persistentClass;

	/**
	 * 
	 * Constructor de la clase.
	 */

	@SuppressWarnings("unchecked")
	protected CustomRepositoryImpl() {
		log.debug("Inicio metodo: CustomRepositoryImpl");
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * @see com.ceyic.bodega.repository.custom.CustomRepository#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		log.debug("Inicio metodo: save");
		ValidacionesUtil.validarObject(entity);
		this.entityManager.persist(entity);
		log.debug("Fin metodo: save");
	}

	/**
	 * @see com.ceyic.bodega.repository.custom.CustomRepository#update(java.lang.Object)
	 */
	@Override
	public T update(T entity) {
		log.debug("Inicio metodo: update");
		ValidacionesUtil.validarObject(entity);
		entity = this.entityManager.merge(entity);
		log.debug("Fin metodo: update");
		return entity;
	}

	/**
	 * @see com.ceyic.bodega.repository.custom.CustomRepository#getById(java.io.Serializable)
	 */
	@Override
	public Optional<T> getById(K id) {
		log.debug("Inicio metodo: getById");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<T> optional = Optional.ofNullable(this.entityManager.find(this.persistentClass, id));
		log.debug("Fin metodo: getById");
		return optional;
	}

	/**
	 * 
	 * @see com.ceyic.bodega.repository.custom.CustomRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		log.debug("Inicio metodo: delete");
		ValidacionesUtil.validarObject(entity);
		this.entityManager.remove(entity);
	}

	/**
	 * @see com.ceyic.bodega.repository.custom.CustomRepository#countAll()
	 */
	@Override
	public Long countAll() {
		log.debug("Inicio metodo: countAll");
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<T> root = countQuery.from(this.persistentClass);
		countQuery.select(criteriaBuilder.count(root));
		log.debug("Fin metodo: countAll");
		return this.entityManager.createQuery(countQuery).getSingleResult();
	}

	/**
	 * 
	 * @see com.microservice.ciudades.repository.custom.CustomRepository#getAll()
	 */
	@Override
	public List<T> getAll() {
		log.debug("Inicio metodo: getAll");
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		Root<T> root = criteriaQuery.from(this.persistentClass);
		criteriaQuery.select(root);
		log.debug("Fin metodo: getAll");
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

}
