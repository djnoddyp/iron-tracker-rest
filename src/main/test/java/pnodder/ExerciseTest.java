package pnodder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import pnodder.config.Resources;
import pnodder.domain.Exercise;
import pnodder.repositories.ExerciseRepository;
import pnodder.services.ExerciseService;

import javax.inject.Inject;

@RunWith(Arquillian.class)
@Transactional
public class ExerciseTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(Exercise.class)
                .addClass(ExerciseService.class)
                .addClass(ExerciseRepository.class)
                .addClass(Resources.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(war.toString(true));
        return war;
    }
    
//    @PersistenceContext
//    EntityManager em;
    
    @Inject
    ExerciseService exerciseService;
    
    @Inject
    Logger logger;
    
    @Test
    public void testInsertExercises() {
        for (int i = 0; i < 5; i++) {
            exerciseService.save(new Exercise());
        }
        logger.info("Flush is triggered at commit-time");
    }
    
}
