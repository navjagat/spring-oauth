package com.practice.acl.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.acl.entiry.Profile;
import com.practice.acl.repo.ProfileRepository;
import com.practice.acl.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository repo;
	
	@Override
	public Profile create(Profile profile) {
		return repo.save(profile);
	}

	@Override
	public void delete(Long id) {
		repo.delete(id);
	}

	@Override
	public Profile update(Profile profile) {
		return create(profile);
	}

	@Override
	public Profile retriece(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Profile> retrieveAll() {
		return repo.findAll();
	}

}
