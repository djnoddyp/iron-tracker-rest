package pnodder.observers;

import pnodder.domain.Workout;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.ObservesAsync;

@RequestScoped
public class WorkoutObserver {
    
    public void onWorkoutNotification(@ObservesAsync Workout workout) {
        System.out.println("got workout: " + workout.getId());
    }
    
}
