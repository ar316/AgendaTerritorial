/**
 * ComunaMapper.java
 */
package com.microservice.ciudades.mappers;

import java.util.List;

import com.microservice.ciudades.dto.inputs.ComunaInDTO;
import com.microservice.ciudades.dto.outputs.ComunaDTO;
import com.microservice.ciudades.entities.Comuna;

/**
 * <b>Descripción:<b> Clase que determina los metodos para realizar la
 * conversion de DTO a clase Entity y viceversa
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public class ComunaMapper {

	/**
	 * 
	 * Constructor de la clase.
	 */
	private ComunaMapper() {
		// constructor vacio
	}

	/**
	 * 
	 * Método encargado de convertir el DTO de entrada a Entity
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO ComunaInDTO
	 * @return Comuna
	 */
	public static Comuna toEntity(ComunaInDTO inDTO) {
		Comuna entity = new Comuna();
		entity.setId(inDTO.getId());
		entity.setNombre(inDTO.getNombre().strip().toUpperCase());
		entity.setDescripcion(inDTO.getDescripcion());
		entity.setLatitud(inDTO.getLatitud());
		entity.setLongitud(inDTO.getLongitud());
		return entity;
	}

	/**
	 * 
	 * Método encargado de convertir de Entity a DTO de salida
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entity Comuna
	 * @return ComunaDTO
	 */
	public static ComunaDTO toDto(Comuna entity) {
		ComunaDTO dto = new ComunaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setDescripcion(entity.getDescripcion());
		dto.setLatitud(entity.getLatitud());
		dto.setLongitud(entity.getLongitud());
		dto.setEstado(entity.getEstado());
		return dto;
	}

	/**
	 * 
	 * Método encargado de convertir una lista de entities a una lista DTO
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entities List<Comuna>
	 * @return List<ComunaDTO>
	 */
	public static List<ComunaDTO> toDtos(List<Comuna> entities) {
		return entities.stream().map(ComunaMapper::toDto).toList();
	}

}
