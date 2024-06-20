/**
 * ValidacionesUtil.java
 */
package com.microservice.ciudades.utils;

import java.util.Objects;

import com.microservice.ciudades.exceptions.NullParameterException;

import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina implementaciones para realizar
 * distintas validaciones y retornar una exception
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Log4j2
public class ValidacionesUtil {

	/**
	 * 
	 * Método encargado de realizar la validacion si un parametro de cualquier tipo
	 * es null. Si se realiza la validación retorna una exception de tipo
	 * NullParameterException
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param param     parametro de cualquie tipo de dato
	 * @param nameParam nombre del parametro
	 */
	public static void validarParametro(Object param, String nameParam) {
		log.debug("Inicio metodo: validarParametro");
		if (Objects.isNull(param)) {
			log.info("Parametro recibido es nulo: {}", nameParam);
			throw new NullParameterException("El parametro recibido es null: " + nameParam);
		}
		log.debug("Fin metodo: validarParametro");
	}

	/**
	 * 
	 * Método encargado de realizar la validacion si un parametro de cualquier tipo
	 * es null. Si se realiza la validación retorna una exception de tipo
	 * NullParameterException
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param object parametro de cualquie tipo de dato
	 */
	public static void validarObject(Object object) {
		log.debug("Inicio metodo: validarObject");
		if (Objects.isNull(object)) {
			log.info("Objecto recibido es nulo: {}", object);
			throw new NullParameterException("El objeto recibido es null");
		}
		log.debug("Fin metodo: validarObject");
	}

}
