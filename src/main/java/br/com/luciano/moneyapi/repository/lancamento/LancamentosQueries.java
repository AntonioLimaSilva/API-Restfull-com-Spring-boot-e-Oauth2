package br.com.luciano.moneyapi.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.luciano.moneyapi.model.Lancamento;
import br.com.luciano.moneyapi.repository.filter.LancamentoFilter;
import br.com.luciano.moneyapi.repository.projection.ResumoLancamento;

/**
 * 
 * @author Luciano Lima
 *
 */
public interface LancamentosQueries {
	
	Page<Lancamento> filtrar(LancamentoFilter filtro, Pageable pageable);
	
	Page<ResumoLancamento> resumir(LancamentoFilter filtro, Pageable pageable);

}
