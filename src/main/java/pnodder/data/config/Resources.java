package pnodder.data.config;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@SessionScoped
public class Resources implements Serializable {
    
    @Produces
    @PersistenceContext
    EntityManager em;
    
}
