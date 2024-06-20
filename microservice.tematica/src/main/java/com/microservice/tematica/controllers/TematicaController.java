/**
 * TematicaController.java
 */
package com.microservice.tematica.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tematica.dto.inputs.TematicaInDTO;
import com.microservice.tematica.dto.outputs.ResponseDTO;
import com.microservice.tematica.dto.outputs.TematicaDTO;
import com.microservice.tematica.service.interf.TematicaService;
import com.microservice.tematica.utils.MessageUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina los servicios disponibles para
 * Tematica
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Tag(name = "Tematicas", description = "Servicios disponibles para tematicas")
@Log4j2
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/tematicas")
public class TematicaController {

	private final TematicaService tematicaService;

	/**
	 * 
	 * Método encargado de exponer el servicio para guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO TematicaInDTO
	 * @return ResponseDTO<String>
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<String>> save(@Valid @RequestBody(required = true) TematicaInDTO inDTO) {
		log.debug("Inicio metodo: save");
		this.tematicaService.save(inDTO);
		HttpStatus httpStatus = HttpStatus.CREATED;
		ResponseDTO<String> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY);
		log.debug("Fin metodo: save");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Método encargado de exponer el servicio para actualizar un registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO TematicaInDTO
	 * @return ResponseDTO<TematicaDTO>
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<TematicaDTO>> update(@Valid @RequestBody(required = true) TematicaInDTO inDTO) {
		log.debug("Inicio metodo: update");
		HttpStatus httpStatus = HttpStatus.OK;
		TematicaDTO dto = this.tematicaService.update(inDTO);
		ResponseDTO<TematicaDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY, dto);
		log.debug("Fin metodo: update");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Método encargado de exponer el servicio para obtener un registro por su
	 * identificador
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return ResponseDTO<TematicaDTO>
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<TematicaDTO>> getById(@PathVariable(value = "id", required = true) Integer id) {
		log.debug("Inicio metodo: getById");
		TematicaDTO dto = this.tematicaService.getById(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<TematicaDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY, dto);
		log.debug("Fin metodo: getById");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Método encargado de exponer el servicio para eliminar un registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return ResponseDTO<Boolean>
	 */
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<Boolean>> delete(@PathVariable(value = "id", required = true) Integer id) {
		log.debug("Inicio metodo: delete");
		this.tematicaService.delete(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<Boolean> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY);
		log.debug("Fin metodo: delete");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

}
