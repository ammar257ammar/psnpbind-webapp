package io.github.ammar257ammar.psnpbind.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {   
	
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("PSnpBind API").description(
                        "Pocket Snps's effect on binding affinity (PSnpBind) Restful API (OpenAPI v3)")
                		.version("1.0")
                		.termsOfService("http://swagger.io/terms/")
                		.license(new License().name("CC-BY-SA 4.0").url("https://creativecommons.org/licenses/by-sa/4.0/"))
                		.contact(new Contact().name("Ammar Ammar").url("http://orcid.org/0000-0002-8399-8990")));
    }
    
}