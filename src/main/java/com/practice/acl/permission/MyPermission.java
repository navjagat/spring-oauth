package com.practice.acl.permission;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.practice.acl.entiry.Profile;

public class MyPermission implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		
		if(targetDomainObject==null)
			return true;
				
		Profile profile = (Profile) targetDomainObject;
		
		String clientId = (String) authentication.getPrincipal();
		
		return clientId.equals(profile.getCompany());
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		throw new UnsupportedOperationException();
	}

}
