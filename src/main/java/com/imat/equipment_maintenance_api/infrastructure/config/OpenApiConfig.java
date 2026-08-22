package com.imat.equipment_maintenance_api.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI equipmentMaintenanceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Equipment Maintenance API")
                        .description("API de gestión de inventario de equipos médicos y mantenimientos técnicos")
                        .version("v1")
                        .contact(new Contact().name("IMAT")));
    }
}
