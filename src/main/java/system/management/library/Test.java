package system.management.library;

import system.management.library.login.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Home on 2021-07-22.
 */
public class Test {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabaseConnection");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityManager entityManager = HibernateUtil.getEntityManager();
//        User user = new User("Borys","123");
//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<User> results = entityManager.createQuery("SELECT u FROM User u WHERE u.login LIKE :BorysTest2",User.class).setParameter("BorysTest2","BorysTest2").getResultList();
        for (User user1 : results){
            System.out.println(user1.getLogin());
        }
        entityManager.getTransaction().commit();

    }
}
