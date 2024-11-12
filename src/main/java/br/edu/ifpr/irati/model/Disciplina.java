package br.edu.ifpr.irati.model;

import java.util.HashSet;
import java.util.Set;

public class Disciplina {

    private Integer id;
    private String nome;
    private String chave;
    private Set<Professor> professores;
    private Set<Aluno> alunos;
    private Set<Atividade> atividades;

    public Disciplina(){
        id = 0;
        nome = "";
        chave = "";
        professores = new HashSet<>();
        alunos = new HashSet<>();
        atividades = new HashSet<>();
    }

    public Disciplina(Professor professor){
        id = 0;
        nome = "";
        chave = "";
        professores = new HashSet<>();
        professores.add(professor);
        alunos = new HashSet<>();
        atividades = new HashSet<>();
    }

    public Disciplina(Integer id, String nome, String chave, Set<Professor> professores, Set<Aluno> alunos, Set<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.chave = chave;
        this.professores = professores;
        this.alunos = alunos;
        this.atividades = atividades;
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

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }
}
