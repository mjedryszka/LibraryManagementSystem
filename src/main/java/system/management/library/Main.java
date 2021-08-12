package system.management.library;

import system.management.library.account.create.CreateNewUsersTest;

/**
 * Created by Home on 2021-07-22.
 */
public class Main {
    public static void main(String[] args) {
        CreateNewUsersTest createNewUsersTest = new CreateNewUsersTest();
        createNewUsersTest.createUsers();
    }
}
