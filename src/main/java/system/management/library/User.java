package system.management.library;

import javax.persistence.*;

/**
 * Created by Home on 2021-07-21.
 */
@Entity
@Table(schema = "managementlibrarysystemdb", name = "User")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;

    public User(){

    }
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
