/*package com.practice.acl.service.Impl;

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

import com.practice.acl.entiry.Client;
import com.practice.acl.repo.ClientRepository;

public class CustomClientDetailsService implements ClientDetailsService {

	@Autowired
	private ClientRepository repository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		Client client = repository.findOne(clientId);
		
		if(client == null)
			throw new ClientRegistrationException("NO client Found");
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
			return new HashSet<String>(getResourceId());
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
			return new HashSet<String>(getScopes());
		}

		@Override
		public Set<String> getAuthorizedGrantTypes() {
			return new HashSet<String>(getGrantType());
		}

		@Override
		public Set<String> getRegisteredRedirectUri() {
			return null;
		}

		@Override
		public Collection<GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList(getRole());
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
*/