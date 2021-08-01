package system.management.library.account.create;

import java.util.List;

/**
 * Created by Home on 2021-07-26.
 */
class CompareLogins {
    private CreateAccountRepository createAccountRepository;
    private List<String> loginsList;

    protected CompareLogins() {
        this(new CreateAccountRepository());
    }

    protected CompareLogins(CreateAccountRepository createAccountRepository) {
        this.createAccountRepository = createAccountRepository;
    }

    protected boolean isLoginUnused(String login) {
        getLoginsList();
        if (loginsList == null) {
            return true;
        }
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
