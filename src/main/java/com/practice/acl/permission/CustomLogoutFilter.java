package com.practice.acl.permission;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutFilter extends LogoutFilter {

	public CustomLogoutFilter() {
		super(new SimpleUrlLogoutSuccessHandler(), new SecurityContextLogoutHandler());
	}	

}
