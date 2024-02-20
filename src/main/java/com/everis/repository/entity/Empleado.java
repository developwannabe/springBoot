package com.everis.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Empleado {
	@Id
	@Column
	private Integer id;
	
	@Column(nullable = false, length=30)
	private String nombre;
	
	@Column
	private String apellidos;
}
