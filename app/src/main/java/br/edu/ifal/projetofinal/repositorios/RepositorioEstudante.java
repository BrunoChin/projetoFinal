package br.edu.ifal.projetofinal.repositorios;

import org.springframework.data.repository.CrudRepository;
import br.edu.ifal.projetofinal.modelo.Estudante;

public interface RepositorioEstudante extends CrudRepository<Estudante, Long>{
    
}