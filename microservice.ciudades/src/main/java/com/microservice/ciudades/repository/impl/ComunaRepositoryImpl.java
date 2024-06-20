/**
 * ComunaRepositoryImpl.java
 */
package com.microservice.ciudades.repository.impl;

import org.springframework.stereotype.Repository;

import com.microservice.ciudades.entities.Comuna;
import com.microservice.ciudades.repository.custom.CustomRepositoryImpl;
import com.microservice.ciudades.repository.interf.ComunaRepository;

/**
 * <b>Descripción:<b> Clase que determina
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version
 */
@Repository(value = "comunaRepository")
public class ComunaRepositoryImpl extends CustomRepositoryImpl<Comuna, Integer> implements ComunaRepository {

}
