/**
 * SwaggerConfig.java
 */
package com.microservice.ciudades.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * <b>Descripción:<b> Clase que determina la implementacion de configuracion de
 * swagger
 * 
 * @author CRISTIAN IC <cristianwic@gmail.com>
 * @version 1.0
 */
@OpenAPIDefinition(
		info = @Info(
				title = "MicroService Ciudades", 
				description = "Microservicio para Comuna y Barrio", 
				version = "1.0")
)
public class SwaggerConfig {

}
