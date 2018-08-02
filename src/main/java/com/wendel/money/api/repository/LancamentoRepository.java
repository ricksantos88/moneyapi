package com.wendel.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wendel.money.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
