package com.brq.app.bank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brq.app.bank.domain.Cartao;
import com.brq.app.bank.domain.Conta;
import com.brq.app.bank.repository.CartaoRepository;
import com.brq.app.bank.repository.ContaRepository;

@RestController
@RequestMapping(path="/bank")
public class CartaoController {

	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/simular")
	public List<Cartao> simular() {
		List<Cartao> cartoesSimulacao = preencherCartoesSimulacao();
		return cartoesSimulacao;
	}
	
	public List<Cartao> preencherCartoesSimulacao() {
		List<Cartao> cartoes = new ArrayList<>();
		cartoes.add(new Cartao(1L, "Visa Gold", "1111222233334444", new BigDecimal(1500.00)));
		cartoes.add(new Cartao(2L, "MasterCard Platinum", "1234978615739763", new BigDecimal(2000.00)));
		cartoes.add(new Cartao(3L, "Elo Platinum", "0123456789012345", new BigDecimal(2500.00)));
		return cartoes;
	}
	
	@PostMapping(path="/contratar", consumes="application/json", produces="application/json")
	public ResponseEntity<Object> contratar(@RequestBody Cartao cartao, @RequestParam Long idConta) {
		try {
			Conta conta = contaRepository.findById(idConta).get();
			cartao.setIdConta(idConta);
			cartaoRepository.save(cartao);
			return ResponseEntity.ok(conta);
		} catch(NoSuchElementException ex) {
			ex.printStackTrace();
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("status", HttpStatus.BAD_REQUEST);
			map.put("cause", "ID de conta inválido");
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@GetMapping(path="/cancelar")
	public Conta cancelar(@RequestParam(value="idCartao") Long idCartao, @RequestParam(value="idConta") Long idConta) {
		Conta conta = contaRepository.findById(idConta).get();
		Cartao cartao = cartaoRepository.findById(idCartao).get();
		conta.getCartoes().remove(cartao);
		contaRepository.save(conta);
		return conta;
	}
}
