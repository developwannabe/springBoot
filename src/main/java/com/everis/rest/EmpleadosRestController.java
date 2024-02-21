package com.everis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

@RestController
@RequestMapping ("/rest/empleados")
public class EmpleadosRestController {

	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping
	public List<Empleado> listarEmpleados(){
		return empleadoService.listar();
	}
	
}
