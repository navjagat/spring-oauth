package com.practice.acl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practice.acl.entiry.Client;
import com.practice.acl.entiry.Profile;
import com.practice.acl.permission.ActiveClient;
import com.practice.acl.service.ProfileService;

@RestController
@RequestMapping(value="/customer", produces=MediaType.APPLICATION_JSON_VALUE,
	consumes=MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Profile create(@RequestBody Profile profile, OAuth2Authentication authentication){
		
		profile.setCompany(authentication.getOAuth2Request().getClientId());
		return  service.create(profile);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Profile update(Profile profile){
		return service.update(profile);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Profile retrieve(@PathVariable Long id,  @ActiveClient Client client){
		return service.retriece(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Profile> retrieveAll(){
		return service.retrieveAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		service.delete(id);
	}
	
}
