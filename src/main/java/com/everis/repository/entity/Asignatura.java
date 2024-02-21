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
public class Asignatura {
	@Id
	@Column
	private Integer id;
	
	@Column(length=20)
	private String nombre;
	
	@Column(length=50)
	private String descripcion;
	
	@Column
	private Integer curso;
}
