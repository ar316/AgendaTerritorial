/**
 * DependenciaInDTO.java
 */
package com.microservice.dependencia.dto.inputs;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el DTO con la información de entrada
 * para la dependencia
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class DependenciaInDTO implements Serializable {

	/**
	 * Atributo que determina
	 */
	private static final long serialVersionUID = -7683403860461044019L;

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
