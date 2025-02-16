package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Disciplina;
import br.edu.ifpr.irati.model.Professor;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class DisciplinaDAO implements DisciplinaDao{

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

    public Disciplina buscarPorChave(String chave) throws PersistenceException{
        Disciplina disciplina = null;
        try{
            String hql = "FROM Disciplina d WHERE d.chave = :chave";
            Query<Disciplina> query = session.createQuery(hql, Disciplina.class);
            query.setParameter("chave", chave);
            return query.uniqueResult();
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
