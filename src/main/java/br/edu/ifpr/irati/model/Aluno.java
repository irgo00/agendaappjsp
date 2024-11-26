package br.edu.ifpr.irati.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="TB_ALUNO")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
    @SequenceGenerator(name="seq_aluno", sequenceName = "aluno_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name="senha", nullable = false, length = 150)
    private String senha;

    @Transient
    private Set<Disciplina> disciplinas;

    @Transient
    private Set<Responsavel> responsaveis;

    @Transient
    private List<Tarefa> tarefas;
}
