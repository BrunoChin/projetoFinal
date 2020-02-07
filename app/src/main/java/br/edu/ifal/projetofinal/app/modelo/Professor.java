package br.edu.ifal.projetofinal.app.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Professor extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @OneToOne
    // private Turma turma;

    public Professor() {
    }

    public Professor(String nome, String cpf, String rj) {
        super(nome, cpf, rj);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public Turma getTurma() {
    //     return turma;
    // }

    // public void setTurma(Turma turma) {
    //     this.turma = turma;
    // }

}