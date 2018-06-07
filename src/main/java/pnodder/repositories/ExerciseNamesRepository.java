package pnodder.repositories;

import pnodder.domain.ExerciseNames;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ExerciseNamesRepository {
    
    private static final String FIND_ALL = "ExerciseNames.findAll";

    @Inject
    EntityManager em;

    public List<ExerciseNames> findAll() {
        return em.createNamedQuery(FIND_ALL).getResultList();
    }
    
}
