package pnodder.services;

import pnodder.domain.ExerciseNames;
import pnodder.repositories.ExerciseNamesRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ExerciseNamesService {

    @Inject
    private ExerciseNamesRepository repository;

    public Iterable<ExerciseNames> findAllExerciseNames() {
        return repository.findAll();
    }
}
