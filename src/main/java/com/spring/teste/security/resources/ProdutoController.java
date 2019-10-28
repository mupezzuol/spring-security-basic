package com.spring.teste.security.resources;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/produto")
@RestController
public class ProdutoController {

	@GetMapping("/{id}")
	@ResponseBody
	public String listar(@PathVariable int id) {
		return "Lista do produto de id "+id+" consultada com sucesso.";
	}	
	
	@PostMapping
	@ResponseBody
	public String cadastrar() {
		return "Produto cadastrado com sucesso.";
	}
	
	@PutMapping
	@ResponseBody
	public String atualizar() {
		return "Produto atualizado com sucesso.";
	}	
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public String deletar(@PathVariable int id) {
		return "Produto de id "+id+ " foi deletado com sucesso.";
	}	
	
}
