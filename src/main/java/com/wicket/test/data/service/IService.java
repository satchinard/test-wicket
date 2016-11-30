package com.wicket.test.data.service;

import java.util.List;

/**
 *
 * @author cagecfi
 */
public interface IService<T, PK extends java.io.Serializable>
        extends java.io.Serializable {

    public T ajouter(T t);

    public T modifier(T t);

    public boolean supprimer(PK k);

    public void supprimer(T t);

    public void supprimer();

    public T selectionner(PK k);

    public List<T> lister();
}
