package system.management.library.account.edite;

import system.management.library.database.UserDao;
import system.management.library.users.User;

/**
 * Created by Home on 2021-08-05.
 */
class ChangePasswordService {
    private static final String PASSWORD_TO_SHORT = "New password or login is to short";
    private static final String ACCOUNT_NOT_EXIST = "Account not exist";
    private static final String PASSWORD_CHANGED = "Password changed";
    private String changePasswordStatus;
    private UserDao userDao;
    private User user;

    protected ChangePasswordService() {
        this(new UserDao());
    }

    protected ChangePasswordService(UserDao userDao) {
        this.userDao = userDao;
    }

    protected String changeLogin(String login, String newPassword) {
        changePasswordStatus = null;
        checkIfNewLoginHasThreeChar(login, newPassword);
        checkIfAccountExist(login);
        updatePasswordInDB(newPassword);
        return changePasswordStatus;
    }

    private void checkIfNewLoginHasThreeChar(String login, String newPassword) {
        if (login.length() < 3 || newPassword.length() < 3) {
            changePasswordStatus = PASSWORD_TO_SHORT;
        }
    }

    private void checkIfAccountExist(String login) {
        if (changePasswordStatus == null) {
            user = userDao.get(login);
            if (user == null) {
                changePasswordStatus = ACCOUNT_NOT_EXIST;
            }
        }
    }

    private void updatePasswordInDB(String newPassword) {
        if (changePasswordStatus == null) {
            userDao.updatePassword(user, newPassword);
            changePasswordStatus = PASSWORD_CHANGED;
        }
    }

}
