package com.practice.acl.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.acl.entiry.Client;
import com.practice.acl.repo.ClientRepository;
import com.practice.acl.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public Client retrieve(String clientId) {
		return repository.findOne(clientId);
	}

	@Override
	public List<Client> retrieveAll(String company) {
		return repository.findAll();
	}

	@Override
	public Client create(Client client) {
		return repository.save(client);
	}

	@Override
	public Client update(Client client) {
		return create(client);
	}

}
