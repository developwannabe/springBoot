package com.everis.repository.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.everis.DemoWebApplication;
import com.everis.repository.EmpleadoRepo;
import com.everis.repository.entity.Empleado;



@Repository
public class EmpleadoRepoImpl implements EmpleadoRepo{
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(DemoWebApplication.class);
	
	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public void registrar(String nombre) {
		LOG.info("Se ha saludado al empleado: "+nombre);
	}
	
	public List<Empleado> listarCuyoNombreContiene(String texto_nombre){
		Query query = entitymanager.createNativeQuery("SELECT * FROM empleado " +
						"WHERE nombre LIKE ?", Empleado.class);
		query.setParameter(1, "%" + texto_nombre + "%");
		return query.getResultList();
	}
	
}
