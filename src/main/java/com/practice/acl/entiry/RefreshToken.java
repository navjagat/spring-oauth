package com.practice.acl.entiry;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oauth_refresh_token")
public class RefreshToken {
	
	@Id
	@Column(name="token_id")
	private String id;
	
	private Blob token;
	
	private Blob authentication;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Blob getToken() {
		return token;
	}

	public void setToken(Blob token) {
		this.token = token;
	}

	public Blob getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Blob authentication) {
		this.authentication = authentication;
	}
	
}
