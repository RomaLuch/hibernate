package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManagerFactoryUtil {

   private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
