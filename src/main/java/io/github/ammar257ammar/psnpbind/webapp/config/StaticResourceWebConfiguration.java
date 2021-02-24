package io.github.ammar257ammar.psnpbind.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class StaticResourceWebConfiguration implements WebMvcConfigurer {
    protected static final String[] RESOURCE_LOCATIONS = new String[] {
        "classpath:/static/assets/css/",
        "classpath:/static/assets/js/",
        "classpath:/static/assets/images/",
        "classpath:/static/assets/fonts/",
        "file:///dockings/"
    };
    protected static final String[] RESOURCE_PATHS = new String[] { "/css/**", "/js/**", "/images/**", "/fonts/**", "/files/**" };

    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCE_PATHS)
        		.addResourceLocations(RESOURCE_LOCATIONS)
		        .setCachePeriod(3600)
		        .resourceChain(true)
		        .addResolver(new PathResourceResolver());
    }
}
