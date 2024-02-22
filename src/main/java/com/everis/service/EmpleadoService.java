package com.everis.service;

import java.util.List;

import com.everis.repository.entity.Empleado;

public interface EmpleadoService {
	
	public void registrar (String name);
	public List<Empleado> listar();
	public List<Empleado> listarFiltroNombre(String cad);
	public List<Empleado> listarConJPA(Integer pID, String contiene);
	public Empleado inserta(Empleado emp);
	public void modificar(Empleado emp);
	public void eliminar(Integer id);
	public Empleado getById(Integer id);
	
}
