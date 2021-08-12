package system.management.library.login;

import org.junit.Test;
import system.management.library.database.UserDao;
import system.management.library.users.AdminUser;
import system.management.library.users.EmployeeUser;
import system.management.library.users.ReaderUser;
import system.management.library.users.User;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Home on 2021-07-28.
 */
public class LoginServiceTest {
    private static final String LOGIN_OR_PASSWORD_IS_TOO_SHORT = "Login or password is too short";
    private static final String LOGIN_OR_PASSWORD_IS_NOT_CORRECT = "Login or password is not correct";

    @Test
    public void test_loginReturnValue_returnLoginToShort() {
        //given
        String login = "Bo";
        String password = "123";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(user());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(LOGIN_OR_PASSWORD_IS_TOO_SHORT, result);
    }

    @Test
    public void test_loginReturnValue_returnPasswordToShort() {
        //given
        String login = "Bor";
        String password = "12";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(user());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(LOGIN_OR_PASSWORD_IS_TOO_SHORT, result);
    }

    @Test
    public void test_loginReturnValue_returnLoginAndPassToShort() {
        //given
        String login = "Bo";
        String password = "12";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(user());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(LOGIN_OR_PASSWORD_IS_TOO_SHORT, result);
    }

    @Test
    public void test_loginReturnValue_returnLoginNotExist() {
        //given
        String login = "Bor";
        String password = "123";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(null);
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(LOGIN_OR_PASSWORD_IS_NOT_CORRECT, result);
    }

    @Test
    public void test_loginReturnValue_returnPasswordNotExist() {
        //given
        String login = "Bor";
        String password = "1234";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(user());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(LOGIN_OR_PASSWORD_IS_NOT_CORRECT, result);
    }

    @Test
    public void test_loginReturnValue_returnReader() {
        //given
        String login = "Bor";
        String password = "123";
        String loginSuccess = "READER";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(userReader());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(loginSuccess, result);
    }

    @Test
    public void test_loginReturnValue_returnEmployee() {
        //given
        String login = "Bor";
        String password = "123";
        String loginSuccess = "EMPLOYEE";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(userEmployee());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(loginSuccess, result);
    }

    @Test
    public void test_loginReturnValue_returnAdmin() {
        //given
        String login = "Bor";
        String password = "123";
        String loginSuccess = "ADMIN";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(userAdmin());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(loginSuccess, result);
    }

    private User user() {
        String login = "bor";
        String password = "123";
        return new User(login, password);
    }

    private User userReader() {
        String login = "bor";
        String password = "123";
        return new ReaderUser(login, password);
    }

    private User userEmployee() {
        String login = "bor";
        String password = "123";
        return new EmployeeUser(login, password);
    }

    private User userAdmin() {
        String login = "bor";
        String password = "123";
        return new AdminUser(login, password);
    }

}
