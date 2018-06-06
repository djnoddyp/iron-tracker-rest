package pnodder.data.services;

import pnodder.data.domain.Exercise;
import pnodder.data.repositories.ExerciseRepository;

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
