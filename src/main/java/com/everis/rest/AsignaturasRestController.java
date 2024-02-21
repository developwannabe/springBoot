package com.everis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.annotation.Cacheable;

import com.everis.repository.entity.Asignatura;
import com.everis.service.AsignaturaService;

@RestController
@RequestMapping ("/rest/asignaturas")
public class AsignaturasRestController {

	@Autowired
	AsignaturaService asignaturaService;
	
	@GetMapping
	@Cacheable (value="empleados")
	public List<Asignatura> listarEmpleados(){
		/*try {
			Thread.sleep(1500);
		}catch(InterruptedException e) {}*/
		return asignaturaService.listar();
	}
	
}
