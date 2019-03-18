package com.webservice.ExternalAPIIntergration.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.webservice.ExternalAPIIntergration.resource.ExternalResource;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(ExternalResource.class);
	}
}
