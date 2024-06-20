/**
 * ComunaRepository.java
 */
package com.microservice.ciudades.repository.interf;

import com.microservice.ciudades.entities.Comuna;
import com.microservice.ciudades.repository.custom.CustomRepository;

/**
 * <b>Descripción:<b> Clase que determina la clase con los metodos para
 * interacción con la base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
public interface ComunaRepository extends CustomRepository<Comuna, Integer> {

}
