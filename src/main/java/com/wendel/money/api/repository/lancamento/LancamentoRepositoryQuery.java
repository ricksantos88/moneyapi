package com.wendel.money.api.repository.lancamento;

import com.wendel.money.api.repository.filter.LancamentoFilter;
import com.wendel.money.api.model.Lancamento;

import java.util.List;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
}
