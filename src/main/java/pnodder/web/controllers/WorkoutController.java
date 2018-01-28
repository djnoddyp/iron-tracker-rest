package pnodder.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pnodder.data.domain.ExerciseNames;
import pnodder.data.domain.Workout;
import pnodder.data.services.ExerciseNamesService;
import pnodder.data.services.WorkoutService;

@Controller
@CrossOrigin
public class WorkoutController {

    private WorkoutService workoutService;
    private ExerciseNamesService exerciseNamesService;

    public WorkoutController(WorkoutService workoutService, ExerciseNamesService exerciseNamesService) {
        this.workoutService = workoutService;
        this.exerciseNamesService = exerciseNamesService;
    }

    @GetMapping("/workout/{id}")
    @ResponseBody
    public Workout findWorkoutById(@PathVariable long id) {
        return workoutService.findById(id);
    }

    @GetMapping("/workouts")
    @ResponseBody
    public Iterable<Workout> findAllWorkouts() {
        return workoutService.findAll();
    }

    @PostMapping(value = "/workouts", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveWorkout(@RequestBody Workout workout) {
        workoutService.save(workout);
        System.out.println("Workout saved");
    }

    @GetMapping("/exerciseNames")
    @ResponseBody
    public Iterable<ExerciseNames> findAllExerciseNames() {
        return exerciseNamesService.findAllExerciseNames();
    }

}
