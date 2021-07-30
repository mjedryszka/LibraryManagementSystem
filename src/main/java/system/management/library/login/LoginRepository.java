package system.management.library.login;


import system.management.library.HibernateUtil;
import system.management.library.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

/**
 * Created by Home on 2021-07-21.
 */
class LoginRepository {
    private static final String GET_USER_QUERY = "SELECT u FROM User u WHERE u.login LIKE :login";
    private EntityManager entityManager;
    private User user;

    protected LoginRepository(){
        this.entityManager = HibernateUtil.getEntityManager();
    }

    protected Optional<User> getUserFromDB(String login) {
        try {
            entityManager.getTransaction().begin();
            user = entityManager.createQuery(GET_USER_QUERY, User.class)
                    .setParameter("login", login)
                    .getSingleResult();
            entityManager.getTransaction().commit();
        } catch (NoResultException exc) {
            user = null;
        } finally {
            HibernateUtil.closeEntityManager();
        }
        return Optional.ofNullable(user);
    }
}
