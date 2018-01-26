package pnodder.data.repositories;

import org.springframework.stereotype.Repository;
import pnodder.data.domain.Workout;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class WorkoutRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    public Collection<Workout> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Workout", Workout.class);
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
