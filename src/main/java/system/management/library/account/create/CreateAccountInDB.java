package system.management.library.account.create;

import system.management.library.database.UserDao;
import system.management.library.users.ReaderUser;
import system.management.library.users.User;

/**
 * Created by Home on 2021-07-31.
 */
class CreateAccountInDB {
    private UserDao userDao;
    private User user;

    protected CreateAccountInDB(){
        this(new UserDao());
    }

    private CreateAccountInDB(UserDao userDao){
        this.userDao = userDao;
    }
    protected void createNewAccount(String login, String password) {
        user = new ReaderUser(login, password);
        userDao.save(user);
    }

}
