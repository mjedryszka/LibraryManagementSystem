package system.management.library.account.edite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 2021-08-05.
 */
@WebServlet(name = "changePassword", urlPatterns = "/editaccount/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    private final static String LOGIN_PARAM = "login";
    private final static String NEW_PASSWORD_PARAM = "newPassword";
    ChangePasswordService changePasswordService;

    public ChangePasswordServlet() {
        this(new ChangePasswordService());
    }

    private ChangePasswordServlet(ChangePasswordService changePasswordService) {
        this.changePasswordService = changePasswordService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String newPassword = req.getParameter(NEW_PASSWORD_PARAM);
        resp.getWriter().write(changePasswordService.changeLogin(login, newPassword));
    }
}
