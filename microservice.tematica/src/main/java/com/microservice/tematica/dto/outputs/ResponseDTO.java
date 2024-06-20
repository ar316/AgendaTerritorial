package com.microservice.tematica.dto.outputs;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * <b>Descripción:<b> Clase que determina el DTO de respuesta para las
 * solicitudes
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 * @param <T> Clase con el contenido de la respuesta
 */
@Getter
@Setter
public class ResponseDTO<T> implements Serializable {

	/**
	 * Atributo para la serializacion
	 */
	private static final long serialVersionUID = -1061559648083806099L;

	/**
	 * Atributo que determina el estado del resultado
	 */
	private boolean status;

	/**
	 * Atributo que determina el codigo de estado de respuesta http
	 */
	private int codeStatus;

	/**
	 * Atributo que determina el mensaje de informacion de la respuesta
	 */
	private String message;

	/**
	 * Atributo que determina la clase con los datos de la respuesta
	 */
	private T data;

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param status     true si es correcto, de lo contrario false
	 * @param httpStatus respuesta Http
	 * @param message    mensaje de la respuesta
	 */
	public ResponseDTO(boolean status, HttpStatus httpStatus, String message) {
		this.status = status;
		this.codeStatus = httpStatus.value();
		this.message = message;
	}

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param status     true si es correcto, de lo contrario false
	 * @param httpStatus respuesta Http
	 * @param message    mensaje de la respuesta
	 * @param data       tipo de datos de la respuesta
	 */
	public ResponseDTO(boolean status, HttpStatus httpStatus, String message, T data) {
		this.status = status;
		this.codeStatus = httpStatus.value();
		this.message = message;
		this.data = data;
	}

}
