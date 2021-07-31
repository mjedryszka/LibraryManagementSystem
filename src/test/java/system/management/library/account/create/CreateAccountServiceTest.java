package system.management.library.account.create;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Home on 2021-07-31.
 */
public class CreateAccountServiceTest {
    private static final String LOGIN_PASSWORD_TO_SHORT = "Login and password must have min 3 signs";
    private static final String PASSWORD_NOT_EQUAL_REPEATED_PASSWORD = "Password and repeated password are not the same";
    private static final String LOGIN_EXIST = "Login already exist";
    private static final String ACCOUNT_CREATED = "Ok";

    CompareLogins compareLogins = mock(CompareLogins.class);
    CreateAccountInDB createAccountInDB = mock(CreateAccountInDB.class);
    CreateAccountService SUT = new CreateAccountService(compareLogins, createAccountInDB);

    @Test
    public void test_createAccountReturnValue_login_resultLoginToShort() {
        //given
        String login = "Bo";
        String password = "123";
        String repeatedPassword = "123";
        when(compareLogins.isLoginUnused(login)).thenReturn(true);
        doNothing().when(createAccountInDB).createNewAccount(login, password);
        //when
        String result = SUT.createAccountReturnValue(login, password, repeatedPassword);
        //then
        Assert.assertEquals(LOGIN_PASSWORD_TO_SHORT, result);
    }

    @Test
    public void test_createAccountReturnValue_password_resultPasswordToShort() {
        //given
        String login = "Bor";
        String password = "12";
        String repeatedPassword = "123";
        when(compareLogins.isLoginUnused(login)).thenReturn(true);
        doNothing().when(createAccountInDB).createNewAccount(login, password);
        //when
        String result = SUT.createAccountReturnValue(login, password, repeatedPassword);
        //then
        Assert.assertEquals(LOGIN_PASSWORD_TO_SHORT, result);
    }

    @Test
    public void test_createAccountReturnValue_loginAndPassword_resultLoginAndPasswordEmpty() {
        //given
        String login = "";
        String password = "";
        String repeatedPassword = "123";
        when(compareLogins.isLoginUnused(login)).thenReturn(true);
        doNothing().when(createAccountInDB).createNewAccount(login, password);
        //when
        String result = SUT.createAccountReturnValue(login, password, repeatedPassword);
        //then
        Assert.assertEquals(LOGIN_PASSWORD_TO_SHORT, result);
    }

    @Test
    public void test_createAccountReturnValue_repeatedPassword_resultPasswordAndRepeatedPasswordAreNotTheSame() {
        //given
        String login = "Bor";
        String password = "123";
        String repeatedPassword = "12";
        when(compareLogins.isLoginUnused(login)).thenReturn(true);
        doNothing().when(createAccountInDB).createNewAccount(login, password);
        //when
        String result = SUT.createAccountReturnValue(login, password, repeatedPassword);
        //then
        Assert.assertEquals(PASSWORD_NOT_EQUAL_REPEATED_PASSWORD, result);
    }

    @Test
    public void test_createAccountReturnValue_login_resultExist() {
        //given
        String login = "Bor";
        String password = "123";
        String repeatedPassword = "123";
        when(compareLogins.isLoginUnused(login)).thenReturn(false);
        doNothing().when(createAccountInDB).createNewAccount(login, password);
        //when
        String result = SUT.createAccountReturnValue(login, password, repeatedPassword);
        //then
        Assert.assertEquals(LOGIN_EXIST, result);
    }

    @Test
    public void test_createAccountReturnValue_everythingOK_resultAccountCreated() {
        //given
        String login = "Bor";
        String password = "123";
        String repeatedPassword = "123";
        when(compareLogins.isLoginUnused(login)).thenReturn(true);
        doNothing().when(createAccountInDB).createNewAccount(login, password);
        //when
        String result = SUT.createAccountReturnValue(login, password, repeatedPassword);
        //then
        Assert.assertEquals(ACCOUNT_CREATED, result);
    }
}