package br.edu.ifpr.irati.model;

import java.util.HashSet;
import java.util.Set;

public class Responsavel {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private Set<Aluno> alunos;

    public Responsavel(){
        id = 0;
        nome = "";
        email = "";
        telefone = "";
        alunos = new HashSet<>();
    }

    public Responsavel(Integer id, String nome, String email, String telefone, Set<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
}
