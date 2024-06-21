/**
 * DependenciaMapper.java
 */
package com.microservice.dependencia.mappers;

import java.util.List;

import com.microservice.dependencia.dto.inputs.DependenciaInDTO;
import com.microservice.dependencia.dto.outputs.DependenciaDTO;
import com.microservice.dependencia.entities.Dependencia;

/**
 * <b>Descripción:<b> Clase que determina los metodos para realizar la
 * conversion de DTO a clase Entity y viceversa
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public class DependenciaMapper {

	/**
	 * 
	 * Constructor de la clase.
	 */
	private DependenciaMapper() {
		// Constructor vacio
	}

	/**
	 * 
	 * Método encargado de convertir el DTO de entrada a Entity
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO DependenciaInDTO
	 * @return Dependencia
	 */
	public static Dependencia toEntity(DependenciaInDTO inDTO) {
		Dependencia entity = new Dependencia();
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
	 * @param entity Dependencia
	 * @return DependenciaDTO
	 */
	public static DependenciaDTO toDto(Dependencia entity) {
		DependenciaDTO dto = new DependenciaDTO();
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
	 * @param entities List<Dependencia>
	 * @return List<DependenciaDTO>
	 */
	public static List<DependenciaDTO> toDtos(List<Dependencia> entities) {
		return entities.stream().map(DependenciaMapper::toDto).toList();
	}

}
