package com.everis.repository.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Test;

class EmpleadoTest {

	@Test
	void test() {
		Empleado e1 = new Empleado();

		e1.setId(1);
		assertEquals(1, e1.getId(), "Mismo ID");

		String nombre = "Nombre prueba";
		e1.setNombre(nombre);
		assertEquals(nombre, e1.getNombre(), "Mismo nombre");

		String apellidos = "Nombre prueba";
		e1.setApellidos(apellidos);
		assertEquals(apellidos, e1.getApellidos(), "Mismos apellidos");

		Empleado e2 = new Empleado();
		e2.setId(1);
		e2.setNombre(nombre);
		e2.setApellidos(apellidos);
		assertEquals(e1, e2, "Mismo empleado");
	}

}
