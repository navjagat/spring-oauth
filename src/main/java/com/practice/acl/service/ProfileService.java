package com.practice.acl.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.practice.acl.entiry.Profile;

public interface ProfileService {
	
	@PreAuthorize("hasPermission(#profile,'read') and #oauth2.hasScope('read')")
	public Profile create(Profile profile);
	
	public void delete(Long id);
	
	public Profile update(Profile profile);
	
	public Profile retriece(Long id);
	
	public List<Profile> retrieveAll();
}
