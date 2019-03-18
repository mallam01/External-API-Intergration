package com.webservice.ExternalAPIIntergration.service.imp;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.webservice.ExternalAPIIntergration.service.ExternalService;

@Named("ReqResInExternalAPI")
public class ReqResInExternalAPI implements ExternalService {

	@Override
	public Response retireveAllData() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://reqres.in/api/users");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		return response;
	}

}
