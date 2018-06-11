package com.vivek.api.messenger1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vivek.api.messenger1.database.DatabaseClass;
import com.vivek.api.messenger1.model.Messages;

public class MessageService {
	private Map<Long, Messages> messages = DatabaseClass.getMessages();
	public MessageService() {
		messages.put(1L,new Messages(1,"Hello World","Vivek"));
		messages.put(2L,new Messages(2,"Hello MMT","Vivek"));
	}
	public List<Messages> getAllMessages() {
		return new ArrayList<Messages>(messages.values());
	} 
	public Messages addMessage(Messages message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Messages getMessage(long id) {
		return messages.get(id);
	}
	public Messages updateMessage(Messages m) {
		if(m.getId()<=0) {
			return null;
		}
		messages.put(m.getId(),m);
		return m;
	}
	public Messages removeMessage(long id) {
		return messages.remove(id);
	}
}
