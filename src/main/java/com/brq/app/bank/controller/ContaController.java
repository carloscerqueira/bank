package com.brq.app.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.app.bank.domain.Conta;
import com.brq.app.bank.repository.ContaRepository;

@RestController
@RequestMapping(path="/bank")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping("/contas")
	public Iterable<Conta> list() {
		return contaRepository.findAll();
	}
	
	@GetMapping("/conta/{id}")
	public Optional<Conta> find(@PathVariable Long id){
		return contaRepository.findById(id);
	}
	
}
