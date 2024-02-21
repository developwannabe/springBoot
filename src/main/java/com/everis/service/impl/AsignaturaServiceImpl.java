package com.everis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.repository.AsignaturaRepoJPA;
import com.everis.service.AsignaturaService;
import com.everis.repository.entity.Asignatura;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
	
	@Autowired
	AsignaturaRepoJPA asignaturaRepo;
	
	
	@Override
	public List<Asignatura> listar() {
		return asignaturaRepo.findAll(); 
	}
	
}