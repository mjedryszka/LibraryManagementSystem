package system.management.library.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Home on 2021-08-02.
 */
@Entity
@DiscriminatorValue("employee")
public class EmployeeUser extends User {

    public EmployeeUser() {
    }

    public EmployeeUser(String login, String password) {
        super(login, password);
    }

    @Override
    public String toString() {
        return Position.EMPLOYEE.toString();
    }
}
