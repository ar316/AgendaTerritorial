/**
 * TematicaService.java
 */
package com.microservice.tematica.service.interf;

import java.util.List;

import com.microservice.tematica.dto.inputs.TematicaInDTO;
import com.microservice.tematica.dto.outputs.TematicaDTO;

/**
 * <b>Descripción:<b> Clase que determina los metodos disponibles para realizar
 * acciones en base a una o varias tematicas
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface TematicaService {

	/**
	 * 
	 * Método encargado de guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO TematicaInDTO
	 */
	void save(TematicaInDTO inDTO);

	/**
	 * 
	 * Método encargado de actualizar los datos de un registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO TematicaInDTO
	 * @return TematicaDTO
	 */
	TematicaDTO update(TematicaInDTO inDTO);

	/**
	 * 
	 * Método encargado de obtener un registro por su identificador
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return TematicaDTO
	 */
	TematicaDTO getById(Integer id);

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
	 * Método encargado de obtener todos los registros
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @return List<TematicaDTO>
	 */
	List<TematicaDTO> getAll();

}
