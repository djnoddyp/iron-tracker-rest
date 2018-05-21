package pnodder.data.repositories;

import pnodder.data.domain.Workout;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class WorkoutRepository {

    private static final String FIND_ALL = "Workout.findAll";
    private static final String FIND_BY_ID = "Workout.findById";

    @Inject
    EntityManager em;
    
    public List<Workout> findAll() {
        return em.createNamedQuery(FIND_ALL).getResultList();
    }

    public Workout findById(Long id) {
        return (Workout) em.createNamedQuery(FIND_BY_ID).setParameter("id", id).getSingleResult();
    }
    
    public void save(Workout workout) {
        em.persist(workout);
    }
}
