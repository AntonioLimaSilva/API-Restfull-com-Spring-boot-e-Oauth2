package br.com.luciano.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luciano.moneyapi.model.Categoria;

/**
 * 
 * @author Luciano Lima
 *
 */
@Repository
public interface Categorias extends JpaRepository<Categoria, Integer> {

}