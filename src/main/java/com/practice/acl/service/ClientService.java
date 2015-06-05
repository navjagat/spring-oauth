package com.practice.acl.service;

import java.util.List;

import com.practice.acl.entiry.Client;

public interface ClientService {

	public Client retrieve(String clientId);
	
	public List<Client> retrieveAll(String company);
	
	public Client create(Client client);
	
	public Client update(Client client);

}
