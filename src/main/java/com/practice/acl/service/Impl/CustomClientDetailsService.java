package com.practice.acl.service.Impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import com.practice.acl.entiry.Client;
import com.practice.acl.entiry.Grants;
import com.practice.acl.entiry.Role;
import com.practice.acl.entiry.Scope;
import com.practice.acl.service.ClientService;

public class CustomClientDetailsService implements ClientDetailsService {

	@Autowired
	private ClientService service;

	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		Client client = service.retrieve(clientId);

		if (client == null)
			throw new NoSuchClientException("NO client Found for ClientId:"+clientId);
		return new CustomClientDetails(client);
	}

	private static class CustomClientDetails extends Client implements
			ClientDetails {

		private static final long serialVersionUID = -5128682177211689391L;

		public CustomClientDetails(Client client) {
			super(client);
		}

		@Override
		public Set<String> getResourceIds() {
			
			String[] resources = getResourceId().split(",");
			return new HashSet<String>(Arrays.asList(resources));
		}

		@Override
		public boolean isSecretRequired() {
			return true;
		}

		@Override
		public boolean isScoped() {
			return true;
		}

		@Override
		public Set<String> getScope() {
			
			HashSet<String> scopes = new HashSet<String>();
			
			for(Role role : getRoles()){
				for(Scope scope : role.getScopes())
				scopes.add(scope.getScope());
			}
			
			return scopes;
		}

		@Override
		public Set<String> getAuthorizedGrantTypes() {
			HashSet<String> grants = new HashSet<String>();
			
			for(Grants grant : getGrantType())
				grants.add(grant.getGrant());
			
			return grants;
		}

		@Override
		public Set<String> getRegisteredRedirectUri() {
			return null;
		}

		@Override
		public Collection<GrantedAuthority> getAuthorities() {
			String[] authority = new String[getRoles().size()];
			
			Integer i = 0;
			for(Role role : getRoles())
				authority[i++] = role.getRole();
			
			return AuthorityUtils.createAuthorityList(authority);
		}

		@Override
		public Integer getAccessTokenValiditySeconds() {
			return getAccessTokenValidity();
		}

		@Override
		public Integer getRefreshTokenValiditySeconds() {
			return getRefreshTokenValidity();
		}

		@Override
		public boolean isAutoApprove(String scope) {
			return true;
		}

		@Override
		public Map<String, Object> getAdditionalInformation() {
			return null;
		}

	}

}
