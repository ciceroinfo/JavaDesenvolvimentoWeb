package com.ciceroinfo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundo")
	public String execute() {
		System.out.println("Teste de chamada do controller!!");
		return "ok";
	}
}
