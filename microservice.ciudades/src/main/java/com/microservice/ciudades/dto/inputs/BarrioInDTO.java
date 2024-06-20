/**
 * BarrioInDTO.java
 */
package com.microservice.ciudades.dto.inputs;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el DTO con la información de entrada
 * para la barrio
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class BarrioInDTO implements Serializable {

	/**
	 * Atributo que determina el valor para la serializacion
	 */
	private static final long serialVersionUID = -4436539325238673227L;

	/**
	 * Atributo que determina el identificador
	 */
	private Integer id;

	/**
	 * Atributo que determina el identificador de la comuna
	 */
	@NotNull(message = "Asigne comuna")
	private Integer comunaId;

	/**
	 * Atributo que determina el nombre
	 */
	@NotBlank(message = "Ingrese nombre")
	private String nombre;

	/**
	 * Atributo que determina la descripcion
	 */
	private String descripcion;

	/**
	 * Atributo que determina la latitud
	 */
	private BigDecimal latitud;

	/**
	 * Atributo que determina la longitud
	 */
	private BigDecimal longitud;

}
