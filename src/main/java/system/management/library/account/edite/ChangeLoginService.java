package system.management.library.account.edite;

import system.management.library.database.UserDao;
import system.management.library.users.User;

/**
 * Created by Home on 2021-08-05.
 */
class ChangeLoginService {
    private static final String LOGIN_TO_SHORT = "New login to short";
    private static final String ACCOUNT_NOT_EXIST = "Account not exist";
    private static final String NEW_LOGIN_EXIST = "New login is occupied";
    private static final String LOGIN_CHANGED = "Login changed";
    private String changeLoginStatus;
    private UserDao userDao;
    private User user;

    protected ChangeLoginService(){
        this(new UserDao());
    }

    protected ChangeLoginService(UserDao userDao){
        this.userDao = userDao;
    }

    protected String changeLogin(String login,String newLogin){
        changeLoginStatus=null;
        checkIfNewLoginHasThreeChar(login,newLogin);
        checkIfAccountExist(login);
        checkIfNewLoginIsNotOccupied(newLogin);
        updateLoginInDB(newLogin);
        return changeLoginStatus;
    }
    private void checkIfNewLoginHasThreeChar(String login,String newLogin){
        if (login.length() < 3 || newLogin.length()<3 ){
            changeLoginStatus = LOGIN_TO_SHORT;
        }
    }
    private void checkIfAccountExist(String login){
        if (changeLoginStatus == null) {
            user = userDao.get(login);
            if (user == null) {
                changeLoginStatus = ACCOUNT_NOT_EXIST;
            }
        }
    }
    private void checkIfNewLoginIsNotOccupied(String newLogin){
        if (changeLoginStatus == null) {
            User newLoginUser = userDao.get(newLogin);
            if (newLoginUser != null) {
                changeLoginStatus = NEW_LOGIN_EXIST;
            }
        }
    }
    private void updateLoginInDB(String newLogin){
        if (changeLoginStatus == null) {
            userDao.updateLogin(user, newLogin);
            changeLoginStatus = LOGIN_CHANGED;
        }
    }

}
