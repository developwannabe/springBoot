package com.everis.repository.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.everis.DemoWebApplication;
import com.everis.repository.EmpleadoRepo;

@Repository
public class EmpleadoRepoImpl implements EmpleadoRepo{
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(DemoWebApplication.class);
	
	@Override
	public void registrar(String nombre) {
		LOG.info("Se ha saludado al empleado: "+nombre);
	}
}
