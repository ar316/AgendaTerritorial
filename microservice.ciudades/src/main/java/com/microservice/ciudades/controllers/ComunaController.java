/**
 * ComunaController.java
 */
package com.microservice.ciudades.controllers;

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

import com.microservice.ciudades.dto.inputs.ComunaInDTO;
import com.microservice.ciudades.dto.outputs.ComunaDTO;
import com.microservice.ciudades.dto.outputs.ResponseDTO;
import com.microservice.ciudades.service.interf.ComunaService;
import com.microservice.ciudades.utils.MessageUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina los servicios disponibles para Comuna
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Tag(name = "Comunas", description = "Servicios disponibles para comunas")
@Log4j2
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/comunas")
public class ComunaController {

	private final ComunaService comunaService;

	/**
	 * 
	 * Método encargado de exponer el servicio para guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO ComunaInDTO
	 * @return ResponseDTO<String>
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<String>> save(@Valid @RequestBody(required = true) ComunaInDTO inDTO) {
		log.debug("Inicio metodo: save");
		this.comunaService.save(inDTO);
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
	 * @param inDTO ComunaInDTO
	 * @return ResponseDTO<ComunaDTO>
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<ComunaDTO>> update(@Valid @RequestBody(required = true) ComunaInDTO inDTO) {
		log.debug("Inicio metodo: update");
		HttpStatus httpStatus = HttpStatus.OK;
		ComunaDTO dto = this.comunaService.update(inDTO);
		ResponseDTO<ComunaDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
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
	 * @return ResponseDTO<ComunaDTO>
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<ComunaDTO>> getById(@PathVariable(value = "id", required = true) Integer id) {
		log.debug("Inicio metodo: getById");
		ComunaDTO dto = this.comunaService.getById(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<ComunaDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
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
		this.comunaService.delete(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<Boolean> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY);
		log.debug("Fin metodo: delete");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

}
