package com.wicket.test.data.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cagecfi
 */
public interface IDAO<T, PK extends java.io.Serializable> {

    Class<T> getType();

    EntityManager getEm();

    public T ajouter(T t);

    public T modifier(T t);

    public boolean supprimer(PK k);

    public void supprimer(T t);

    public void supprimer();

    public T selectionner(PK k);

    public List<T> lister();

}
