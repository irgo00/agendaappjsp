package br.edu.ifpr.irati.model;

import java.time.LocalDateTime;

public class Atividade {

    protected Integer id;
    protected String descricao;
    protected LocalDateTime dataHora;
    protected Disciplina disciplina;

    public Atividade(){
        id = 0;
        descricao = "";
        dataHora = LocalDateTime.now();
    }

    public Atividade(Integer id, String descricao, LocalDateTime dataHora, Disciplina disciplina) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
