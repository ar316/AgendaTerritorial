/**
 * BarrioMapper.java
 */
package com.microservice.ciudades.mappers;

import java.util.List;

import com.microservice.ciudades.dto.inputs.BarrioInDTO;
import com.microservice.ciudades.dto.outputs.BarrioDTO;
import com.microservice.ciudades.entities.Barrio;

/**
 * <b>Descripción:<b> Clase que determina los metodos para realizar la
 * conversion de DTO a clase Entity y viceversa
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public final class BarrioMapper {

	/**
	 * 
	 * Constructor de la clase.
	 */
	private BarrioMapper() {
		// Constructor vacio
	}

	/**
	 * 
	 * Método encargado de convertir el DTO de entrada a Entity
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO BarrioInDTO
	 * @return Barrio
	 */
	public static Barrio toEntity(BarrioInDTO inDTO) {
		Barrio entity = new Barrio();
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
	 * @param entity Barrio
	 * @return BarrioDTO
	 */
	public static BarrioDTO toDto(Barrio entity) {
		BarrioDTO dto = new BarrioDTO();
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
	 * @param entities List<Barrio>
	 * @return List<BarrioDTO>
	 */
	public static List<BarrioDTO> toDtos(List<Barrio> entities) {
		return entities.stream().map(BarrioMapper::toDto).toList();
	}

}
