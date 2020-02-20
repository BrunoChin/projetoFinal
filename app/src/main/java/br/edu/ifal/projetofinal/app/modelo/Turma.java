package br.edu.ifal.projetofinal.app.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Turma{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String numero;
    @OneToOne( cascade = CascadeType.ALL)
    private Professor professor;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Estudante> estudantes;

    public Turma(String numero, Professor professor) {
        this.numero = numero;
        this.professor = professor;
        estudantes = new ArrayList<Estudante>();
    }

    public Turma() {
        estudantes = new ArrayList<Estudante>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void addEstudante(Estudante estudante){
        this.estudantes.add(estudante);
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
    
}