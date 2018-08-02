package com.wendel.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wendel.money.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
