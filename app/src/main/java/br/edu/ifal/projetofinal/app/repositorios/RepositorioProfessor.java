package br.edu.ifal.projetofinal.app.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifal.projetofinal.app.modelo.Professor;

public interface RepositorioProfessor extends CrudRepository<Professor, Long>{
    
}