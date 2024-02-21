package com.everis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

@RestController
@RequestMapping ("/rest/empleados")
public class EmpleadosRestController {

	@Autowired
	EmpleadoService empleadoService;
	
	@PostMapping
	@CacheEvict(value="empleados",allEntries=true)
	public void insertarEmpleado(@RequestBody Empleado emp) {
		empleadoService.inserta(emp);
	}
	
	@GetMapping
	@Cacheable (value="empleados")
	public List<Empleado> listarEmpleados(){
		/*try {
			Thread.sleep(1500);
		}catch(InterruptedException e) {}*/
		return empleadoService.listar();
	}
	
}
