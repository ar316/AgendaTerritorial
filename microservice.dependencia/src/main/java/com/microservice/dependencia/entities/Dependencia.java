/**
 * Dependencia.java
 */
package com.microservice.dependencia.entities;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import com.microservice.dependencia.enums.EstadoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el mapeo de la tabla dependencias de
 * la base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@DynamicUpdate
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dependencias", schema = "public")
public class Dependencia implements Serializable {

	/**
	 * Atributo que determina
	 */
	private static final long serialVersionUID = 6715998626750523271L;

	/**
	 * Atributo que determina el identificador del registro
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * Atributo que determina el nombre
	 */
	@Column(name = "nombre", nullable = false)
	private String nombre;

	/**
	 * Atributo que determina la descripcion
	 */
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	/**
	 * Atributo que deterina el estado
	 */
	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado", nullable = false, length = 10)
	private EstadoEnum estado;

}
