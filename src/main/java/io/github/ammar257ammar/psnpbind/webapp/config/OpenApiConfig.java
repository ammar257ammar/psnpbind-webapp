package io.github.ammar257ammar.psnpbind.webapp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {   
	
    @Bean
    public OpenAPI customOpenAPI() {
    	
    	Server server = new Server();
        server.setUrl("https://psnpbind.org");
        
        List<Server> servers = new ArrayList<Server>();
        servers.add(server);
        
        return new OpenAPI()
                .components(new Components().addHeaders("Access-Control-Allow-Origin", new Header()
                        .description("version header")
                        .required(true)
                        .schema(new StringSchema())))
                .servers(servers)
                .info(new Info().title("PSnpBind API").description(
                        "Pocket Snps's effect on binding affinity (PSnpBind) Restful API (OpenAPI v3)")
                		.version("1.0")
                		.termsOfService("http://swagger.io/terms/")
                		.license(new License().name("CC-BY-SA 4.0").url("https://creativecommons.org/licenses/by-sa/4.0/"))
                		.contact(new Contact().name("Ammar Ammar").url("http://orcid.org/0000-0002-8399-8990")));
    }
    
    @Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
    
}