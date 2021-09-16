package com.tienda.data.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.tienda.data.models.Usuario;
import com.tienda.data.services.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioService usService;
	public UsuarioController(UsuarioService empleadoService) {
		this.usService = empleadoService;
	}


	@RequestMapping("")
	public String index( @ModelAttribute("usuario") Usuario usuario, Model model) {

		model.addAttribute("listaUsuarios", usService.findAll());
		return "usuario/index.jsp";
	}
	
	
	//Crear
	@RequestMapping(value="/crear", method =RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario) {
		usService.crearUsuario(usuario);
		System.out.println("crear : " + usuario.getRut());
		return "redirect:/usuario";
	}
	
	//Actualizar y modificar
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		Usuario usuario = usService.buscarUsuario(id);
		model.addAttribute("usuario", usuario);
		return "usuario/editar_usuario.jsp";
	}
	
	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("empleado") Usuario usuario) {
		usService.modificarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	
	//Eliminar
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		usService.eliminarUsuario(id);
		System.out.println("El ID (eliminar1) es : " + id);
		return "redirect:/usuario";
	}
	

	
}
