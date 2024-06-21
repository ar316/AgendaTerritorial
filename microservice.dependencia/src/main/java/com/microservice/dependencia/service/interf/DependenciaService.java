/**
 * DependenciaService.java
 */
package com.microservice.dependencia.service.interf;

import java.util.List;

import com.microservice.dependencia.dto.inputs.DependenciaInDTO;
import com.microservice.dependencia.dto.outputs.DependenciaDTO;

/**
 * <b>Descripción:<b> Clase que determina los metodos disponibles para realizar
 * acciones para la dependencia
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface DependenciaService {

	/**
	 * 
	 * Método encargado de guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO DependenciaInDTO
	 */
	void save(DependenciaInDTO inDTO);

	/**
	 * 
	 * Método encargado de actualizar los datos de un registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO DependenciaInDTO
	 * @return DependenciaDTO
	 */
	DependenciaDTO update(DependenciaInDTO inDTO);

	/**
	 * 
	 * Método encargado de obtener un registro por su identificador
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return DependenciaDTO
	 */
	DependenciaDTO getById(Integer id);

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
	 * @return List<DependenciaDTO>
	 */
	List<DependenciaDTO> getAll();

}
