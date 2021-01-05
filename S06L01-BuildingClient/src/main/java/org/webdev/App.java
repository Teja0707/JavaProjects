package org.webdev;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


@Path("/app")
public class App {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String demo() {
		
		Client client = ClientBuilder.newClient();
		WebTarget baseBrandUrl = client.target("http://localhost:9090/JaxRestApplication-L61/showroom/brands");
		WebTarget brandUrl = baseBrandUrl.path("{brandId}");
		
		String response = brandUrl.resolveTemplate("brandId", 2).request(MediaType.APPLICATION_JSON).get(String.class);
			
		return response;
	}
}
