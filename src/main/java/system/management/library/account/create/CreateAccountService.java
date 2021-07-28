package system.management.library.account.create;

import system.management.library.HibernateUtil;
import system.management.library.User;

import javax.persistence.EntityManager;

/**
 * Created by Home on 2021-07-23.
 */
public class CreateAccountService {
    private static final String LOGIN_PASSWORD_TO_SHORT = "Login and password must have min 3 signs";
    private static final String PASSWORD_NOT_EQUAL_REPEATED_PASSWORD = "Password and repeated password are not the same";
    private static final String LOGIN_EXIST = "Login already exist";
    private static final String ACCOUNT_CREATED = "Ok";
    private String accountStatus = null;

    public String createAccountReturnValue(String login, String password, String repeatPassword) {
        checkIfLoginAndPasswordContainMinThreeChar(login, password);
        checkIfPasswordEqualRepeatedPassword(password, repeatPassword);
        checkIfLoginIsUnused(login);
        createAccount(login, password);
        return accountStatus;
    }

    private void checkIfLoginAndPasswordContainMinThreeChar(String login, String password) {
        if (login.length() < 3 || password.length() < 3) {
            accountStatus = LOGIN_PASSWORD_TO_SHORT;
        }
    }

    private void checkIfPasswordEqualRepeatedPassword(String password, String repeatedPassword) {
        if (accountStatus == null) {
            if (!password.equals(repeatedPassword)) {
                accountStatus = PASSWORD_NOT_EQUAL_REPEATED_PASSWORD;
            }
        }
    }

    private void checkIfLoginIsUnused(String login) {
        if (accountStatus == null) {
            CompareLogins compareLogins = new CompareLogins();
            boolean isLoginUnused = compareLogins.isLoginUnused(login);
            if (!isLoginUnused) {
                accountStatus = LOGIN_EXIST;
            }
        }
    }

    private void createAccount(String login, String password) {
        if (accountStatus == null) {
            User user = new User(login, password);
            EntityManager entityManager = HibernateUtil.getEntityManager();
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(user);
                entityManager.getTransaction().commit();
                accountStatus = ACCOUNT_CREATED;
            } finally {
                HibernateUtil.closeEntityManager();
            }
        }
    }
}