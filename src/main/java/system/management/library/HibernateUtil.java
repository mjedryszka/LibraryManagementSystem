package system.management.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Home on 2021-07-22.
 */
public class HibernateUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("myDatabaseConnection");
    private static EntityManager entityManager = null;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    private HibernateUtil() {
    }
}
