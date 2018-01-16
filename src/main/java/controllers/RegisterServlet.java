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
 * Сервлет призначений для реєстрації користувача та автоматичного входу при успішній реєстрації
 */

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        UserDaoImpl userDao = new UserDaoImpl();

        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String pwd_again = request.getParameter("pwd_again");
        String number = request.getParameter("number");

        User user = userDao.findUserByEmail(email);                     //Якщо введений email існує то реєстрація не буде реалізована

        if (user == null && pwd == pwd_again) {                         //Перевірка правильно введеного пароля
            userDao.createdUser(login, email, pwd, number, 1);     //Створення нового користувача
            user = userDao.findUserByLogin(login);                      //Пошук даних про зареєстрованого користувача
            session.setAttribute("user", user);                      //Записуємо зареєстрованого користувача в сесію
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();

        indexView.outRegistration(out);                                  //Вивід сторінки реєстрації
    }
}
