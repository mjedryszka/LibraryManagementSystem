package system.management.library.login;


import system.management.library.database.UserDao;
import system.management.library.users.User;

/**
 * Created by Home on 2021-07-21.
 */
class LoginService {
    private static final String LOGIN_OR_PASSWORD_IS_TOO_SHORT = "Login or password is too short";
    private static final String LOGIN_OR_PASSWORD_IS_NOT_CORRECT = "Login or password is not correct";
    private String loginSuccess;
    private UserDao userDao;
    private User user = null;
    

    protected LoginService() {
        this(new UserDao());
    }

    protected LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    protected String loginReturnValue(String login, String password) {
        if (isLoginAndPasswordContainMinThreeChar(login, password)) {
            getUser(login);
            if (isUserExist() && confirmPassword(password)) {
                loginSuccess = user.toString();
                return loginSuccess;
            }
            return LOGIN_OR_PASSWORD_IS_NOT_CORRECT;
        }
        return LOGIN_OR_PASSWORD_IS_TOO_SHORT;
    }

    private boolean isLoginAndPasswordContainMinThreeChar(String login, String password) {
        int loginLength = login.length();
        int passwordLength = password.length();
        return loginLength >= 3 && passwordLength >= 3;
    }

    private void getUser(String login) {
        user = userDao.get(login);
    }

    private boolean isUserExist() {
        return user != null;
    }

    private boolean confirmPassword(String password) {
        return user.getPassword().equals(password);
    }
}
