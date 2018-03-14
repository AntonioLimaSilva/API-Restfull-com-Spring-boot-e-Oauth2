package br.com.luciano.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luciano.moneyapi.model.Pessoa;

/**
 * 
 * @author Luciano Lima
 *
 */
@Repository
public interface Pessoas extends JpaRepository<Pessoa, Integer> {

}
