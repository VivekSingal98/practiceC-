package com.vivek.api.messenger1.database;

import java.util.HashMap;
import java.util.Map;

import com.vivek.api.messenger1.model.Messages;
import com.vivek.api.messenger1.model.Profile;

public class DatabaseClass {
	private static Map<Long, Messages> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();
	public static Map<Long, Messages> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	

}
