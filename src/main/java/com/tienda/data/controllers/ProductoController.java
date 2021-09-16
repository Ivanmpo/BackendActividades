package com.tienda.data.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.data.models.Producto;
import com.tienda.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	
	private final ProductoService ps;
	public ProductoController(ProductoService ps) {
		this.ps = ps;
	}
	
	@RequestMapping("")
	public String index( @ModelAttribute("producto") Producto producto, Model model) {
		model.addAttribute("listaProductos", ps.findAll());
		return "producto/index.jsp";
	}
	
	
	//Crear
	@RequestMapping(value="/crear", method =RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto, Model model) {
		int errores = 0;
		ps.crear(producto);
		return "redirect:/producto";
	}
	
	//Actualizar y modificar
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		Producto producto = ps.buscar(id);
		model.addAttribute("producto", producto);
		return "producto/editar_producto.jsp";
	}
	
	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("empleado") Producto producto) {
		ps.modificar(producto);
		return "redirect:/producto";
	}
	
	
	//Eliminar
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		ps.eliminar(id);
		System.out.println("El ID (eliminar1) es : " + id);
		return "redirect:/producto";
	}
	
	
}
