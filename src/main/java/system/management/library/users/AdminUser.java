package system.management.library.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Home on 2021-08-02.
 */
@Entity
@DiscriminatorValue("admin")
public class AdminUser extends User {
    @Override
    public String toString() {
        return "admin";
    }

    public AdminUser() {
    }

    public AdminUser(String login, String password) {
        super(login, password);
    }
}
