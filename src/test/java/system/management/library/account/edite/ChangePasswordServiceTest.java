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
public class ChangePasswordServiceTest {
    private static final String PASSWORD_TO_SHORT = "New password or login is to short";
    private static final String ACCOUNT_NOT_EXIST = "Account not exist";
    private static final String PASSWORD_CHANGED = "Password changed";

    UserDao userDao = mock(UserDao.class);
    ChangePasswordService SUT = new ChangePasswordService(userDao);

    @Test
    public void test_ChangeLogin_resultLoginToShort() throws Exception {
        //given
        String login = "Bo";
        String newPassword = "123";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        doNothing().when(userDao).updatePassword(new User(),newPassword);
        //when
        String result = SUT.changeLogin(login, newPassword);
        //then
        Assert.assertEquals(PASSWORD_TO_SHORT,result);
    }
    @Test
    public void test_ChangeLogin_resultPasswordToShort() throws Exception {
        //given
        String login = "Borys";
        String newPassword = "12";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        doNothing().when(userDao).updatePassword(new User(),newPassword);
        //when
        String result = SUT.changeLogin(login, newPassword);
        //then
        Assert.assertEquals(PASSWORD_TO_SHORT,result);
    }
    @Test
    public void test_ChangeLogin_resultAccountNotExist() throws Exception {
        //given
        String login = "Borys";
        String newPassword = "123";
        when(userDao.get(login)).thenReturn(null);
        doNothing().when(userDao).updatePassword(new User(), newPassword);
        //when
        String result = SUT.changeLogin(login, newPassword);
        //then
        Assert.assertEquals(ACCOUNT_NOT_EXIST,result);
    }
    @Test
    public void test_ChangeLogin__resultAccountNotExist() throws Exception {
        //given
        String login = "Borys";
        String newPassword = "123";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        doNothing().when(userDao).updatePassword(new User(),newPassword);
        //when
        String result = SUT.changeLogin(login, newPassword);
        //then
        Assert.assertEquals(PASSWORD_CHANGED,result);
    }
}