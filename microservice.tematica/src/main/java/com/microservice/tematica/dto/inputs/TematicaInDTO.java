/**
 * TematicaInDTO.java
 */
package com.microservice.tematica.dto.inputs;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el DTO con la información de entrada
 * para la tematica
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class TematicaInDTO implements Serializable {

	/**
	 * Atributo que determina el valor para la serializacion
	 */
	private static final long serialVersionUID = -658342157290461882L;

	/**
	 * Atributo que determina el identificador
	 */
	private Integer id;

	/**
	 * Atributo que determina el nombre de la comuna
	 */
	@NotBlank(message = "Ingrese nombre")
	private String nombre;

	/**
	 * Atributo que determina la descripcion
	 */
	private String descripcion;

}
