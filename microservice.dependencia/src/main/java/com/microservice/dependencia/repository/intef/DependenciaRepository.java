/**
 * DependenciaRepository.java
 */
package com.microservice.dependencia.repository.intef;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.dependencia.entities.Dependencia;

/**
 * <b>Descripción:<b> Clase que determina la clase con los metodos para
 * interacción con la base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

}
