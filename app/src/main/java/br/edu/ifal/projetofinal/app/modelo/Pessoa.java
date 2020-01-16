package br.edu.ifal.projetofinal.app.modelo;

public class Pessoa{
    
    private String nome;
    private String cpf;
    private String rj;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String rj) {
        this.nome = nome;
        this.cpf = cpf;
        this.rj = rj;
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

    public String getRj() {
        return rj;
    }

    public void setRj(String rj) {
        this.rj = rj;
    }

    
    
}
