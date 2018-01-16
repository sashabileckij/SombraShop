package controllers;

import dao.UserDaoImpl;
import models.User;
import views.IndexView;
import views.UserView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет призначений для адміністратора
 * Його функціонал: Редагування даних про всіх користувачів також можливість блочити їх
 */

@WebServlet(name = "AdminServlet", urlPatterns = "/admin/*")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDaoImpl userDao = new UserDaoImpl();

        long id = Long.parseLong(request.getParameter("id"));
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String number = request.getParameter("number");

        User user = new User();
        if (id != 0) {
            user = userDao.findUserByIdUser(id);                    //Пошук користувача по id
        }
        if (user != null)
            if (login.equals(user.getLogin()) && email.equals(user.getEmail()) && number.equals(user.getNumber())) {
                userDao.editRoleForId(user, id);                    //Якщо дані не змінилися а на кнопку в колонці Active status було нажати то воно або блочить або розблуковує користувача
                response.sendRedirect("/admin/edit");
            } else {
                userDao.editLoginEmailNumberForId(user, login, email, number); //Зміна даних про користувача
                response.sendRedirect("/admin/edit");
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        UserView userView = new UserView();
        UserDaoImpl userDao = new UserDaoImpl();

        indexView.outAdmin(out);                                    //Вивід сторінки користувача

        switch (request.getPathInfo()) {
            case "/edit":
                userView.outUsertable(out, userDao.findAllUser());  //Вивід таблички з усіма користувачами адміну
                break;
        }
    }
}
