package br.edu.ifal.projetofinal.app.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Responsavel extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Estudante> estudantes;

    public Responsavel() {
        this.estudantes = new ArrayList<Estudante>();
    }

    public Responsavel(String nome, String cpf, String rg) {
        super(nome, cpf, rg);
        this.estudantes = new ArrayList<Estudante>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
    
}