/**
 * TematicaServiceImpl.java
 */
package com.microservice.tematica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.tematica.dto.inputs.TematicaInDTO;
import com.microservice.tematica.dto.outputs.TematicaDTO;
import com.microservice.tematica.entities.Tematica;
import com.microservice.tematica.enums.EstadoEnum;
import com.microservice.tematica.exceptions.ResourceNotFoundException;
import com.microservice.tematica.mappers.TematicaMapper;
import com.microservice.tematica.repository.interf.TematicaRepository;
import com.microservice.tematica.service.interf.TematicaService;
import com.microservice.tematica.utils.ValidacionesUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina la implementacion de los metodos de la
 * interfaz TematicaService
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Log4j2
@RequiredArgsConstructor
@Service(value = "tematicaService")
public class TematicaServiceImpl implements TematicaService {

	private final TematicaRepository tematicaRepository;

	/**
	 * @see com.microservice.tematica.service.interf.TematicaService#save(com.microservice.tematica.dto.inputs.TematicaInDTO)
	 */
	@Transactional
	@Override
	public void save(TematicaInDTO inDTO) {
		log.debug("Inicio método: save");
		Tematica tematica = TematicaMapper.toEntity(inDTO);
		tematica.setEstado(EstadoEnum.ACTIVO);
		this.tematicaRepository.save(tematica);
		log.debug("Fin método: save");
	}

	/**
	 * @see com.microservice.tematica.service.interf.TematicaService#update(com.microservice.tematica.dto.inputs.TematicaInDTO)
	 */
	@Transactional
	@Override
	public TematicaDTO update(TematicaInDTO inDTO) {
		log.debug("Inicio método: update");
		ValidacionesUtil.validarParametro(inDTO.getId(), "id");
		Optional<Tematica> opt = this.tematicaRepository.findById(inDTO.getId());
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Tematica a actualizar no encontrada");
		}
		opt.get().setNombre(inDTO.getNombre().strip().toUpperCase());
		opt.get().setDescripcion(inDTO.getDescripcion());
		Tematica tematica = this.tematicaRepository.save(opt.get());
		log.debug("Fin método: update");
		return TematicaMapper.toDto(tematica);
	}

	/**
	 * @see com.microservice.tematica.service.interf.TematicaService#getById(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	@Override
	public TematicaDTO getById(Integer id) {
		log.debug("Inicio método: getById");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<Tematica> opt = this.tematicaRepository.findById(id);
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Tematica no encontrada");
		}
		log.debug("Fin método: getById");
		return TematicaMapper.toDto(opt.get());
	}

	/**
	 * @see com.microservice.tematica.service.interf.TematicaService#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public boolean delete(Integer id) {
		log.debug("Inicio método: delete");
		ValidacionesUtil.validarParametro(id, "id");
		if (Boolean.FALSE.equals(this.tematicaRepository.existsById(id))) {
			throw new ResourceNotFoundException("Tematica a eliminar no encontrada");
		}
		this.tematicaRepository.deleteById(id);
		log.debug("Fin método: delete");
		return Boolean.TRUE;
	}

	/**
	 * @see com.microservice.tematica.service.interf.TematicaService#getAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<TematicaDTO> getAll() {
		log.debug("Inicio método: getAll");
		List<Tematica> lista = this.tematicaRepository.findAll();
		log.debug("Fin método: getAll");
		return TematicaMapper.toDtos(lista);
	}

}
