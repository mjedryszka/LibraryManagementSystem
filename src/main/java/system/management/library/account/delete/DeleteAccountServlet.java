package system.management.library.account.delete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 2021-08-04.
 */
@WebServlet(name = "deleteServlet", urlPatterns = "/deleteaccount")
public class DeleteAccountServlet extends HttpServlet {
    private static final String LOGIN_PARAM = "login";
    private DeleteAccountService deleteAccountService;


    public DeleteAccountServlet() {
        this(new DeleteAccountService());
    }

    private DeleteAccountServlet(DeleteAccountService deleteAccountService) {
        this.deleteAccountService = deleteAccountService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        resp.getWriter().write(deleteAccountService.deleteAccount(login));
    }
}
