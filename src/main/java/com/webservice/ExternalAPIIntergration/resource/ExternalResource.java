package com.webservice.ExternalAPIIntergration.resource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.webservice.ExternalAPIIntergration.service.ExternalService;

@Path("/api")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ExternalResource{

	@Inject
	@Named("ReqResInExternalAPI")
	ExternalService reqResInExternalAPI;

	@GET
	public Response getAllValues() {
		return reqResInExternalAPI.retireveAllData();
	}

}