/**
 * BarrioController.java
 */
package com.microservice.ciudades.controllers;

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

import com.microservice.ciudades.dto.inputs.BarrioInDTO;
import com.microservice.ciudades.dto.outputs.BarrioDTO;
import com.microservice.ciudades.dto.outputs.ResponseDTO;
import com.microservice.ciudades.service.interf.BarrioService;
import com.microservice.ciudades.utils.MessageUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina los servicios disponibles para Barrio
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Tag(name = "Barrios", description = "Servicios disponibles para barrios")
@Log4j2
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/barrios")
public class BarrioController {

	private final BarrioService barrioService;

	/**
	 * 
	 * Método encargado de exponer el servicio para guardar un nuevo registro
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param inDTO BarrioInDTO
	 * @return ResponseDTO<String>
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<String>> save(@Valid @RequestBody(required = true) BarrioInDTO inDTO) {
		log.debug("Inicio metodo: save");
		this.barrioService.save(inDTO);
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
	 * @param inDTO BarrioInDTO
	 * @return ResponseDTO<BarrioDTO>
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<BarrioDTO>> update(@Valid @RequestBody(required = true) BarrioInDTO inDTO) {
		log.debug("Inicio metodo: update");
		HttpStatus httpStatus = HttpStatus.OK;
		BarrioDTO dto = this.barrioService.update(inDTO);
		ResponseDTO<BarrioDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
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
	public ResponseEntity<ResponseDTO<BarrioDTO>> getById(@PathVariable(value = "id", required = true) Integer id) {
		log.debug("Inicio metodo: getById");
		BarrioDTO dto = this.barrioService.getById(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<BarrioDTO> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
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
		this.barrioService.delete(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<Boolean> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY);
		log.debug("Fin metodo: delete");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	/**
	 * 
	 * Método encargado de exponer el servicio para obtener los registro que
	 * pertenecen a una comuna
	 * 
	 * @author CRISTIAN IC <cristianwic@gmail.com>
	 * 
	 * @param id identificador del registro
	 * @return ResponseDTO<List<BarrioDTO>>
	 */
	@GetMapping(path = "/comuna/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<BarrioDTO>>> getAllByComunaId(
			@PathVariable(value = "id", required = true) Integer id) {
		log.debug("Inicio metodo: getById");
		List<BarrioDTO> lista = this.barrioService.getAllByComundaId(id);
		HttpStatus httpStatus = HttpStatus.OK;
		ResponseDTO<List<BarrioDTO>> responseDTO = new ResponseDTO<>(Boolean.TRUE, httpStatus,
				MessageUtil.OPERATION_SUCCESSFULLY, lista);
		log.debug("Fin metodo: getById");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

}
