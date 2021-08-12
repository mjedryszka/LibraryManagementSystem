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
@WebServlet(name = "changeLogin", urlPatterns = "/editaccount/changelogin")
public class ChangeLoginServlet extends HttpServlet {
    private static final String LOGIN_PARAM = "login";
    private static final String NEW_LOGIN_PARAM = "newLogin";
    private ChangeLoginService changeLoginService;

    public ChangeLoginServlet(){
        this(new ChangeLoginService());
    }
    private ChangeLoginServlet(ChangeLoginService changeLoginService){
        this.changeLoginService = changeLoginService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String newLogin = req.getParameter(NEW_LOGIN_PARAM);
        resp.getWriter().write(changeLoginService.changeLogin(login, newLogin));
    }
}
