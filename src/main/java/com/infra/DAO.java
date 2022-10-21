package com.infra;

import com.modelo.basico.Entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class DAO<E extends Entidade> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa");
        } catch (Exception e) {

        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {
       return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public List<E> obterTodos(int qtd, int pagina) {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe está nula.");
        }
        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe).setMaxResults(qtd).setFirstResult(pagina);
        return query.getResultList();
    }

    public List<E> obterTodos() {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe está nula.");
        }
        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        return query.getResultList();
    }

    public void fechar() {
        em.close();
    }
}
