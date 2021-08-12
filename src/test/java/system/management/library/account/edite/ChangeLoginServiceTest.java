package system.management.library.account.edite;

import org.junit.Assert;
import org.junit.Test;
import system.management.library.database.UserDao;
import system.management.library.users.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Home on 2021-08-05.
 */
public class ChangeLoginServiceTest {
    private static final String LOGIN_TO_SHORT = "New login to short";
    private static final String ACCOUNT_NOT_EXIST = "Account not exist";
    private static final String NEW_LOGIN_EXIST = "New login is occupied";
    private static final String LOGIN_CHANGED = "Login changed";

    UserDao userDao = mock(UserDao.class);
    ChangeLoginService SUT = new ChangeLoginService(userDao);

    @Test
    public void test_ChangeLogin_login_resultLoginToShort() throws Exception {
        //given
        String login = "Bo";
        String newLogin = "NewBorys";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        doNothing().when(userDao).updateLogin(new User(),newLogin);
        //when
        String result = SUT.changeLogin(login, newLogin);
        //then
        Assert.assertEquals(LOGIN_TO_SHORT,result);
    }
    @Test
    public void test_ChangeLogin_newLogin_resultLoginToShort() throws Exception {
        //given
        String login = "Borys";
        String newLogin = "Ne";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        doNothing().when(userDao).updateLogin(new User(),newLogin);
        //when
        String result = SUT.changeLogin(login, newLogin);
        //then
        Assert.assertEquals(LOGIN_TO_SHORT,result);
    }
    @Test
    public void test_ChangeLogin_wrongLogin_resultAccountNotExist() throws Exception {
        //given
        String login = "Bor";
        String newLogin = "NewBorys";
        when(userDao.get(login)).thenReturn(null);
        doNothing().when(userDao).updateLogin(new User(), newLogin);
        //when
        String result = SUT.changeLogin(login, newLogin);
        //then
        Assert.assertEquals(ACCOUNT_NOT_EXIST,result);
    }
    @Test
    public void test_ChangeLogin_resultNewLoginExist() throws Exception {
        //given
        String login = "Borys";
        String newLogin = "NewBorys";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        when(userDao.get(newLogin)).thenReturn(new User("NewBorys","123"));
        doNothing().when(userDao).updateLogin(new User(),newLogin);
        //when
        String result = SUT.changeLogin(login, newLogin);
        //then
        Assert.assertEquals(NEW_LOGIN_EXIST,result);
    }
    @Test
    public void test_ChangeLogin_resultLoginChanged() throws Exception {
        //given
        String login = "Borys";
        String newLogin = "NewBorysBorys";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        when(userDao.get(newLogin)).thenReturn(null);
        doNothing().when(userDao).updateLogin(new User(),newLogin);
        //when
        String result = SUT.changeLogin(login, newLogin);
        //then
        Assert.assertEquals(LOGIN_CHANGED,result);
    }
}