/**
 * DependenciaServiceImpl.java
 */
package com.microservice.dependencia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.dependencia.dto.inputs.DependenciaInDTO;
import com.microservice.dependencia.dto.outputs.DependenciaDTO;
import com.microservice.dependencia.entities.Dependencia;
import com.microservice.dependencia.enums.EstadoEnum;
import com.microservice.dependencia.exceptions.ResourceNotFoundException;
import com.microservice.dependencia.mappers.DependenciaMapper;
import com.microservice.dependencia.repository.intef.DependenciaRepository;
import com.microservice.dependencia.service.interf.DependenciaService;
import com.microservice.dependencia.utils.ValidacionesUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina la implementacion de los metodos de la
 * interfaz DependenciaService
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Log4j2
@RequiredArgsConstructor
@Service(value = "dependenciaService")
public class DependenciaServiceImpl implements DependenciaService {

	private final DependenciaRepository dependenciaRepository;

	/**
	 * @see com.microservice.dependencia.service.interf.DependenciaService#save(com.microservice.dependencia.dto.inputs.DependenciaInDTO)
	 */
	@Transactional
	@Override
	public void save(DependenciaInDTO inDTO) {
		log.debug("Inicio método: save");
		Dependencia entity = DependenciaMapper.toEntity(inDTO);
		entity.setEstado(EstadoEnum.ACTIVO);
		this.dependenciaRepository.save(entity);
		log.debug("Fin método: save");
	}

	/**
	 * @see com.microservice.dependencia.service.interf.DependenciaService#update(com.microservice.dependencia.dto.inputs.DependenciaInDTO)
	 */
	@Transactional
	@Override
	public DependenciaDTO update(DependenciaInDTO inDTO) {
		log.debug("Inicio método: update");
		ValidacionesUtil.validarParametro(inDTO.getId(), "id");
		Optional<Dependencia> opt = this.dependenciaRepository.findById(inDTO.getId());
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Dependencia a actualizar no encontrada");
		}
		opt.get().setNombre(inDTO.getNombre().strip().toUpperCase());
		opt.get().setDescripcion(inDTO.getDescripcion());
		Dependencia tematica = this.dependenciaRepository.save(opt.get());
		log.debug("Fin método: update");
		return DependenciaMapper.toDto(tematica);
	}

	/**
	 * @see com.microservice.dependencia.service.interf.DependenciaService#getById(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	@Override
	public DependenciaDTO getById(Integer id) {
		log.debug("Inicio método: getById");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<Dependencia> opt = this.dependenciaRepository.findById(id);
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Dependencia no encontrada");
		}
		log.debug("Fin método: getById");
		return DependenciaMapper.toDto(opt.get());
	}

	/**
	 * @see com.microservice.dependencia.service.interf.DependenciaService#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public boolean delete(Integer id) {
		log.debug("Inicio método: delete");
		ValidacionesUtil.validarParametro(id, "id");
		if (Boolean.FALSE.equals(this.dependenciaRepository.existsById(id))) {
			throw new ResourceNotFoundException("Tematica a eliminar no encontrada");
		}
		this.dependenciaRepository.deleteById(id);
		log.debug("Fin método: delete");
		return Boolean.TRUE;
	}

	/**
	 * @see com.microservice.dependencia.service.interf.DependenciaService#getAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<DependenciaDTO> getAll() {
		log.debug("Inicio método: getAll");
		List<Dependencia> lista = this.dependenciaRepository.findAll();
		log.debug("Fin método: getAll");
		return DependenciaMapper.toDtos(lista);
	}

}
