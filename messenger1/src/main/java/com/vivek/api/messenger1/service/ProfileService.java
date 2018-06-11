package com.vivek.api.messenger1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vivek.api.messenger1.database.DatabaseClass;
import com.vivek.api.messenger1.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	public ProfileService() {
		profiles.put("vivek",new Profile(1L,"vivek","vivek","singal"));

	}
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	} 
	public Profile addProfile(Profile p) {
		p.setId(profiles.size()+1);
		profiles.put(p.getProfileName(), p);
		return p;
	}
	public Profile getProfile(String name) {
		return profiles.get(name);
	}
	public Profile updateProfile(Profile p) {
		if(p.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(p.getProfileName(),p);
		return p;
	}
	public Profile removeMessage(String name) {
		return profiles.remove(name);
	}
}
