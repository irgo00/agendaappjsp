package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Professor;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class ProfessorDAO {

    private Session session;

    public ProfessorDAO(Session session){
        this.session = session;
    }

    public void salvar(Professor professor) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.persist(professor);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao salvar um professor");
        }
    }

    public void alterar(Professor professor) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(professor);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao alterar um professor");
        }
    }

    public void excluir(Professor professor) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.remove(professor);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao excluir um professor");
        }
    }

    public Professor buscarPorId(Serializable id) throws PersistenceException{
        Professor professor = null;
        try{
            professor = (Professor) session.find(Professor.class, id);
            return professor;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por id");
        }
    }

    public List<Professor> buscarTodos() throws PersistenceException{
        try{
            String hql = "from Professor";
            Query query = session.createQuery(hql, Professor.class);
            List results = query.getResultList();
            return results;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por professores.");
        }
    }

}
