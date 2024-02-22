package com.everis.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.repository.EmpleadoRepoJPA;
import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

class EmpleadosRestControllerTest {

	private Empleado e1, e2;

	@Autowired
	EmpleadoService service;

	@Autowired
	EmpleadoRepoJPA repo;

	@Test
	void testInsertarEmpleado_v3() {
		fail("Not yet implemented");
	}

	@Test
	void testModificarEmpleado() {
		fail("Not yet implemented");
	}

	@Test
	void testListarEmpleados() {
		service.registrar("texto prueba");
	}

	@Test
	void testEliminarEmpleado() {
		fail("Not yet implemented");
	}

	@Test
	void testDevuelveEmpleado() {
		fail("Not yet implemented");
	}

}
