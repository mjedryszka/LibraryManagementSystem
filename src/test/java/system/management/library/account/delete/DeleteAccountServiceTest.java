package system.management.library.account.delete;

import org.junit.Assert;
import org.junit.Test;
import system.management.library.database.UserDao;
import system.management.library.users.AdminUser;
import system.management.library.users.EmployeeUser;
import system.management.library.users.ReaderUser;
import system.management.library.users.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Home on 2021-08-04.
 */
public class DeleteAccountServiceTest {
    private static final String ACCOUNT_NOT_EXIST = "Account not exist";
    private static final String ACCOUNT_DELETED = "Account deleted";

    UserDao userDao = mock(UserDao.class);
    DeleteAccountService SUT = new DeleteAccountService(userDao);
    @Test
    public void test_DeleteAccount_user_resultAccountNotExist() throws Exception {
        //given
        String login = "Borys";
        when(userDao.get(login)).thenReturn(null);
        //when
        String result = SUT.deleteAccount(login);
        //then
        Assert.assertEquals(ACCOUNT_NOT_EXIST,result);
    }
    @Test
    public void test_DeleteAccount_user_resultAccountDeleted() throws Exception {
        //given
        String login = "Borys";
        when(userDao.get(login)).thenReturn(new User("Borys","123"));
        //when
        String result = SUT.deleteAccount(login);
        //then
        Assert.assertEquals(ACCOUNT_DELETED,result);
    }
    @Test
    public void test_DeleteAccount_readerUser_resultAccountDeleted() throws Exception {
        //given
        String login = "Borys";
        when(userDao.get(login)).thenReturn(new ReaderUser("Borys","123"));
        //when
        String result = SUT.deleteAccount(login);
        //then
        Assert.assertEquals(ACCOUNT_DELETED,result);
    }
    @Test
    public void test_DeleteAccount_employeeUser_resultAccountDeleted() throws Exception {
        //given
        String login = "Borys";
        when(userDao.get(login)).thenReturn(new EmployeeUser("Borys","123"));
        //when
        String result = SUT.deleteAccount(login);
        //then
        Assert.assertEquals(ACCOUNT_DELETED,result);
    }
    @Test
    public void test_DeleteAccount_adminUser_resultAccountDeleted() throws Exception {
        //given
        String login = "Borys";
        when(userDao.get(login)).thenReturn(new AdminUser("Borys","123"));
        //when
        String result = SUT.deleteAccount(login);
        //then
        Assert.assertEquals(ACCOUNT_DELETED,result);
    }
}