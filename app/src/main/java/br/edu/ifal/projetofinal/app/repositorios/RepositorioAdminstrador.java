package br.edu.ifal.projetofinal.app.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifal.projetofinal.app.modelo.Administrador;

public interface RepositorioAdminstrador extends CrudRepository<Administrador, Long>{
    List<Administrador> findAll();
}