package com.practice.acl.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oauth_client_details")
public class Client {
	
	@Id
	@Column(name="client_id")
	private String clientId;
	
	@Column(name="resource_ids")
	private String resourceId;
	
	@Column(name="client_secret")
	private String clientSecret;
	
	@Column(name="authorized_grant_types")
	private String grantType;
	
	private String scope;
	
	private String authorities;
	
	@Column(name="access_token_validity")
	private int accessTokenValidity;
	
	@Column(name="refresh_token_validity")
	private int refreshTokenValidity;
	
	@Column(name="web_server_redirect_uri")
	private String redirectUri;
	
	@Column(name="additional_information")
	private String additionalInfo;
	
	private boolean autoApprove;
	
	private String account;

	public Client(){
		
	}
	
	public Client(Client client) {
		this.accessTokenValidity = client.getAccessTokenValidity();
		this.authorities = client.getAuthorities();
		this.clientId = client.getClientId();
		this.grantType = client.getGrantType();
		this.refreshTokenValidity = client.getRefreshTokenValidity();
		this.resourceId = client.getResourceId();
		this.scope = client.getScope();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scopes) {
		this.scope = scopes;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String roles) {
		this.authorities = roles;
	}

	public int getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(int accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public int getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(int refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	/**
	 * @return the redirectUri
	 */
	public String getRedirectUri() {
		return redirectUri;
	}

	/**
	 * @param redirectUri the redirectUri to set
	 */
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	/**
	 * @return the additionalInfo
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	/**
	 * @return the autoApprove
	 */
	public boolean isAutoApprove() {
		return autoApprove;
	}

	/**
	 * @param autoApprove the autoApprove to set
	 */
	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}	
}
