package br.edu.ifal.projetofinal.app.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Responsavel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    @Size(max = 11, min = 11)
    private String cpf;
    @NotNull
    @NotEmpty
    private String rg;
    @NotNull
    @NotEmpty
    private String senha;
    @OneToMany
    private List<Estudante> estudantes;

    public Responsavel() {
        this.estudantes = new ArrayList<Estudante>();
    }

    public Responsavel(String nome, String cpf, String rg, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.senha = senha;
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

    public void addEstudante(Estudante estudante){
        this.estudantes.add(estudante);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}