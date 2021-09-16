package com.tienda.data.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.data.models.Venta;
import com.tienda.data.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private final VentaService vs;
	public VentaController(VentaService vs) {
		this.vs = vs;
	}


	@RequestMapping("")
	public String index( @ModelAttribute("usuario") Venta venta, Model model) {

		model.addAttribute("listaVentas", vs.findAll());
		return "";
	}
	
	//Crear
	@RequestMapping(value="/crear", method =RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("venta") Venta venta) {
		vs.crearVenta(venta);
		return "";
	}
	
	//Actualizar y modificar
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		Venta venta = vs.buscarVenta(id);
		model.addAttribute("venta", venta);
		return "";
	}
	
	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("empleado") Venta venta) {
		vs.modificarVenta(venta);
		return "";
	}
	
	
	//Eliminar
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		vs.eliminarVenta(id);
		System.out.println("El ID (eliminar1) es : " + id);
		return "";
	}
}
