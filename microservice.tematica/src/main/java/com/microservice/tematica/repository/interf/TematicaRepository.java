/**
 * TematicaRepository.java
 */
package com.microservice.tematica.repository.interf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.tematica.entities.Tematica;

/**
 * <b>Descripción:<b> Clase que determina la clase con los metodos para
 * interacción con la base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Repository
public interface TematicaRepository extends JpaRepository<Tematica, Integer> {

}
