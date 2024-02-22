package com.everis.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.everis.repository.EmpleadoRepoJPA;
import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class EmpleadosRestControllerTest {

	private Empleado e1, e2;
	
	@Autowired
	EmpleadosRestController controller;

	@Autowired
	EmpleadoService service;

	@Autowired
	EmpleadoRepoJPA repo;
	
	@InjectMocks
	EmpleadosRestController restControllerMock;
	
	@Mock
	EmpleadoService serviceMock;
	
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
	void testInsertarEmpleado_v3() throws Exception{
		assertEquals(2,service.listar().size(),"Hay dos empleados en BBDD");
		
		Empleado e3 = new Empleado();
		e3.setNombre("N3");
		e3.setApellidos("AP3");
		controller.insertarEmpleado_v3(e3);
		
		assertEquals(3,service.listar().size(),"Hay tres empleados en BBDD");
	}

	@Test
	void testModificarEmpleado() {
		assertEquals(2,service.listar().size(),"Hay dos empleados en BBDD");
		
		String nuevoNombre = "Nuevo nombre";
		e2.setNombre(nuevoNombre);
		controller.modificarEmpleado(e2);
		
		assertEquals(2,service.listar().size(),"Sigue habiendo dos empleados en BBDD");
		assertEquals(nuevoNombre, service.getById(e2.getId()).getNombre(),"Nombre cambiado satisfactoriamente");
	}

	@Test
	void testListarEmpleados() {
		List<Empleado> le = controller.listarEmpleados();
		assertEquals(2,le.size(),"Hay dos empleados en BBDD");
	}

	@Test
	void testEliminarEmpleado() {
		assertEquals(2,service.listar().size(),"Hay dos empleados en BBDD");
		
		controller.eliminarEmpleado(e2.getId());
		
		assertEquals(1,service.listar().size(),"Solo queda un empleado en BBDD");
	}

	@Test
	void testDevuelveEmpleado() {
		ResponseEntity<Empleado> re = controller.devuelveEmpleado(e2.getId());
		
		assertNotNull(re.getBody(), "Encontrado empleado con id: "+e2.getId());
	}
	
	@Test
	void testInsertarEmpleado_v3Exception() throws Exception {
		when(serviceMock.inserta(e1)).thenThrow(new Exception());
		
		ResponseEntity<Empleado> re = restControllerMock.insertarEmpleado_v3(e1);
		
		assertThat(re.getStatusCodeValue()).isEqualTo(406);
	}

}
