package br.edu.ifal.projetofinal.app.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idade;
    // @ManyToOne
    // private Turma turma;

    public Estudante() {
        
    }

    public Estudante(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // public Estudante(String nome, Integer idade, Turma turma) {
    //     this.nome = nome;
    //     this.idade = idade;
    //     this.turma = turma;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    // public Turma getTurma() {
    //     return turma;
    // }

    // public void setTurma(Turma turma) {
    //     this.turma = turma;
    // }

   


}