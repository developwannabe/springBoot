package com.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.repository.EmpleadoRepo;
import com.everis.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	EmpleadoRepo empleadoRepo;
	
	@Override
	public void registrar(String name) {
		empleadoRepo.registrar(name);
	}
}
