package pnodder.data.services;

import pnodder.data.domain.Workout;
import pnodder.data.repositories.WorkoutRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class WorkoutService {

    @Inject
    private WorkoutRepository workoutRepository;

    public Workout findById(Long id) {
        return workoutRepository.findById(id);
    }

    public Iterable<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public void save(Workout workout) {
        workoutRepository.save(workout);
    }
}
