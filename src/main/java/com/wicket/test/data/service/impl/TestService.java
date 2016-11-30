package com.wicket.test.data.service.impl;

import com.wicket.test.data.dao.IDAO;
import com.wicket.test.data.service.IService;
import java.util.Collections;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cagecfi
 */
public abstract class TestService<T, PK extends java.io.Serializable>
        implements IService<T, PK> {

    public abstract IDAO<T, PK> getDao();

    @Override
    @Transactional("testWicket")
    public synchronized T ajouter(T t) {
        return this.getDao().ajouter(t);
    }

    @Transactional("testWicket")
    @Override
    public synchronized T modifier(T t) {
        return this.getDao().modifier(t);
    }

    @Transactional("testWicket")
    @Override
    public synchronized boolean supprimer(PK k) {
        return this.getDao().supprimer(k);
    }

    @Override
    @Transactional("testWicket")
    public T selectionner(PK k) {
        try {
            return (T) this.getDao().selectionner(k);
        }
        catch (EmptyResultDataAccessException ex) {
        }
        catch (Exception ex) {
        }
        return null;
    }

    @Override
    @Transactional("testWicket")
    public List<T> lister() {
        try {
            return this.getDao().lister();
        }
        catch (Exception ex) {
            return Collections.EMPTY_LIST;
        }
    }

    @Transactional("testWicket")
    @Override
    public void supprimer() {
        try {
            this.getDao().supprimer();
        }
        catch (Exception ex) {
        }
    }

}
