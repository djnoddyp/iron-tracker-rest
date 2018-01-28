package pnodder.data.services;

import org.springframework.stereotype.Service;
import pnodder.data.domain.ExerciseNames;
import pnodder.data.repositories.ExerciseNamesRepository;

@Service
public class ExerciseNamesService {

    private ExerciseNamesRepository repository;

    public ExerciseNamesService(ExerciseNamesRepository repository) {
        this.repository = repository;
    }

    public Iterable<ExerciseNames> findAllExerciseNames() {
        return repository.findAll();
    }
}
