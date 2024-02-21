package com.everis.service;

import java.util.List;

import com.everis.repository.entity.Empleado;

public interface EmpleadoService {
	
	public void registrar (String name);
	public List<Empleado> listar();
	public List<Empleado> listarFiltroNombre(String cad);
	public List<Empleado> listarConJPA(Integer pID, String contiene);
	public void inserta(Empleado emp);
	
}
