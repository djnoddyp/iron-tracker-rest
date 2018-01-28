package pnodder.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pnodder.data.domain.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
