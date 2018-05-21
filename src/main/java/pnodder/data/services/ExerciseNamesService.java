package pnodder.data.services;

import pnodder.data.domain.ExerciseNames;
import pnodder.data.repositories.ExerciseNamesRepository;

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
