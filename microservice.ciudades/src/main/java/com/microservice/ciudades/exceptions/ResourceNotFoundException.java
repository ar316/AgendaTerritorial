/**
 * ResourceNotFoundException.java
 */
package com.microservice.ciudades.exceptions;

/**
 * <b>Descripción:<b> Clase que determina la excepcion cuando no se ha
 * encontrado un recurso
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Atributo que determina el valor para la serializacion
	 */
	private static final long serialVersionUID = -1336145878890648747L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
