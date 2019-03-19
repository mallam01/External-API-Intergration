package com.webservice.ExternalAPIIntergration.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.webservice.ExternalAPIIntergration.service.ExternalService;

public class ExternalResourceUnitTest {

	@InjectMocks
	ExternalResource externalResource;

	@Mock
	ExternalService externalService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllValues() {
		Response mockResponse = mock(Response.class);
		when(externalService.retireveAllData()).thenReturn(mockResponse);
		Response actualResponse = externalResource.getAllValues();
		assertEquals(mockResponse, actualResponse);

	}

	@Test
	public void testCallServiceOnce() {
		externalService.retireveAllData();
		verify(externalService, times(1)).retireveAllData();
	}

}
