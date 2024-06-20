/**
 * BarrioServiceImpl.java
 */
package com.microservice.ciudades.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.ciudades.dto.inputs.BarrioInDTO;
import com.microservice.ciudades.dto.outputs.BarrioDTO;
import com.microservice.ciudades.dto.outputs.ComunaDTO;
import com.microservice.ciudades.entities.Barrio;
import com.microservice.ciudades.entities.Comuna;
import com.microservice.ciudades.enums.EstadoEnum;
import com.microservice.ciudades.exceptions.ResourceNotFoundException;
import com.microservice.ciudades.mappers.BarrioMapper;
import com.microservice.ciudades.mappers.ComunaMapper;
import com.microservice.ciudades.repository.interf.BarrioRepository;
import com.microservice.ciudades.repository.interf.ComunaRepository;
import com.microservice.ciudades.service.interf.BarrioService;
import com.microservice.ciudades.utils.ValidacionesUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * <b>Descripción:<b> Clase que determina la implementacion de los metodos de la
 * interfaz BarrioService
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Log4j2
@RequiredArgsConstructor
@Service(value = "barrioService")
public class BarrioServiceImpl implements BarrioService {

	private final BarrioRepository barrioRepository;

	private final ComunaRepository comunaRepository;

	/**
	 * @see com.microservice.compromiso.service.interf.BarrioService#save(com.microservice.compromiso.dto.input.BarrioInDTO)
	 */
	@Transactional
	@Override
	public void save(BarrioInDTO inDTO) {
		log.debug("Inicio método: save");
		Barrio barrio = BarrioMapper.toEntity(inDTO);
		barrio.setEstado(EstadoEnum.ACTIVO);
		if (Objects.nonNull(inDTO.getComunaId())) {
			Optional<Comuna> optComuna = this.comunaRepository.getById(inDTO.getComunaId());
			if (Boolean.FALSE.equals(optComuna.isPresent())) {
				throw new ResourceNotFoundException("Comuna establecida no existe");
			}
			barrio.setComuna(optComuna.get());
		}
		this.barrioRepository.save(barrio);
		log.debug("Fin método: save");
	}

	/**
	 * @see com.microservice.compromiso.service.interf.BarrioService#update(com.microservice.compromiso.dto.input.BarrioInDTO)
	 */
	@Transactional
	@Override
	public BarrioDTO update(BarrioInDTO inDTO) {
		log.debug("Inicio método: update");
		Optional<Barrio> opt = this.barrioRepository.getById(inDTO.getId());
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Barrio a actualizar no encontrado");
		}
		opt.get().setNombre(inDTO.getNombre().strip().toUpperCase());
		opt.get().setDescripcion(inDTO.getDescripcion());
		opt.get().setLatitud(inDTO.getLatitud());
		opt.get().setLongitud(inDTO.getLongitud());
		ComunaDTO comunaDTO = null;
		if (Objects.nonNull(inDTO.getComunaId())) {
			Optional<Comuna> optComuna = this.comunaRepository.getById(inDTO.getComunaId());
			if (Boolean.FALSE.equals(optComuna.isPresent())) {
				throw new ResourceNotFoundException("Comuna establecida no existe");
			}
			opt.get().setComuna(optComuna.get());
			comunaDTO = ComunaMapper.toDto(optComuna.get());
		}
		Barrio barrio = this.barrioRepository.update(opt.get());
		BarrioDTO barrioDTO = BarrioMapper.toDto(barrio);
		barrioDTO.setComuna(comunaDTO);
		log.debug("Fin método: update");
		return barrioDTO;
	}

	/**
	 * @see com.microservice.compromiso.service.interf.BarrioService#getById(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	@Override
	public BarrioDTO getById(Integer id) {
		log.debug("Inicio método: getById");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<Barrio> opt = this.barrioRepository.getAllById(id);
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Barrio no encontrado");
		}
		BarrioDTO dto = BarrioMapper.toDto(opt.get());
		if (Objects.nonNull(opt.get().getComuna())) {
			ComunaDTO comunaDTO = ComunaMapper.toDto(opt.get().getComuna());
			dto.setComuna(comunaDTO);
		}
		log.debug("Fin método: getById");
		return dto;
	}

	/**
	 * @see com.microservice.compromiso.service.interf.BarrioService#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public boolean delete(Integer id) {
		log.debug("Inicio método: delete");
		ValidacionesUtil.validarParametro(id, "id");
		Optional<Barrio> opt = this.barrioRepository.getById(id);
		if (Boolean.FALSE.equals(opt.isPresent())) {
			throw new ResourceNotFoundException("Barrio a eliminar no encontrado");
		}
		this.barrioRepository.delete(opt.get());
		log.debug("Fin método: delete");
		return Boolean.TRUE;
	}

	/**
	 * @see com.microservice.compromiso.service.interf.BarrioService#getAllByComundaId(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<BarrioDTO> getAllByComundaId(Integer comunaId) {
		log.debug("Inicio método: getAllByComundaId");
		ValidacionesUtil.validarParametro(comunaId, "comunaId");
		List<Barrio> lista = this.barrioRepository.getAllByComunaId(comunaId);
		log.debug("Fin método: getAllByComundaId");
		return BarrioMapper.toDtos(lista);
	}

}
