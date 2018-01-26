package pnodder.data.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pnodder.data.domain.Workout;
import pnodder.data.repositories.WorkoutRepository;

import java.util.Collection;

@Service
@Transactional
public class WorkoutService {
    
    private WorkoutRepository repository;

    public WorkoutService(WorkoutRepository repository) {
        this.repository = repository;
    }

    public Collection<Workout> findAll() {
        return repository.findAll();
    }
    
}
