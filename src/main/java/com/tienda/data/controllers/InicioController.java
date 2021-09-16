package com.tienda.data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class InicioController {

	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
}
