package system.management.library.account.create;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 2021-07-23.
 */
@WebServlet(name = "createAccountServlet", urlPatterns = "/createaccount")
public class CreateAccountServlet extends HttpServlet {
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String REPEAT_PASSWORD_PARAM = "repeatPassword";
    private CreateAccountService createAccountService;

    public CreateAccountServlet(){
        this(new CreateAccountService());
    }

    private CreateAccountServlet(CreateAccountService createAccountService){
        this.createAccountService = createAccountService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        String repeatPassword = req.getParameter(REPEAT_PASSWORD_PARAM);
        resp.getWriter().write(createAccountService.createAccountReturnValue(login,password,repeatPassword));
    }
}
