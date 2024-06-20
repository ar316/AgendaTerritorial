/**
 * ComunaService.java
 */
package com.microservice.ciudades.service.interf;

import java.util.List;

import com.microservice.ciudades.dto.inputs.ComunaInDTO;
import com.microservice.ciudades.dto.outputs.ComunaDTO;

/**
 * <b>Descripción:<b> Clase que determina los metodos disponibles para realizar
 * acciones en base a una o varias comunas
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface ComunaService {

	/**
	 * 
	 * Método encargado de guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO ComunaInDTO
	 */
	void save(ComunaInDTO inDTO);

	/**
	 * 
	 * Método encargado de actualizar los datos de un registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO ComunaInDTO
	 * @return ComunaDTO
	 */
	ComunaDTO update(ComunaInDTO inDTO);

	/**
	 * 
	 * Método encargado de obtener un registro por su identificador
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return ComunaDTO
	 */
	ComunaDTO getById(Integer id);

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
	 * @return List<ComunaDTO>
	 */
	List<ComunaDTO> getAll();

}
