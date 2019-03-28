package com.sample.demo;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class SampleProjectService {
			
	@GET
	@Path("/api/users/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUsers(@PathParam ("username") String username) {		
		
  // call to the Batch 
	
	return null;	
	}


}