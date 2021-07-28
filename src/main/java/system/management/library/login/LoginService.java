package system.management.library.login;


import system.management.library.User;

/**
 * Created by Home on 2021-07-21.
 */
class LoginService {
    private final static String LOGIN_OR_PASSWORD_IS_TOO_SHORT = "Login or password is too short";
    private final static String LOGIN_OR_PASSWORD_IS_NOT_CORRECT = "Login or password is not correct";
    private static final String LOGIN_SUCCESS = "Ok";
    private LoginRepository loginRepository;
    private User user;

    protected LoginService() {
        this(new LoginRepository());
    }

    protected LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    protected String loginReturnValue(String login, String password) {
        if (isLoginAndPasswordContainMinThreeChar(login, password)) {
            getUser(login);
            if (isUserExist() && confirmPassword(password)) {
                return LOGIN_SUCCESS;
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
        user = loginRepository.getUserFromDB(login).orElse(null);
    }

    private boolean isUserExist() {
        return user != null;
    }

    private boolean confirmPassword(String password) {
        return user.getPassword().equals(password);
    }
}
