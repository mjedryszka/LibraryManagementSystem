package system.management.library.account.create;

import system.management.library.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Home on 2021-07-23.
 */
class CreateAccountRepository {
    private final static String GET_ALL_LOGINS_QUERY = "SELECT l.login FROM User l";

    protected List<String> getAllUsersLoginsList() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        List<String> logins;
        try {
            entityManager.getTransaction().begin();
            logins = entityManager.createQuery(GET_ALL_LOGINS_QUERY).getResultList();
            entityManager.getTransaction().commit();
        } catch (NoResultException exc) {
            logins = null;
        } finally {
            HibernateUtil.closeEntityManager();
        }
        return logins;
    }
}
