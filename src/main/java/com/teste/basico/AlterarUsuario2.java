package com.teste.basico;

import com.modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, 1L);

        //caso não seja feito o detach o objeto vai ser alterado mesmo que não tenha o merge
        em.detach(usuario);
        em.merge(usuario);

        usuario.setNome("Gabriela Parucci");

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
