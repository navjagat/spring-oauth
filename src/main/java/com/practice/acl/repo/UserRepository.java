package com.practice.acl.repo;

import org.springframework.data.repository.CrudRepository;

import com.practice.acl.entiry.User;

public interface UserRepository extends CrudRepository<User, String> {

}
