package br.edu.ifal.projetofinal.app.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifal.projetofinal.app.modelo.Responsavel;

public interface RepositorioResponsavel extends CrudRepository<Responsavel, Long>{
    List<Responsavel> findAll();
}