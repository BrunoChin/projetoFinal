package br.edu.ifal.projetofinal.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifal.projetofinal.app.modelo.Estudante;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioEstudante;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	RepositorioEstudante rp;
	public DemoApplication(){
		
		Estudante e1 = new Estudante("Bruno", 18);
		Estudante e2 = new Estudante("asdasd", 25);

		rp.save(e1);
		rp.save(e2);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
