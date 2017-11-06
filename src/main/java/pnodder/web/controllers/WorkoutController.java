package pnodder.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pnodder.data.entities.Workout;
import pnodder.data.services.WorkoutService;

@Controller
@CrossOrigin
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
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
    public void saveWorkout(@RequestBody Workout workout) {
        workoutService.save(workout);
        System.out.println("Workouts saved");
    }

}
