/**
 * ComunaServiceImpl.java
 */
package com.microservice.ciudades.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.ciudades.dto.inputs.ComunaInDTO;
import com.microservice.ciudades.dto.outputs.ComunaDTO;
import com.microservice.ciudades.entities.Comuna;
import com.microservice.ciudades.enums.EstadoEnum;
import com.microservice.ciudades.exceptions.ResourceNotFoundException;
import com.microservice.ciudades.mappers.ComunaMapper;
import com.microservice.ciudades.repository.interf.ComunaRepository;
import com.microservice.ciudades.service.interf.ComunaService;
import com.microservice.ciudades.utils.ValidacionesUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina la implementacion de los metodos de la
 * interfaz ComunaService
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Log4j2
@RequiredArgsConstructor
@Service(value = "comunaService")
public class ComunaServiceImpl implements ComunaService {

	private final ComunaRepository comunaRepository;

	/**
	 * @see com.microservice.compromiso.service.interf.ComunaService#save(com.microservice.compromiso.dto.input.ComunaInDTO)
	 */
	@Transactional
	@Override
	public void save(ComunaInDTO inDTO) {
		log.debug("Inicio método: save");
		Comuna comuna = ComunaMapper.toEntity(inDTO);
		comuna.setEstado(EstadoEnum.ACTIVO);
		this.comunaRepository.save(comuna);
		log.debug("Fin método: save");
	}

	/**
	 * @see com.microservice.compromiso.service.interf.ComunaService#update(com.microservice.compromiso.dto.input.ComunaInDTO)
	 */
	@Transactional
	@Override
	public ComunaDTO update(ComunaInDTO inDTO) {
		log.debug("Inicio método: update");
		Optional<Comuna> opt = this.comunaRepository.getById(inDTO.getId());
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Comuna a actualizar no encontrada");
		}
		opt.get().setNombre(inDTO.getNombre().strip().toUpperCase());
		opt.get().setDescripcion(inDTO.getDescripcion());
		opt.get().setLatitud(inDTO.getLatitud());
		opt.get().setLongitud(inDTO.getLongitud());
		Comuna comuna = this.comunaRepository.update(opt.get());
		log.debug("Fin método: update");
		return ComunaMapper.toDto(comuna);
	}

	/**
	 * @see com.microservice.compromiso.service.interf.ComunaService#getById(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	@Override
	public ComunaDTO getById(Integer id) {
		log.debug("Inicio método: getById");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<Comuna> comuna = this.comunaRepository.getById(id);
		if (Boolean.FALSE.equals(comuna.isPresent())) {
			throw new ResourceNotFoundException("Comuna no encontrada");
		}
		log.debug("Fin método: getById");
		return ComunaMapper.toDto(comuna.get());
	}

	/**
	 * 
	 * @see com.microservice.compromiso.service.interf.ComunaService#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public boolean delete(Integer id) {
		log.debug("Inicio método: delete");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<Comuna> opt = this.comunaRepository.getById(id);
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Comuna a eliminar no encontrada");
		}
		this.comunaRepository.delete(opt.get());
		log.debug("Fin método: delete");
		return Boolean.TRUE;
	}

	/**
	 * @see com.microservice.compromiso.service.interf.ComunaService#getAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<ComunaDTO> getAll() {
		log.debug("Inicio método: getAll");
		List<Comuna> lista = this.comunaRepository.getAll();
		log.debug("Fin método: getAll");
		return ComunaMapper.toDtos(lista);
	}

}
