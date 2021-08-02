package system.management.library.login;

import org.junit.Test;
import system.management.library.database.UserDao;
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
    private static final String LOGIN_SUCCESS = "Ok";

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
        when(userDao.get(login)).thenReturn(Optional.<User>empty());
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
    public void test_loginReturnValue_returnLoginSuccess() {
        //given
        String login = "Bor";
        String password = "123";
        UserDao userDao = mock(UserDao.class);
        LoginService SUT = new LoginService(userDao);
        when(userDao.get(login)).thenReturn(user());
        //when
        String result = SUT.loginReturnValue(login, password);
        //then
        assertEquals(LOGIN_SUCCESS, result);
    }

    private Optional<User> user() {
        String login = "bor";
        String password = "123";
        User user = new User(login, password);
        return Optional.ofNullable(user);
    }

}
