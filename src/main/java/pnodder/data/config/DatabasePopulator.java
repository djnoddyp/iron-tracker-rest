package pnodder.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import pnodder.data.entities.Exercise;
import pnodder.data.entities.Workout;
import pnodder.data.repositories.ExerciseRepository;
import pnodder.data.repositories.WorkoutRepository;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.util.Calendar.*;
import static java.util.Calendar.DATE;

public class DatabasePopulator {

    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    private TransactionTemplate transactionTemplate;

    @Transactional
    public void init() {
        Exercise e1 = new Exercise("Dumbell bicep curls");
        Exercise e2 = new Exercise("Pull ups");
        Exercise e3 = new Exercise("Bench press");
        Exercise e4 = new Exercise("Push ups");

        transactionTemplate = new TransactionTemplate(transactionManager);

        System.out.println("Loading test data into Exercise table.");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                exerciseRepository.save(e1);
                exerciseRepository.save(e2);
                exerciseRepository.save(e3);
                exerciseRepository.save(e4);
            }
        });

        Set<Exercise> exerciseSet = new HashSet<>();
        exerciseSet.add(e1);
        exerciseSet.add(e4);

        Calendar calendar1 = new Calendar.Builder()
                .set(YEAR, 2017)
                .set(MONTH, OCTOBER)
                .set(DATE, 23)
                .build();
        Date date1 = calendar1.getTime();

        Workout w1 = new Workout(date1, exerciseSet);

        exerciseSet.clear();
        exerciseSet.add(e2);
        exerciseSet.add(e3);

        calendar1 = new Calendar.Builder()
                .set(YEAR, 2017)
                .set(MONTH, OCTOBER)
                .set(DATE, 24)
                .build();
        date1 = calendar1.getTime();

        Workout w2 = new Workout(date1, exerciseSet);

        System.out.println("Loading test data into Workout table.");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                workoutRepository.save(w1);
                workoutRepository.save(w2);
            }
        });
    }

}
