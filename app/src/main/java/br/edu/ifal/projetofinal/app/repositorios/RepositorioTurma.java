package br.edu.ifal.projetofinal.app.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.edu.ifal.projetofinal.app.modelo.Turma;

public interface RepositorioTurma extends CrudRepository<Turma, Long>{
    List<Turma> findAll();
}