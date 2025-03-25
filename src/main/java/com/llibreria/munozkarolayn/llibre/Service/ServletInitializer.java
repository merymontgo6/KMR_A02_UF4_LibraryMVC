package com.llibreria.munozkarolayn.llibre.Service;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.llibreria.munozkarolayn.llibre.LlibreApplication;
 
public class ServletInitializer extends SpringBootServletInitializer {
 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LlibreApplication.class);
	}
 
}