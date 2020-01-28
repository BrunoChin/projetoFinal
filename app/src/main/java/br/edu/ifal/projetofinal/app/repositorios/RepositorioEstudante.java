package br.edu.ifal.projetofinal.app.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.edu.ifal.projetofinal.app.modelo.Estudante;

public interface RepositorioEstudante extends CrudRepository<Estudante, Long>{
    @Override
    List<Estudante> findAll();
}