package com.everis.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Rol /*implements GrantedAuthority*/{

	@Id
	@Column
	private Integer id;
	
	@Column
	private String rol;
	
	//@Overrride
	public String getAuthority() {
		return ("ROLE_"+this.rol).toUpperCase();
	}
	
}
