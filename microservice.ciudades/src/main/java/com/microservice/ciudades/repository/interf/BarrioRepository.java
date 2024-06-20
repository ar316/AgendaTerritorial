/**
 * BarrioRepository.java
 */
package com.microservice.ciudades.repository.interf;

import java.util.List;
import java.util.Optional;

import com.microservice.ciudades.entities.Barrio;
import com.microservice.ciudades.repository.custom.CustomRepository;

/**
 * <b>Descripción:<b> Clase que determina la clase con los metodos para
 * interacción con la base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface BarrioRepository extends CustomRepository<Barrio, Integer> {

	/**
	 * 
	 * Método encargado de obtener un registro con sus relaciones
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return Optional<Barrio> si existe, de lo contrario Empty
	 */
	Optional<Barrio> getAllById(Integer id);

	/**
	 * 
	 * Método encargado de obtener todos los registros que pertenecen a una comuna
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param comunaId identificador de comuna
	 * @return List<Barrio>
	 */
	List<Barrio> getAllByComunaId(Integer comunaId);

}
