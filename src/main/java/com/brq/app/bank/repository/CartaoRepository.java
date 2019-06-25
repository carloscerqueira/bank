package com.brq.app.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.app.bank.domain.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {
}
