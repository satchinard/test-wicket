package com.wicket.test.data.dao.impl;

import com.wicket.test.data.dao.IPersonneDAO;
import com.wicket.test.data.entite.Personne;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cagecfi
 */
@Repository("personneDAO")
public class PersonneDAO extends DAO<Personne, Integer> implements IPersonneDAO {

    public PersonneDAO() {
        super(Personne.class);
    }

}
