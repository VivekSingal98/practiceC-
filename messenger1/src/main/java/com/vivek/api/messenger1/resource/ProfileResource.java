package com.vivek.api.messenger1.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.vivek.api.messenger1.model.Profile;
import com.vivek.api.messenger1.service.ProfileService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("profiles")
public class ProfileResource {
	private ProfileService profiles=new ProfileService();
	@GET
	public List<Profile> getProfiles(){
		return profiles.getAllProfiles();
	}
	@POST
	public Profile postProfile(Profile p) {
		return profiles.addProfile(p);
	}
	@GET
	@Path("{name}")
	public Profile getProfile(@PathParam("name") String name) {	
		return profiles.getProfile(name);
	}
	@PUT
	@Path("{name}")
	public Profile getProfile(@PathParam("name") String name, Profile p) {	
		p.setProfileName(name);
		return profiles.updateProfile(p);
	}
	
}
