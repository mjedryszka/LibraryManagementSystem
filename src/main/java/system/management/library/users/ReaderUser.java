package system.management.library.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Home on 2021-08-02.
 */
@Entity
@DiscriminatorValue("reader")
public class ReaderUser extends User {

    public ReaderUser() {
    }

    public ReaderUser(String login, String password) {
        super(login, password);
    }

    @Override
    public String toString() {
        return Position.READER.toString();
    }
}
