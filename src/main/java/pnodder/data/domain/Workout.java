package pnodder.data.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Set;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(
                name = "Workout.findAll",
                query = "SELECT w FROM Workout w"
        ),
        @NamedQuery(
                name = "Workout.findById",
                query = "SELECT w FROM Workout w WHERE w.id = :id"
        ),
})
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Workout_Exercise",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Exercise> exercises;

    public Workout() {
    }

    public Workout(Date date, Set<Exercise> exercises) {
        this.date = date;
        this.exercises = exercises;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
