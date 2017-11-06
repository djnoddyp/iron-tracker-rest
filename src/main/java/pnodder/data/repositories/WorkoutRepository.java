package pnodder.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pnodder.data.entities.Workout;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

    // dummy repository

//    private Map<Long, Workout> workoutMap = new HashMap<>();
//
//    {
//        Exercise e1 = new Exercise("Dumbell bicep curls");
//        Exercise e2 = new Exercise("Pull ups");
//        Exercise e3 = new Exercise("Bench press");
//        Exercise e4 = new Exercise("Push ups");
//
//        LocalDate date1 = LocalDate.of(2017, 10, 21);
//        LocalDate date2 = LocalDate.of(2017, 10, 23);
//
//        Set<Exercise> exercises = new HashSet<>();
//        exercises.add(e1);
//        exercises.add(e2);
//        Workout w1 = new Workout(date1, exercises);
//
//        exercises.clear();
//        exercises.add(e1);
//        exercises.add(e4);
//        Workout w2 = new Workout(date1, exercises);
//
//        exercises.clear();
//        exercises.add(e2);
//        exercises.add(e3);
//        Workout w3 = new Workout(date2, exercises);
//
//        workoutMap.put(1L, w1);
//        workoutMap.put(2L, w2);
//        workoutMap.put(3L, w3);
//    }
//
//    public Workout findById(Long id) {
//        return workoutMap.get(id);
//    }
//
//    public List<Workout> findAll() {
//        List<Workout> workouts = workoutMap.entrySet().stream()
//                .map(w -> w.getValue())
//                .collect(Collectors.toList());
//        return workouts;
//    }

}
