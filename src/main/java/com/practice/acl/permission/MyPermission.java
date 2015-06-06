package com.practice.acl.permission;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.practice.acl.entiry.Profile;
import com.practice.acl.repo.ClientRepository;
import com.practice.acl.entiry.Client;

public class MyPermission implements PermissionEvaluator {
	
	@Autowired
	private ProfileRepository repo;
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		
		Profile profile = null;
		
		if(targetDomainObject==null)
			return true;
			
		if(targetDomainObject instance of Long){
			profile = repo.findOne((Long) targetDomainObject);
		}
		if(targetDomainObject instance of Profile){
			profile = (Profile) targetDomainObject;
		}
		
		Client client = repository.findOne((String) authentication.getPrincipal());
		
		return client.getAccount().equals(profile.getCompany());
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		throw new UnsupportedOperationException();
	}

}
