package system.management.library.account.create;

import system.management.library.HibernateUtil;
import system.management.library.User;

import javax.persistence.EntityManager;

/**
 * Created by Home on 2021-07-31.
 */
class CreateAccountInDB {
    private User user;

    protected void createNewAccount(String login, String password) {
        user = new User(login, password);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } finally {
            HibernateUtil.closeEntityManager();
        }
    }

}
