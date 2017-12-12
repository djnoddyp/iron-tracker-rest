package pnodder.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pnodder.data.domain.ExerciseNames;

public interface ExerciseNamesRepository extends CrudRepository<ExerciseNames, Long> {
}
