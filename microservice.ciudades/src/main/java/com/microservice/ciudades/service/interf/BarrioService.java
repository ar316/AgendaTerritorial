/**
 * BarrioService.java
 */
package com.microservice.ciudades.service.interf;

import java.util.List;

import com.microservice.ciudades.dto.inputs.BarrioInDTO;
import com.microservice.ciudades.dto.outputs.BarrioDTO;

/**
 * <b>Descripción:<b> Clase que determina los metodos disponibles para realizar
 * acciones en base a uno o varios barrios
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface BarrioService {

	/**
	 * 
	 * Método encargado de guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO BarrioInDTO
	 */
	void save(BarrioInDTO inDTO);

	/**
	 * 
	 * Método encargado de actualizar los datos de un registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO BarrioInDTO
	 * @return BarrioDTO
	 */
	BarrioDTO update(BarrioInDTO inDTO);

	/**
	 * 
	 * Método encargado de obtener un registro por su identificador
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return BarrioDTO
	 */
	BarrioDTO getById(Integer id);

	/**
	 * 
	 * Método encargado de eliminar un registro por su identificador
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return true si se eliminó el registro, de lo contrario false
	 */
	boolean delete(Integer id);

	/**
	 * 
	 * Método encargado de obtener todos los registros para una comuna
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param comunaId identificador de la comuna
	 * @return List<BarrioDTO>
	 */
	List<BarrioDTO> getAllByComundaId(Integer comunaId);

}
