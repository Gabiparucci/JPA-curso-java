package com.teste.basico;

import com.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        Usuario novo = new Usuario("Mateus", "gabis@gmail.com");

        em.getTransaction().begin();
        em.persist(novo);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
