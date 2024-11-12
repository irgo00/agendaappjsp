package br.edu.ifpr.irati.model;

import java.util.HashSet;
import java.util.Set;

public class Professor {

    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private boolean ativo;

    private Set<Disciplina> disciplinas;

    public Professor(){
        id = 0;
        nome = "";
        email = "";
        senha = "";
        ativo = true;
        disciplinas = new HashSet<>();
    }

    public Professor(Integer id, String nome, String email, String senha, boolean ativo, Set<Disciplina> disciplinas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.disciplinas = disciplinas;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
