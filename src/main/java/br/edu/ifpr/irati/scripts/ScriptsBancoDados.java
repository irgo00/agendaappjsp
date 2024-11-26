package br.edu.ifpr.irati.scripts;

import br.edu.ifpr.irati.dao.Dao;
import br.edu.ifpr.irati.dao.DisciplinaDAO;
import br.edu.ifpr.irati.dao.GenericDAO;
import br.edu.ifpr.irati.dao.ProfessorDAO;
import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Disciplina;
import br.edu.ifpr.irati.model.Professor;
import br.edu.ifpr.irati.util.HibernateUtil;
import org.hibernate.Session;

public class ScriptsBancoDados {

    public static void main(String[] args) throws PersistenceException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Dao<Professor> professorDAO = new GenericDAO<>(Professor.class, session);
        Dao<Disciplina> disciplinaDAO = new GenericDAO<>(Disciplina.class, session);

        Professor professor = new Professor();
        professor.setNome("Valter");
        professor.setEmail("valter.junior@ifpr.edu.br");
        professor.setSenha("12345678");
        professor.setAtivo(true);
        professorDAO.salvar(professor);

        professorDAO.buscarTodos().forEach(System.out::println);

        professor.setNome("Valter Estevam");
        professorDAO.alterar(professor);

        professorDAO.buscarTodos().forEach(System.out::println);

        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Web 3");
        disciplina.setChave("12345678");
        disciplinaDAO.salvar(disciplina);


        session.close();

    }

}
