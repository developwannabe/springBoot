package com.everis.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.everis.repository.EmpleadoRepoJPA;
import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class EmpleadoServiceImplTest {
	
	private Empleado e1,e2;

	@Autowired
	EmpleadoService service;
	
	@Autowired
	EmpleadoRepoJPA repo;
	
	@BeforeEach
	void setUp() throws Exception {
		repo.deleteAll();
		e1 = new Empleado();
		e1.setNombre("Manuel");
		e1.setApellidos("Muñoz Martínez");
		e1 = repo.save(e1);

		e2 = new Empleado();
		e2.setNombre("Ana");
		e2.setApellidos("Alexa Armani");
		e2 = repo.save(e2);
	}

	@AfterEach
	void tearDown() throws Exception {
		repo.deleteAll();
	}
	
	@Test
	void testRegistrar() {
		service.registrar("texto.prueba");
	}

	@Test
	void testListar() {
		List <Empleado> le = service.listar();
		assertEquals(2,le.size(),"Hay dos empleados en la BBDD");
	}

	@Test
	void testListarFiltroNombre() {
		assertEquals(2, service.listar().size(), "Hay dos empleados en BBDD");
		
		List<Empleado> le = service.listarFiltroNombre("u");
		
		assertEquals(1,le.size(),"Hay un empleado en BBDD con nombre que contiene una 'u'");
	}

	@Test
	void testListarConJPA() {
		assertEquals(2, service.listar().size(), "Hay dos empleados en BBDD");
		
		List<Empleado> le = service.listarConJPA(e1.getId(),"%a");
		
		assertEquals(1,le.size(),"Hay un empleado en con id>"+e1.getId()+" y que contenga 'a'");
	}

	@Test
	void testInserta() {
		assertEquals(2, service.listar().size(), "Hay dos empleados en BBDD");
		
		Empleado e3 = new Empleado();
		e3.setNombre("N3");
		e3.setApellidos("AP3");
		e3 = service.inserta(e3);
		
		assertEquals(3, service.listar().size(), "Hay tres empleados en BBDD");
	}

	@Test
	void testModificar() {
		assertEquals(2, service.listar().size(), "Hay dos empleados en BBDD");
		
		String nuevoNombre = "Nuevo nombre";
		e2.setNombre(nuevoNombre);
		service.modificar(e2);
		
		assertEquals(2, service.listar().size(), "Sigue habiendo dos empleados en BBDD");
		assertEquals(nuevoNombre, service.getById(e2.getId()).getNombre(), "Nombre modificado");
	}

	@Test
	void testEliminar() {
		assertEquals(2, service.listar().size(), "Hay dos empleados en BBDD");
		
		service.eliminar(e2.getId());
		
		assertEquals(1, service.listar().size(), "Solo queda un empleado en BBDD");
	}

	@Test
	void testGetById() {
		Empleado e3 = service.getById(e2.getId());
		
		assertNotNull(e3, "Encontrado empleado con id: "+e2.getId());
	}

}
