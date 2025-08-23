package Login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Logincookie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("phuc".equals(user) && "123".equals(pass)) {
            // tạo cookie lưu username
            Cookie cookie = new Cookie("username", user);
            cookie.setMaxAge(30); // tồn tại 30s
            resp.addCookie(cookie);

            // chuyển sang hello
            resp.sendRedirect(req.getContextPath() + "/hello");
        } else {
            // quay lại login nếu sai
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
}
