package com.wendel.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wendel.money.api.model.Lancamento;
import com.wendel.money.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery  {

}
