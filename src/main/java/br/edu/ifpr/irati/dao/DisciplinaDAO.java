package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Disciplina;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class DisciplinaDAO {

    private Session session;

    public DisciplinaDAO(Session session){
        this.session = session;
    }

    public void salvar(Disciplina disciplina) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.persist(disciplina);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao salvar uma disciplina");
        }
    }

    public void alterar(Disciplina disciplina) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(disciplina);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao alterar uma disciplina");
        }
    }

    public void excluir(Disciplina disciplina) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.remove(disciplina);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao excluir uma disciplina");
        }
    }

    public Disciplina buscarPorId(Serializable id) throws PersistenceException{
        Disciplina disciplina = null;
        try{
            disciplina = (Disciplina) session.find(Disciplina.class, id);
            return disciplina;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por id");
        }
    }

    public List<Disciplina> buscarTodos() throws PersistenceException{
        try{
            String hql = "from Disciplina";
            Query query = session.createQuery(hql, Disciplina.class);
            List results = query.getResultList();
            return results;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por disciplinas.");
        }
    }

}
