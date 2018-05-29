package pnodder.web.controllers;

import pnodder.data.domain.ExerciseNames;
import pnodder.data.domain.Workout;
import pnodder.data.services.ExerciseNamesService;
import pnodder.data.services.WorkoutService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class WorkoutController {

    @Inject
    private WorkoutService workoutService;
    
    @Inject
    private ExerciseNamesService exerciseNamesService;

    @GET
    @Path("/workout/{id}")
    public Workout findWorkoutById(@PathParam("id") long id) {
        return workoutService.findById(id);
    }
    
    @GET
    @Path("/workouts")
    public Iterable<Workout> findAllWorkouts() {
        return workoutService.findAll();
    }

    @POST
    @Path("/workouts")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveWorkout(Workout workout) {
        workoutService.save(workout);
        System.out.println("Workout saved");
    }

    @GET
    @Path("/exerciseNames")
    public Iterable<ExerciseNames> findAllExerciseNames() {
        return exerciseNamesService.findAllExerciseNames();
    }

}
