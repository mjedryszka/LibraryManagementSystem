package system.management.library.account.create;

import system.management.library.database.UserDao;
import system.management.library.users.User;

import java.util.List;

/**
 * Created by Home on 2021-07-26.
 */
class CompareLogins {
    private UserDao userDao;
    private List<User> users;

    protected CompareLogins() {
        this(new UserDao());
    }

    protected CompareLogins(UserDao userDao) {
        this.userDao = userDao;
    }

    protected boolean isLoginUnused(String login) {
        getLoginsList();
        if (users == null) {
            return true;
        }
        for (User user : users) {
            String loginFromDB = user.getLogin();
            if (login.equals(loginFromDB)) {
                return false;
            }
        }
        return true;
    }

    private void getLoginsList() {
        users = userDao.getAll();
    }
}
