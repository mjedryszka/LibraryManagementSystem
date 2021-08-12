package system.management.library.account.delete;

import system.management.library.database.UserDao;
import system.management.library.users.User;

/**
 * Created by Home on 2021-08-04.
 */
class DeleteAccountService {
    private static final String ACCOUNT_NOT_EXIST = "Account not exist";
    private static final String ACCOUNT_DELETED = "Account deleted";
    private UserDao userDao;

    protected DeleteAccountService(){
        this(new UserDao());
    }

    protected DeleteAccountService(UserDao userDao){
        this.userDao = userDao;
    }

    protected String deleteAccount(String login) {
        User user = userDao.get(login);
        if (user != null) {
            userDao.delete(user);
            return ACCOUNT_DELETED;
        } else {
            return ACCOUNT_NOT_EXIST;
        }
    }
}
