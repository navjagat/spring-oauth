package com.practice.acl.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.practice.acl.entiry.Profile;

public interface ProfileService {
	
	@PreAuthorize("hasPermission(#profile,'read') and #oauth2.hasScope('write')")
	public Profile create(Profile profile);
	
	@PreAuthorize("hasPermission(#id,'read') and #oauth2.hasScope('trust')")
	public void delete(Long id);
	
	@PreAuthorize("hasPermission(#profile,'read') and #oauth2.hasScope('write')")
	public Profile update(Profile profile);
	
	@PreAuthorize("hasPermission(#id,'read') and #oauth2.hasScope('read')")
	public Profile retriece(Long id);
	
	@PreAuthorize("hasPermission(#profile,'read') and #oauth2.hasScope('read')")
	public List<Profile> retrieveAll();
}
