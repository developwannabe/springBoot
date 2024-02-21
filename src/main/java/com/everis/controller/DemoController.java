package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cache.annotation.Cacheable;

import com.everis.service.EmpleadoService;
import com.everis.service.AsignaturaService;

@Controller
public class DemoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	AsignaturaService asignaturaService;
	
	@GetMapping("/saludo")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mundo") String name, Model model) {
		model.addAttribute("name", name);
		empleadoService.registrar(name);
		return "hola";
	}
	
	@GetMapping("/error")
	public String error_page() {
		return "error";
	}
	
	@GetMapping("/listarEmpleados")
	@Cacheable(value="empleados")
	public String listarEmp(Model model) {
		model.addAttribute("listaEmp",empleadoService.listar());
		model.addAttribute("listaEmpConE", empleadoService.listarFiltroNombre("e"));
		model.addAttribute("listaJPA", empleadoService.listarConJPA(2, "%o%"));
		return "listarDeEmpleados";
	}
	
	@GetMapping("/listarAsignaturas")
	@Cacheable(value="asignaturas")
	public String listarAsi(Model model) {
		model.addAttribute("listaAsi",asignaturaService.listar());
		return "listarDeAsignaturas";
	}
	
}