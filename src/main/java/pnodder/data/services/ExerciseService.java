package pnodder.data.services;

import org.springframework.stereotype.Service;
import pnodder.data.domain.Exercise;
import pnodder.data.repositories.ExerciseRepository;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Iterable<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

}
