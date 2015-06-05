package com.practice.acl.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.acl.entiry.Client;

public interface ClientRepository extends CrudRepository<Client, String> {
	
	public List<Client> findAll();
}
