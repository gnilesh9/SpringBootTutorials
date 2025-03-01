package com.swagger;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenAPIConfig {
	
	@Value("${openapi.dev-url}")
	private String devUrl;
//	
//	@Value("${openapi.prod-url}")
//	private String prodUrl;


	@Bean
	OpenAPI myOpenAPI() {
		Server devServer =new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in Development Environment");
		
//		Server prodServer =new Server();
//		devServer.setUrl(prodUrl);
//		devServer.setDescription("Server URL in Production Environment");
		
		Contact contact= new Contact();
		contact.setEmail("gnilesh9@gmail.com");
		contact.setName("Nilesh");
		contact.setUrl("http://www.abc.com");
		
		License mitLicense= new License().name("MIT License")
				.url("http://choosealicense.com/license/mit");
		
		Info info= new Info().
				title("Hello API").
				version("1.0").
				contact(contact).
				description("This API expose endpoints to manage tutorials")
			.termsOfService("term url").license(mitLicense);
		
		return new OpenAPI().info(info).servers(Arrays.asList(devServer));
		
		
	}
	
}
