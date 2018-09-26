package com.wendel.money.api.repository.lancamento;

import com.wendel.money.api.repository.filter.LancamentoFilter;
import com.wendel.money.api.model.Lancamento;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
