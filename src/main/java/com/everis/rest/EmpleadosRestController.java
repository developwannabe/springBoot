package com.everis.rest;

import java.util.List;
import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.cache.annotation.CacheEvict;

import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

@RestController
@RequestMapping ("/api/empleados")
public class EmpleadosRestController {

	@Autowired
	EmpleadoService empleadoService;
	
	/*@PostMapping
	@CacheEvict(value="empleados",allEntries=true)
	public void insertarEmpleado(@RequestBody Empleado emp) {
		emp.setId(null);
		empleadoService.inserta(emp);
	}*/
	
	/*@PostMapping
	@CacheEvict(value="empleados",allEntries=true)
	public ResponseEntity<List<Empleado>> insertarEmpleado_v2(@RequestBody Empleado empleado) {
		try {
			System.out.println(empleado.getId()+" "+empleado.getNombre()+" "+empleado.getApellidos());
			empleadoService.inserta(empleado);
			return new ResponseEntity<> (empleadoService.listar(), HttpStatus.CREATED);
		}catch (Exception ex) {
			return new ResponseEntity<> (new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	@PostMapping
	@CacheEvict(value="empleados",allEntries=true)
	public ResponseEntity<Empleado> insertarEmpleado_v3 (@RequestBody Empleado empleado){
		try {
			HttpHeaders headers = new HttpHeaders();
			if (empleado.getId()!=null) {
				headers.set("Message", "Para dar de alta un nuevo empleado, el Id debe ser vacío");
				return new ResponseEntity<> (null, HttpStatus.NOT_ACCEPTABLE);
			}else if (empleado.getNombre() == null || empleado.getNombre()==""
					|| empleado.getApellidos()==null || empleado.getApellidos() =="") {
				headers.set("Message", "Nombre o apellidos nulos");
				return new ResponseEntity<> (null, HttpStatus.NOT_ACCEPTABLE);
			}
			Empleado emp = empleadoService.inserta(empleado);
			URI newPath = new URI("/api/empleados/"+emp.getId());
			headers.setLocation(newPath);
			headers.set("Message", "Empleado con ID: "+emp.getId()+" registrado.");
			
			return new ResponseEntity<> (emp, HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	@CacheEvict(value="empleados",allEntries=true)
	public void modificarEmpleado (@RequestBody Empleado empleado) {
		empleadoService.modificar(empleado);
	}
	
	@GetMapping
	@Cacheable (value="empleados")
	public List<Empleado> listarEmpleados(){
		/*try {
			Thread.sleep(1500);
		}catch(InterruptedException e) {}*/
		return empleadoService.listar();
	}
	
	@DeleteMapping(value="/{id}")
	@CacheEvict(value="empleados",allEntries=true)
	public void eliminarEmpleado (@PathVariable("id") Integer id) {
		empleadoService.eliminar(id);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Empleado> devuelveEmpleado(@PathVariable("id") Integer id){
		Empleado emp = empleadoService.getById(id);
		if(emp==null)return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
		else return new ResponseEntity<> (emp, HttpStatus.OK);
	}
	
}
