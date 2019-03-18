package com.webservice.ExternalAPIIntergration.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webservice.ExternalAPIIntergration.service.ExternalService;


public class ExternalResourceUnitTest extends JerseyTest {

	@InjectMocks
	ExternalResource externalResource;

	@Mock
	ExternalService externalService;

	
	
	
	@Override
    protected Application configure() {
		 MockitoAnnotations.initMocks(this);
		 enable(TestProperties.LOG_TRAFFIC);
	     enable(TestProperties.DUMP_ENTITY);
	     ApplicationContext context = new AnnotationConfigApplicationContext(ExternalResourceUnitTest.class);
	        
	     ResourceConfig config = new ResourceConfig();
	     config.register(ExternalResourceUnitTest.class);
	     config.property("contextConfig", context);
        return config;
    }

	@Test
	public void testGetAllValues() {

		Response mockResponse = mock(Response.class);
		when(externalService.retireveAllData()).thenReturn(mockResponse);

		Response actualResponse = externalResource.getAllValues();

		assertEquals(mockResponse, actualResponse);

	}

}
