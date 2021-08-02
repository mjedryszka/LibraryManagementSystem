package system.management.library.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Home on 2021-08-02.
 */
@Entity
@DiscriminatorValue("employee")
public class Employee extends User {
    @Override
    public String toString() {
        return "employee";
    }

    public Employee() {
    }

    public Employee(String login, String password) {
        super(login, password);
    }
}
