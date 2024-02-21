package com.everis.repository.impl;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.everis.repository.AsignaturaRepo;

@Repository
public class AsignaturaRepoImpl implements AsignaturaRepo{
	
	@PersistenceContext
	EntityManager entityManager;

}
