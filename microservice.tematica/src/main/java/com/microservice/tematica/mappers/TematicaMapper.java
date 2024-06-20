/**
 * TematicaMapper.java
 */
package com.microservice.tematica.mappers;

import java.util.List;

import com.microservice.tematica.dto.inputs.TematicaInDTO;
import com.microservice.tematica.dto.outputs.TematicaDTO;
import com.microservice.tematica.entities.Tematica;

/**
 * <b>Descripción:<b> Clase que determina los metodos para realizar la
 * conversion de DTO a clase Entity y viceversa
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public class TematicaMapper {

	/**
	 * 
	 * Constructor de la clase.
	 */
	private TematicaMapper() {
		// constructor vacio
	}

	/**
	 * 
	 * Método encargado de convertir el DTO de entrada a Entity
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO TematicaInDTO
	 * @return Tematica
	 */
	public static Tematica toEntity(TematicaInDTO inDTO) {
		Tematica entity = new Tematica();
		entity.setId(inDTO.getId());
		entity.setNombre(inDTO.getNombre().strip().toUpperCase());
		entity.setDescripcion(inDTO.getDescripcion());
		return entity;
	}

	/**
	 * 
	 * Método encargado de convertir de Entity a DTO de salida
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entity Tematica
	 * @return TematicaDTO
	 */
	public static TematicaDTO toDto(Tematica entity) {
		TematicaDTO dto = new TematicaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setDescripcion(entity.getDescripcion());
		dto.setEstado(entity.getEstado());
		return dto;
	}

	/**
	 * 
	 * Método encargado de convertir una lista de entities a una lista DTO
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param entities List<Tematica>
	 * @return List<TematicaDTO>
	 */
	public static List<TematicaDTO> toDtos(List<Tematica> entities) {
		return entities.stream().map(TematicaMapper::toDto).toList();
	}

}
