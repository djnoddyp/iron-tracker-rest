package pnodder.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pnodder.data.domain.ExerciseNames;
import pnodder.data.domain.Workout;
import pnodder.data.services.WorkoutService;

@Controller
@CrossOrigin
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

//    @GetMapping("/workout/{id}")
//    @ResponseBody
//    public Workout findWorkoutById(@PathVariable long id) {
//        return workoutService.findById(id);
//    }

    @GetMapping("/workouts")
    @ResponseBody
    public void findAllWorkouts() {
        for (Workout w : workoutService.findAll()) {
            System.out.println(w.getDate().toString());       
        }
    }

//    @PostMapping(value = "/workouts", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveWorkout(@RequestBody Workout workout) {
//        workoutService.save(workout);
//        System.out.println("Workout saved");
//    }

//    @GetMapping("/exerciseNames")
//    @ResponseBody
//    public Iterable<ExerciseNames> findAllExerciseNames() {
//        return exerciseNamesService.findAllExerciseNames();
//    }

}
