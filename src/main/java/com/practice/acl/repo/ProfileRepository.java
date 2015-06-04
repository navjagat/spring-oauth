package com.practice.acl.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.acl.entiry.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
	
	public List<Profile> findAll();
}
