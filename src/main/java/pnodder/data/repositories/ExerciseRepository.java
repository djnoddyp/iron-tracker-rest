package pnodder.data.repositories;

import pnodder.data.domain.Exercise;
import pnodder.data.domain.Workout;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ExerciseRepository {

    private static final String FIND_ALL = "Exercise.findAll";

    @Inject
    EntityManager em;

    public List<Exercise> findAll() {
        return em.createNamedQuery(FIND_ALL).getResultList();
    }
    
}
