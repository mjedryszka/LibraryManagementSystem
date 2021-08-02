package system.management.library.database;

import java.util.List;
import java.util.Optional;

/**
 * Created by Home on 2021-08-02.
 */
public interface Dao<T> {
    Optional<T> get(String login);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
