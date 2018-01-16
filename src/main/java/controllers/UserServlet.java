package controllers;

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
 * Сервлет призначений для редагування даних про себе, та можливість вийти зі своєї сторінки
 */

@WebServlet(name = "UserServlet",urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        IndexView indexView = new IndexView();
        indexView.outUser(out);                                  //Вивід сторінки для редагування даних

        switch (request.getPathInfo()) {
            case "/out":
                session.removeValue("user");                  //Вихід зі своє сторінки
                response.sendRedirect("/login");
                break;
        }
    }
}
