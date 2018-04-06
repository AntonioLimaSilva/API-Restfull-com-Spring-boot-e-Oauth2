package br.com.luciano.moneyapi.model;

public enum TipoLancamento {

	RECEITA("Receita"), 
	DESPEZA("Despeza");

	private String descricao;

	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
