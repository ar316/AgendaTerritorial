/**
 * NullParameterException.java
 */
package com.microservice.ciudades.exceptions;

/**
 * <b>Descripción:<b> Clase que determina la implementacion para controlar las
 * excepciones de parametros nulos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public class NullParameterException extends RuntimeException {

	/**
	 * Atributo para la serializacion
	 */
	private static final long serialVersionUID = -1917700637570684772L;

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param message mensaje
	 */
	public NullParameterException(String message) {
		super(message);
	}

}
