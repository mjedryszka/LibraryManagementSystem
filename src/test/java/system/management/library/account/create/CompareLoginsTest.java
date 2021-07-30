package system.management.library.account.create;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
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
        CreateAccountRepository createAccountRepository = mock(CreateAccountRepository.class);
        CompareLogins SUT = new CompareLogins(createAccountRepository);
        when(createAccountRepository.getAllUsersLoginsList()).thenReturn(null);
        //when
        boolean result = SUT.isLoginUnused(login);
        //then
        Assert.assertTrue(result);
    }
    @Test
    public void test_IsLoginUnused_usedLogin_returnFalse() throws Exception {
        //given
        String login = "Borys";
        CreateAccountRepository createAccountRepository = mock(CreateAccountRepository.class);
        CompareLogins SUT = new CompareLogins(createAccountRepository);
        when(createAccountRepository.getAllUsersLoginsList()).thenReturn(loginsList());
        //when
        boolean result = SUT.isLoginUnused(login);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void test_IsLoginUnused_unusedLogin_returnTrue() throws Exception {
        //given
        String login = "Tomek";
        CreateAccountRepository createAccountRepository = mock(CreateAccountRepository.class);
        CompareLogins SUT = new CompareLogins(createAccountRepository);
        when(createAccountRepository.getAllUsersLoginsList()).thenReturn(loginsList());
        //when
        boolean result = SUT.isLoginUnused(login);
        //then
        Assert.assertTrue(result);
    }
    private List<String> loginsList(){
        List<String> logins = new ArrayList<String>();
        logins.add("Borys");
        return logins;
    }
}