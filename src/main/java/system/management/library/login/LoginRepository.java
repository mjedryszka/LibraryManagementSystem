package system.management.library.login;


import system.management.library.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Created by Home on 2021-07-21.
 */
public class LoginRepository {

    protected User getUserFromDB(String login) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.login LIKE :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
        System.out.println(user.getId());
        return user;
    }
}
