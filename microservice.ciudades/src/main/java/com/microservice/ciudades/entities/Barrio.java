/**
 * Barrio.java
 */
package com.microservice.ciudades.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.DynamicUpdate;

import com.microservice.ciudades.enums.EstadoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Descripción:<b> Clase que determina el mapeo de la tabla barrios de la
 * base de datos
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@DynamicUpdate
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "barrios", schema = "public")
public class Barrio implements Serializable {

	/**
	 * Atributo que determina el campo para la serializacion
	 */
	private static final long serialVersionUID = 8524290555925609209L;

	/**
	 * Atributo que determina el identificador del registro
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * Atributo que determina la comuna a la que pertenece el barrio
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comuna_id", nullable = false)
	private Comuna comuna;

	/**
	 * Atributo que determina el nombre del barrio
	 */
	@Column(name = "nombre", nullable = false)
	private String nombre;
	/**
	 * Atributo que determina la descripcion
	 */
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	/**
	 * Atributo que determina la latitud
	 */
	@Column(name = "latitud", nullable = false)
	private BigDecimal latitud;

	/**
	 * Atributo que determina la longitud
	 */
	@Column(name = "longitud", nullable = false)
	private BigDecimal longitud;

	/**
	 * Atributo que determina el estado del barrio
	 */
	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado", nullable = false, length = 10)
	private EstadoEnum estado;

}
