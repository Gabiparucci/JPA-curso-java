package com.teste.basico;

import com.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();


        String jpql = "select u from Usuario u";

        List<Usuario> usuarios = em.createQuery(jpql, Usuario.class).setMaxResults(5).getResultList();
        usuarios.forEach(i -> System.out.println(i.getNome()));

        em.close();
        emf.close();
    }
}
