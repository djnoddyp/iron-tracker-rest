package pnodder.services;

import pnodder.domain.Workout;
import pnodder.repositories.WorkoutRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class WorkoutService {

    @Inject
    private WorkoutRepository workoutRepository;
    
    @Inject
    Event<Workout> event;

    public Workout findById(Long id) {
        return workoutRepository.findById(id);
    }

    public Iterable<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public void save(Workout workout) {
        workoutRepository.save(workout);
        event.fireAsync(workout);
    }
}
