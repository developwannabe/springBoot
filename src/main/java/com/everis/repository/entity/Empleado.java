package com.everis.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "empleado_seq", sequenceName = "empleado_seq", allocationSize = 1)
	@Column
	private Integer id;
	
	@Column(nullable = false, length=30)
	private String nombre;
	
	@Column
	private String apellidos;
}
