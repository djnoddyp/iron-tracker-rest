package pnodder.services;

import pnodder.domain.Exercise;
import pnodder.repositories.ExerciseRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ExerciseService {

    @Inject
    private ExerciseRepository exerciseRepository;

    public Iterable<Exercise> findAll() {
        return exerciseRepository.findAll();
    }
    
    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

}
