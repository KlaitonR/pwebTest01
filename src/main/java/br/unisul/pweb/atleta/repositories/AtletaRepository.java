package br.unisul.pweb.atleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.atleta.domain.Atleta;


@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

}
