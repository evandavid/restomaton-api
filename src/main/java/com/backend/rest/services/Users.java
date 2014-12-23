package com.backend.rest.services;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javalite.activejdbc.LazyList;

import com.backend.rest.models.User;

@Path("/users")
public class Users  extends ParentServices{
	
	public Users() throws SQLException {
		super();
	}

	@GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String users() {
		return getAll();
    }
	
	private String getAll(){
		LazyList<User> users = User.findAll();
		return users.toJson(true).toString();
	}
}
