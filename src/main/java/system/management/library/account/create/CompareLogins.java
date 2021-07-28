package system.management.library.account.create;

import java.util.List;

/**
 * Created by Home on 2021-07-26.
 */
class CompareLogins {
    private CreateAccountRepository createAccountRepository;
    private List<String> loginsList;

    protected CompareLogins() {
        createAccountRepository = new CreateAccountRepository();
    }

    protected boolean isLoginUnused(String login) {
        getLoginsList();
        for (String loginFromDB : loginsList) {
            if (login.equals(loginFromDB)) {
                return false;
            }
        }
        return true;
    }

    private void getLoginsList() {
        loginsList = createAccountRepository.getAllUsersLoginsList();
    }
}
