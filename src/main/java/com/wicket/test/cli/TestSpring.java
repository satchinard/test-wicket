package com.wicket.test.cli;

import com.wicket.test.data.entite.Inscription;
import com.wicket.test.data.entite.Personne;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cagecfi
 */
public class TestSpring {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testWicketPU");
        EntityManager em = emf.createEntityManager();

        Personne p = new Personne("ATCHINARD", "Ada");
        Inscription i = new Inscription("KOFFI", "Koumah", new Date(), "Lomé", "Féminin");
        em.getTransaction().begin();
        em.persist(p);
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        System.out.println(p);
        System.exit(0);
    }
}
