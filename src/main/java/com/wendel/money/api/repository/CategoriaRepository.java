package com.wendel.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wendel.money.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
