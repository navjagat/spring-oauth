package com.practice.acl.entiry;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	
	private String role;
	
	@ManyToMany(targetEntity=Scope.class)
	@JoinTable(name="role_scope", joinColumns={@JoinColumn(name="role_id")},
	inverseJoinColumns={@JoinColumn(name="scope_id")})
	private Set<Scope> scopes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Scope> getScopes() {
		return scopes;
	}

	public void setScopes(Set<Scope> scopes) {
		this.scopes = scopes;
	}
	
	
}
