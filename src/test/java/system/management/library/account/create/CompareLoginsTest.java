package system.management.library.account.create;

import org.junit.Assert;
import org.junit.Test;
import system.management.library.database.UserDao;
import system.management.library.users.User;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Home on 2021-07-29.
 */
public class CompareLoginsTest {
    @Test
    public void test_IsLoginUnused_null_returnFalse() throws Exception {
        //given
        String login = "Borys";
        UserDao userDao = mock(UserDao.class);
        CompareLogins SUT = new CompareLogins(userDao);
        when(userDao.getAll()).thenReturn(null);
        //when
        boolean result = SUT.isLoginUnused(login);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void test_IsLoginUnused_usedLogin_returnFalse() throws Exception {
        //given
        String login = "Borys";
        UserDao userDao = mock(UserDao.class);
        CompareLogins SUT = new CompareLogins(userDao);
        when(userDao.getAll()).thenReturn(usersList());
        //when
        boolean result = SUT.isLoginUnused(login);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void test_IsLoginUnused_unusedLogin_returnTrue() throws Exception {
        //given
        String login = "Tomek";
        UserDao userDao = mock(UserDao.class);
        CompareLogins SUT = new CompareLogins(userDao);
        when(userDao.getAll()).thenReturn(usersList());
        //when
        boolean result = SUT.isLoginUnused(login);
        //then
        Assert.assertTrue(result);
    }

    private List<User> usersList() {
        List<User> users = new ArrayList<>();
        String login = "Borys";
        String password = "123";
        users.add(new User(login,password));
        return users;
    }
}