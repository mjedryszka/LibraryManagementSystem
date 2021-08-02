package system.management.library.database;

import system.management.library.users.User;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by Home on 2021-08-02.
 */
public class UserDao implements Dao<User> {
    private EntityManager entityManager = HibernateUtil.getEntityManager();

    @Override
    public Optional<User> get(String login)
    {
        return Optional.ofNullable(entityManager.find(User.class,login));
    }

    @Override
    public List<User> getAll() {
        List<User> users;
        try {
            users = entityManager.createQuery("SELECT u FROM User u",User.class).getResultList();
        }catch (NoResultException exc){
            exc.printStackTrace();
            users = null;
        }
        return users;
    }

    @Override
    public void save(User user) {
        executeInsideTransaction(entityManager -> entityManager.persist(user));
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
        executeInsideTransaction(entityManager -> entityManager.remove(user));
    }
    private void executeInsideTransaction(Consumer<EntityManager> action){
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }catch (RuntimeException exc){
            tx.rollback();
            exc.printStackTrace();
        }
    }
}