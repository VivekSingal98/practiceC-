package com.vivek.api.messenger1.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vivek.api.messenger1.model.Messages;
import com.vivek.api.messenger1.service.MessageService;

@Path("messages")
public class MessageResource {
	MessageService messages=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messages> getMessage( ) {
		return messages.getAllMessages();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Messages addMessage(Messages m) {
		return messages.addMessage(m);
	} 
	@PUT
	@Path("{messageId}") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Messages updateMessage(@PathParam("messageId") long messageId,Messages m) {
		m.setId(messageId);
		return messages.updateMessage(m);
	} 
	@DELETE
	@Path("{messageId}") 
	@Produces(MediaType.APPLICATION_JSON)
	public void delMessage(@PathParam("messageId") long messageId) {	
		Messages m= messages.removeMessage(messageId);
		
	}
	@GET
	@Path("{messageId}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Messages getMessage(@PathParam("messageId") long messageId) {	
		return messages.getMessage(messageId);
		
	}

}
