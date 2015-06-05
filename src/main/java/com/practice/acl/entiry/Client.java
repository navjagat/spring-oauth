package com.practice.acl.entiry;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(targetEntity=Grants.class)
	@JoinTable(name="client_grant", joinColumns={@JoinColumn(name="client_id")},
			inverseJoinColumns={@JoinColumn(name="grant_id")})
	private Set<Grants> grantType;
	
	@ManyToMany(targetEntity=Role.class)
	@JoinTable(name="client_role", joinColumns={@JoinColumn(name="client_id")},
			inverseJoinColumns={@JoinColumn(name="role_id")})
	private List<Role> roles;
	
	@Column(name="access_token_validity")
	private Integer accessTokenValidity;
	
	@Column(name="refresh_token_validity")
	private Integer refreshTokenValidity;
	
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
		this.roles = client.getRoles();
		this.clientId = client.getClientId();
		this.grantType = client.getGrantType();
		this.refreshTokenValidity = client.getRefreshTokenValidity();
		this.resourceId = client.getResourceId();
		this.account = client.getAccount();
		this.clientSecret = client.getClientSecret();
		this.autoApprove = client.isAutoApprove();

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

	public Set<Grants> getGrantType() {
		return grantType;
	}

	public void setGrantType(Set<Grants> grantType) {
		this.grantType = grantType;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public boolean isAutoApprove() {
		return autoApprove;
	}

	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
