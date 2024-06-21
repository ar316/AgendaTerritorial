/**
 * DependenciaController.java
 */
package com.microservice.dependencia.controllers;

import java.util.List;

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

import com.microservice.dependencia.dto.inputs.DependenciaInDTO;
import com.microservice.dependencia.dto.outputs.DependenciaDTO;
import com.microservice.dependencia.dto.outputs.ResponseDTO;
import com.microservice.dependencia.service.interf.DependenciaService;
import com.microservice.dependencia.utils.MessageUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina los servicios disponibles para
 * Dependencia
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Tag(name = "Dependencias", description = "Servicios disponibles para dependencias")
@Log4j2
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/dependencias")
public class DependenciaController {

	private final DependenciaService dependenciaService;

	/**
	 * 
	 * Método encargado de exponer el servicio para guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO DependenciaInDTO
	 * @return ResponseDTO<String>
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<String>> save(@Valid @RequestBody(required = true) DependenciaInDTO inDTO) {
		log.debug("Inicio metodo: save");
		this.dependenciaService.save(inDTO);
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
	 * @param inDTO DependenciaInDTO
	 * @return ResponseDTO<DependenciaDTO>
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<DependenciaDTO>> update(
			@Valid @RequestBody(required = true) DependenciaInDTO inDTO) {
		log.debug("Inicio metodo: update");
		HttpStatus httpStatus = HttpStatus.OK;
		DependenciaDTO dto = this.dependenciaService.update(inDTO);
		ResponseDTO<DependenciaDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
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
	 * @return ResponseDTO<DependenciaDTO>
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<DependenciaDTO>> getById(
			@PathVariable(value = "id", required = true) Integer id) {
		log.debug("Inicio metodo: getById");
		DependenciaDTO dto = this.dependenciaService.getById(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<DependenciaDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
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
		this.dependenciaService.delete(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<Boolean> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY);
		log.debug("Fin metodo: delete");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Método encargado de exponer el servicio para obtener todos los registros
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return ResponseDTO<List<DependenciaDTO>>
	 */
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<DependenciaDTO>>> getAll() {
		log.debug("Inicio metodo: delete");
		List<DependenciaDTO> lista = this.dependenciaService.getAll();
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<List<DependenciaDTO>> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY, lista);
		log.debug("Fin metodo: delete");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

}
