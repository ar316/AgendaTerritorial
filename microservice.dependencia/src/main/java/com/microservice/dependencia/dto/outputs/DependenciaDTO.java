/**
 * DependenciaDTO.java
 */
package com.microservice.dependencia.dto.outputs;

import java.io.Serializable;

import com.microservice.dependencia.enums.EstadoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el DTO con la información de salida de
 * una dependencia
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class DependenciaDTO implements Serializable {

	/**
	 * Atributo que determina
	 */
	private static final long serialVersionUID = 1652794283737009543L;

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
