package org.webdev;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/app")
public class App {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String demo(@QueryParam("code") String code) {
		return "The value of code is " + code;
	}
}
