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
import org.slf4j.LoggerFactory;
import pnodder.data.config.Resources;
import pnodder.data.domain.Exercise;
import pnodder.data.repositories.ExerciseRepository;
import pnodder.data.services.ExerciseService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(Arquillian.class)
@Transactional
public class ExerciseTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(Exercise.class)
                .addClass(ExerciseService.class)
                .addClass(ExerciseRepository.class)
                .addClass(Resources.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
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
