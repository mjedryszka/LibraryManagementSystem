package system.management.library.database;

import java.util.List;
import java.util.Optional;

/**
 * Created by Home on 2021-08-02.
 */
public interface DaoUser<T> {
    T get(String login);

    List<T> getAll();

    void save(T t);

    void updateLogin(T t, String changeParam);

    void updatePassword(T t, String changeParam);

    void delete(T t);
}
