package pnodder.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pnodder.data.entities.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
