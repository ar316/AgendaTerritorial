/**
 * TematicaDTO.java
 */
package com.microservice.tematica.dto.outputs;

import java.io.Serializable;

import com.microservice.tematica.enums.EstadoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el DTO con la información de salida de
 * una tematica
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class TematicaDTO implements Serializable {

	/**
	 * Atributo que determina el valor para la serializacion
	 */
	private static final long serialVersionUID = 7738114067021775782L;

	/**
	 * Atributo que determina el identificador
	 */
	private Integer id;

	/**
	 * Atributo que determina el nombre
	 */
	private String nombre;

	/**
	 * Atributo que determina la descripcion
	 */
	private String descripcion;

	/**
	 * Atributo que determina el estado
	 */
	private EstadoEnum estado;

}
