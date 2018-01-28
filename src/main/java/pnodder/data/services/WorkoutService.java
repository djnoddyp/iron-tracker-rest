package pnodder.data.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pnodder.data.domain.Workout;
import pnodder.data.repositories.WorkoutRepository;

@Service
@Transactional
public class WorkoutService {

    private WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout findById(Long id) {
        return workoutRepository.findOne(id);
    }

    public Iterable<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public void save(Workout workout) {
        workoutRepository.save(workout);
    }
}
