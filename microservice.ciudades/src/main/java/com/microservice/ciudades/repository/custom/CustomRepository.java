package com.microservice.ciudades.repository.custom;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * <b>Descripción:<b> Clase generica que determina los metodos para interactuar
 * con la base de datos
 *
 * @param <T> Nombre de clase entity
 * @param <K> Tipo de dato del identificador de la clase entity
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface CustomRepository<T, K extends Serializable> {

	/**
	 * 
	 * Metodo encargado de Guarda/Persistir una entidad
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entity objeto entity con los datos a guardar
	 */
	void save(T entity);

	/**
	 * 
	 * Metodo encargado de Actualizar una entidad
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entity objeto entity con los datos a actualizar
	 * @return entity actualizado
	 */
	T update(T entity);

	/**
	 * 
	 * Metodo encargado de Retornar un Optional que contiene una clase entity
	 * buscado por su identificador de la clase entity.
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador de la clase entity
	 * @return Optional de tipo entity, o Optional.Empty si la entidad no existe.
	 */
	Optional<T> getById(K id);

	/**
	 * 
	 * Método encargado de eliminar un objeto entity
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entity objeto entity a eliminar
	 */
	void delete(T entity);

	/**
	 * 
	 * Metodo encargado de contar y Retorna el total de registrso de la clase entity
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @return total de registros de la clase entity
	 */
	Long countAll();

	/**
	 * 
	 * Método encargado de obtener todos los registros
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @return Lista de registros
	 */
	List<T> getAll();

}
