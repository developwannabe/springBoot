package com.everis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.repository.EmpleadoRepoJPA;
import com.everis.service.EmpleadoService;
import com.everis.repository.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	EmpleadoRepoJPA empleadoRepo;
	
	@Override
	public void registrar(String name) {
		//empleadoRepo.registrar(name);
	}
	
	@Override
	public List<Empleado> listar() {
		return empleadoRepo.findAll(); 
	}
	
	@Override
	public List<Empleado> listarFiltroNombre(String cad){
		return empleadoRepo.listarCuyoNombreContiene(cad);
	}
	
	@Override
	public List<Empleado> listarConJPA(Integer pID, String contiene){
		return empleadoRepo.findByIdGreaterThanAndNombreLike(pID, contiene);
	}
	
	@Override
	public Empleado inserta(Empleado emp) throws Exception{
		if(emp != null) {
			empleadoRepo.save(emp);
			return emp;
		}else {
			return null;
		}
	}
	
	@Override
	public void modificar(Empleado emp) {
		empleadoRepo.save(emp);
	}
	
	@Override
	public void eliminar(Integer id) {
		empleadoRepo.deleteById(id);
	}
	
	@Override
	public Empleado getById(Integer id) {
		return empleadoRepo.findById(id).orElse(null);
	}
}
