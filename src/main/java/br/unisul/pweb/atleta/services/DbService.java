package br.unisul.pweb.atleta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.atleta.domain.Atleta;
import br.unisul.pweb.atleta.domain.Competicao;
import br.unisul.pweb.atleta.domain.ENUM.Modalidade;
import br.unisul.pweb.atleta.repositories.AtletaRepository;
import br.unisul.pweb.atleta.repositories.CompeticaoRepository;

@Service
public class DbService {

	@Autowired
	private AtletaRepository repAtl;
	
	@Autowired
	private CompeticaoRepository RepComp;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Competicao cpt1 = new Competicao(null, "Competicao A", "10/06/2018");
		Competicao cpt2 = new Competicao(null, "Competicao B", "10/06/2017");
		Competicao cpt3 = new Competicao(null, "Competicao C", "10/06/2016");
		Competicao cpt4 = new Competicao(null, "Competicao D", "10/06/2016");
		
		RepComp.saveAll(Arrays.asList(cpt1,cpt2,cpt3,cpt4));
		
		Atleta atl1 = new Atleta(null, "Klaiton",Modalidade.FUTEBOL);
		Atleta atl2 = new Atleta(null, "Paulo",Modalidade.BASQUETE);
		Atleta atl3 = new Atleta(null, "Kleiton",Modalidade.CORRIDA);
		Atleta atl4 = new Atleta(null, "Gabriel", Modalidade.FUTEBOL);
		
		atl1.getCompeticoes().addAll(Arrays.asList(cpt1,cpt2,cpt3));
		atl2.getCompeticoes().addAll(Arrays.asList(cpt2,cpt4));
		atl3.getCompeticoes().addAll(Arrays.asList(cpt1,cpt3,cpt4));
		atl4.getCompeticoes().addAll(Arrays.asList(cpt1,cpt3));
		
		repAtl.saveAll(Arrays.asList(atl1,atl2,atl3,atl4));
		
	}
	
}
