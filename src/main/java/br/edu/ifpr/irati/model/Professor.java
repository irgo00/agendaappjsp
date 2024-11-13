package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//entity define que Professor terá uma tabela tb_professor
@Entity
public class Professor {

    //marca o campo de chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_professor")
    @SequenceGenerator(name="seq_professor", sequenceName = "professor_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name="nome", nullable = false, length = 200)
    private String nome;

    @Column(name="email", nullable = false, length = 200)
    private String email;

    @Column(name="senha", nullable = false, length = 10)
    private String senha;

    @Column(name="ativo")
    private boolean ativo;

    @Transient
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

    @Override
    public String toString() {
        return "Professor{" +
                "ativo=" + ativo +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
