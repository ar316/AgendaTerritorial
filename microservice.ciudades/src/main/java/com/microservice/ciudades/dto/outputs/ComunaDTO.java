/**
 * ComunaDTO.java
 */
package com.microservice.ciudades.dto.outputs;

import java.io.Serializable;
import java.math.BigDecimal;

import com.microservice.ciudades.enums.EstadoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el DTO con la información de salida de
 * una comuna
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ComunaDTO implements Serializable {

	/**
	 * Atributo que determina el valor para la serializacion
	 */
	private static final long serialVersionUID = 5574017805375871589L;

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
	 * Atributo que determina la latitud
	 */
	private BigDecimal latitud;

	/**
	 * Atributo que determina la longitud
	 */
	private BigDecimal longitud;

	/**
	 * Atributo que determina el estado
	 */
	private EstadoEnum estado;

}
