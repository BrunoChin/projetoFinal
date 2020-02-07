package br.edu.ifal.projetofinal.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifal.projetofinal.app.repositorios.RepositorioEstudante;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioProfessor;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioTurma;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	RepositorioEstudante rpE;
	@Autowired
	RepositorioProfessor rpP;
	@Autowired
	RepositorioTurma rpT;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
