package com.practice.acl.permission;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class CustomLogoutHandler extends SecurityContextLogoutHandler {

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		if (true) {
			HttpSession session = request.getSession(false);
			if (session != null)
				session.invalidate();
		}

		if (true) {
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(null);
		}

		SecurityContextHolder.clearContext();
		OAuth2Authentication auth = tokenStore
				.readAuthentication((String) authentication
						.getPrincipal());
		
		OAuth2AccessToken token = tokenStore.getAccessToken(auth);

		tokenStore.removeAccessToken(token);
	}
}
