package system.management.library.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 2021-07-20.
 */
@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private LoginService loginService;


    /**
     * Servlet needs it
     */
    public LoginServlet(){
        this(new LoginService());
    }

    private LoginServlet(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(LOGIN_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);
        response.getWriter().write(loginService.loginReturnValue(login, password));
    }
}
