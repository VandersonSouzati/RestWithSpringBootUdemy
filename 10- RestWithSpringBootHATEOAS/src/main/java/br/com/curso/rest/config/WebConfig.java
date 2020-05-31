package br.com.curso.rest.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.curso.rest.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	protected void extendMessageConverter(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}

	
	@Override
	 public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		 
		 /*
		 Via entension http://localhost:8080/api/person/v1.json
		 configurer.favorParameter(false)
		      .ignoreAcceptHeader(false)
		      .defaultContentType(MediaType.APPLICATION_JSON)
		      .mediaType("json",  MediaType.APPLICATION_JSON)
		      .mediaType("xml",   MediaType.APPLICATION_XML);
		 */
		 
		 /*
		 Via Query Param, http://locahost:8080/api/person/v1/mediaType=json
		 configurer.favorPathExtension(false)
		       .favorParameter(true)
		       .parameterName("mediaType")
		       .ignoreAcceptHeader(true)
		       .useRegisteredExtensionsOnly(false)
		       .defaultContentType(MediaType.APPLICATION_JSON)
		       .mediaType("json",  MediaType.APPLICATION_JSON)
		       .mediaType("xml",  MediaType.APPLICATION_XML);
		 */
		 
		 //Via Header
		 configurer.favorPathExtension(false)
		       .favorParameter(false)
		       .ignoreAcceptHeader(false)
		       .useRegisteredExtensionsOnly(false)
		       .defaultContentType(MediaType.APPLICATION_JSON)
		       .mediaType("json", MediaType.APPLICATION_JSON)
		       .mediaType("xml", MediaType.APPLICATION_XML)
		       .mediaType("x-yaml", MEDIA_TYPE_YML);
		 }
	 
	 
}
