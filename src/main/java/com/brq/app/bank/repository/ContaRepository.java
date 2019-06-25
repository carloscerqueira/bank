package com.brq.app.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.brq.app.bank.domain.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {
}
