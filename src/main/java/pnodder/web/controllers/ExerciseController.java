package pnodder.web.controllers;

import pnodder.domain.Exercise;
import pnodder.services.ExerciseService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exercises")
@Produces(MediaType.APPLICATION_JSON)
public class ExerciseController {

    @Inject
    private ExerciseService exerciseService;

    @GET
    public Iterable<Exercise> findAllExercises() {
        return exerciseService.findAll();
    }
}
