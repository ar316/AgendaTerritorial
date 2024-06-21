package com.microservice.dependencia.dto.outputs;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * <b>Descripción:<b> Clase que determina el DTO para la validacion de los
 * campos de los dto de entrada y parametros en los metodos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class FieldsValidationDTO implements Serializable {

	/**
	 * Atributo para la serializacion
	 */
	private static final long serialVersionUID = -1041382647769377005L;

	/**
	 * Atributo que determina el nombre del campo/atributo/propiedad
	 */
	private String fieldName;

	/**
	 * Atributo que determina el contenido del mensaje
	 */
	private String message;

}
