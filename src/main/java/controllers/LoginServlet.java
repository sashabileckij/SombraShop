package controllers;

import dao.UserDaoImpl;
import models.User;
import views.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет призначений для авторизації
 * Його функціонал: авторизація
 */

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("inputLogin");
        String password = request.getParameter("inputPassword");
        HttpSession session = request.getSession();
        UserDaoImpl userDao = new UserDaoImpl();

        User user = userDao.findUserByLoginPassword(login, password);    //Пошук користувача за логіном і паролем

        if ((user != null && user.getRole().equals("1")) || (user != null && user.getLogin().equals("admin"))) {
            session.setAttribute("user", user);                       //Якщо користувач не заблочений то входим в систему
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");                          //Якщо користувач заблочений то повертаємся назад на сторінку входу
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        indexView.outLogin(out);                                         //Вивід сторінки авторизації
    }
}
