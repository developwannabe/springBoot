package com.everis.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Usuario /*implements UserDetails*/{
	
	@Id
	@Column
	private String username;
	
	@Column(name = "nombre", nullable = false, length=50)
	private String nombreYapellidos;
	
	@Column(nullable=false)
	private String password;
	
	@OneToOne(optional=false)
	private Rol rol;
}
