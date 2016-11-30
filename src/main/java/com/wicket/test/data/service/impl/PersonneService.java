package com.wicket.test.data.service.impl;

import com.wicket.test.data.dao.IDAO;
import com.wicket.test.data.dao.IPersonneDAO;
import com.wicket.test.data.entite.Personne;
import com.wicket.test.data.service.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cagecfi
 */
@Service("personneService")
public class PersonneService extends TestService<Personne, Integer> implements IPersonneService {

    @Autowired
    private IPersonneDAO personneDAO;

    @Override
    public IDAO<Personne, Integer> getDao() {
        return personneDAO;
    }

    public void supprimer(Personne t) {
        personneDAO.getEm().remove(t);
    }

}
