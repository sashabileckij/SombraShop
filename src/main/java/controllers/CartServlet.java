package controllers;

import dao.CartDaoImpl;
import models.User;
import views.CartView;
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
 * Сервлет призначений для користувачів
 * Його функціонал: Вивід всіх лотів яких ви кинули в кошик, ви зможите підвердити або відхилити покупку.
 */

@WebServlet(name = "CartServlet", urlPatterns = "/cart/*")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        CartDaoImpl cartDao = new CartDaoImpl();

        String active = request.getParameter("active");
        char[] chars = active.toCharArray();
        int role = Character.getNumericValue(chars[0]);
        String id_lot = "";
        for (int i = 1; i < chars.length; i++) {
            id_lot = id_lot + chars[i];
        }

        if (role == 1) {
            cartDao.editCarRoleById(id_lot, "1", user);         //Якщо ви натиснули на кнопку з колонки Confirm тоді ваша заявка на продукт відправляється в базу даних
            response.sendRedirect("/cart");
        } else if (role == 0) {
            cartDao.editCarRoleById(id_lot, "0", user);         //Якщо ви натиснули на кнопку з колонки Remove тоді ваша заявка Скасовується
            response.sendRedirect("/cart");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartDaoImpl cartDao = new CartDaoImpl();
        User user = (User) session.getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CartView cartView = new CartView();

        cartView.outCartTable(out, cartDao.findCartById(user.getId()));   //Вивід таблички з вашими можливими покупками
    }
}
