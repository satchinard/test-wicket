package com.wicket.test.data.dao.impl;

import com.wicket.test.data.dao.IDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Classe DAO générique
 *
 * @author cyril
 */
public class DAO<T, PK extends java.io.Serializable> implements IDAO<T, PK> {

    @PersistenceContext(unitName = "testWicketPU")
    protected EntityManager em;
    protected Class<T> type;
    protected CriteriaBuilder cb;

    public DAO(Class<T> type) {
        this.type = type;
    }

    @Override
    public Class<T> getType() {
        return type;
    }

    protected CriteriaBuilder getCb() {
        if (this.cb != null) {
            return this.cb;
        }
        this.cb = em.getCriteriaBuilder();
        return this.cb;
    }

    @Override
    public EntityManager getEm() {
        return em;
    }

    @Override
    public T ajouter(T t) {
        em.persist(t);
        em.flush();
        return t;
    }

    @Override
    public T modifier(T t) {
        t = em.merge(t);
        em.flush();
        return t;
    }

    @Override
    public boolean supprimer(PK k) {
        T t = em.find(type, k);
        if (t == null) {
            return false;
        }
        em.remove(t);
        em.flush();
        return true;
    }

    @Override
    public T selectionner(PK k) {
        if (k == null) {
            return null;
        } else {
            return (T) em.find(this.type, k);
        }

    }

    @Override
    public List<T> lister() {
        CriteriaQuery<T> c = getCb().createQuery(type);
        Root<T> t = c.from(type);

        c.select(t);
        TypedQuery<T> q = em.createQuery(c);

        return (List<T>) q.getResultList();
    }

    @Override
    public void supprimer(T t) {
        em.remove(t);
    }

    @Override
    public void supprimer() {
        em.createQuery("DELETE FROM " + type.getSimpleName()).executeUpdate();
    }

}
