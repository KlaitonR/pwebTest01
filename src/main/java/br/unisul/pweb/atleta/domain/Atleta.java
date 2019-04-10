package br.unisul.pweb.atleta.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.unisul.pweb.atleta.domain.ENUM.Modalidade;

@Entity
public class Atleta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id //chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto encremento
	private Integer id;
	
	private Integer idModalidade;
	private String nome;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ATLETAS_COMPETICAO",
		joinColumns = @JoinColumn(name = "competicao_id"),
		inverseJoinColumns = @JoinColumn(name = "atleta_id")
	)
	private List<Competicao> competicoes = new ArrayList<Competicao>();
	
	public Atleta(){
		
	}
	
	public Atleta(Integer id, String nome,Modalidade idModalidade){
		super();
		this.id = id;
		this.nome = nome;
		this.idModalidade = (idModalidade==null)?null:idModalidade.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idModalidade == null) ? 0 : idModalidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idModalidade == null) {
			if (other.idModalidade != null)
				return false;
		} else if (!idModalidade.equals(other.idModalidade))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(Integer idModalidade) {
		this.idModalidade = idModalidade;   
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Competicao> getCompeticoes() {
		return competicoes;
	}

	public void setCompeticoes(List<Competicao> competicoes) {
		this.competicoes = competicoes;
	}
	
	public Modalidade getTipo() {
		return Modalidade.toEnum(idModalidade);
	}
	
	public Modalidade setTipo() {
		return Modalidade.toEnum(idModalidade);
	}
	
}
