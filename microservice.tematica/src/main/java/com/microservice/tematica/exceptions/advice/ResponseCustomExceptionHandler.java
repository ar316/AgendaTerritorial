/**
 * ResponseCustomExceptionHandler.java
 */
package com.microservice.tematica.exceptions.advice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.tematica.dto.outputs.FieldsValidationDTO;
import com.microservice.tematica.dto.outputs.ResponseDTO;
import com.microservice.tematica.exceptions.NullParameterException;
import com.microservice.tematica.exceptions.ResourceNotFoundException;
import com.microservice.tematica.utils.MessageUtil;

import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina las respuestas finales a las
 * diferentes excepciones
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Log4j2
@RestControllerAdvice
public class ResponseCustomExceptionHandler {

	/**
	 * 
	 * Metodo encargado de capturar procesar y responder una Excepcion cuando no se
	 * cumplen las validaciones del DTO de entrada
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param ex MethodArgumentNotValidException
	 * @return ResponseEntity<ResponseDTO<List<FieldsValidationDTO>>>
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO<List<FieldsValidationDTO>>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		log.debug("Inicio metodo: handleMethodArgumentNotValidException");
		var httpStatus = HttpStatus.BAD_REQUEST;
		var responseDTO = new ResponseDTO<List<FieldsValidationDTO>>(Boolean.FALSE, httpStatus,
				MessageUtil.FALTAN_COMPLETAR_DATOS,
				this.obtenerCamposErroresInDTO(ex.getBindingResult().getFieldErrors()));
		log.debug("Finaliza metodo: handleMethodArgumentNotValidException");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Metodo encargado de Obtener los campos que no cumplen las validaciones
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param errores List<FieldError>
	 * @return List<FieldsValidationDTO>
	 */
	private List<FieldsValidationDTO> obtenerCamposErroresInDTO(List<FieldError> errores) {
		log.debug("Inicio metodo: obtenerCamposErroresInDTO");
		return errores.stream().map(errorField -> {
			var fieldsValidationDTO = new FieldsValidationDTO();
			fieldsValidationDTO.setFieldName(errorField.getField());
			fieldsValidationDTO.setMessage(errorField.getDefaultMessage());
			return fieldsValidationDTO;
		}).toList();
	}

	/**
	 * 
	 * Metodo encargado de capturar la excepcion cuando un recurso solicitado no se
	 * ha encontrado y devolver la respuesta al servicio que realizó la operacion
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param ex
	 * @return HttpStatus.BAD_REQUEST 400
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseDTO<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		log.debug("Inicio metodo: handleResourceNotFoundException");
		var httpStatus = HttpStatus.BAD_REQUEST;
		var responseDTO = new ResponseDTO<String>(Boolean.FALSE, httpStatus, ex.getMessage());
		log.debug("Finaliza metodo: handleResourceNotFoundException");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Metodo encargado de capturar las excepciones cuando un parametro es nulo y
	 * devolver la respuesta al servicio que realizó la operacion
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param ex
	 * @return HttpStatus.BAD_REQUEST 400
	 */
	@ExceptionHandler(NullParameterException.class)
	public ResponseEntity<ResponseDTO<String>> handleNullParameterException(NullParameterException ex) {
		log.debug("Inicio metodo: handleNullParameterException");
		var httpStatus = HttpStatus.BAD_REQUEST;
		var responseDTO = new ResponseDTO<String>(Boolean.FALSE, httpStatus, ex.getMessage());
		log.debug("Finaliza metodo: handleNullParameterException");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

}
