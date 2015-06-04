package com.practice.acl.service.Impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.practice.acl.entiry.User;
import com.practice.acl.repo.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = repository.findOne(username);
		if(user == null)
			throw new UsernameNotFoundException("No User Found");
		
		return new CustomUserDetails(user);
	}
	
	private static class CustomUserDetails extends User implements UserDetails {
		
		private static final long serialVersionUID = -8753678863757979816L;
		private User user;
		
		public CustomUserDetails(User user) {
			this.user = user;
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList(user.getRole());
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
