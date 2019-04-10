package br.unisul.pweb.atleta.domain.ENUM;

public enum Modalidade {

	NATACAO(1,"Natação"),
	CORRIDA(2,"Corrida"),
	ARTESMARCIAIS(3,"Artes Marciais"),
	FUTEBOL(4,"Futebol"),
	VOLEI(5,"Volei"),
	HANDBALL(6,"Handball"),
	BASQUETE(7,"Basquete");
	
	private int cod;
	private String descricao;
	
	private Modalidade(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Modalidade toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Modalidade x : Modalidade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
