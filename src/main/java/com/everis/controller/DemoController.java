package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.service.EmpleadoService;

@Controller
public class DemoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
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
	public String listarEmp(Model model) {
		model.addAttribute("listaEmp",empleadoService.listar());
		return "listarDeEmpleados";
	}
}