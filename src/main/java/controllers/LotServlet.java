package controllers;


import dao.CartDaoImpl;
import dao.LotDaoImpl;
import models.Lot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import models.User;
import views.LotView;

/**
 * Сервлет призначений для виводу даних про товари
 * Його функціонал: Вивід всіх товарів на головну сторіну, вивід особистої сторінки кожного товару, та можливість покупки
 */

@WebServlet(name = "LotServlet", urlPatterns = "/lot/*")
public class LotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDaoImpl cartDao = new CartDaoImpl();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        String link = request.getParameter("id");
        String buy = request.getParameter("buy");

        if (link != null) {
            response.sendRedirect("/lot/" + link);             //Якщо ви натиснули на товар на головній сторінці переходим на особисту сторінку товару
        }
        if (buy != null) {
            cartDao.addCartByIdLotIdUser(buy, user);              //Якщо ви натиснули на придбати товар то ваш товар прямує у ваш кошик
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        LotDaoImpl lotDao = new LotDaoImpl();
        Lot lot;
        LotView lotView = new LotView();

        char[] link = request.getPathInfo().toCharArray();
        String f = "";
        for (int i = 1; i < link.length; i++) {
            f = f + link[i];
        }
        int link_final = Integer.parseInt(f);

        switch (request.getPathInfo()) {
            case "/":
                break;
            default:
                lot = lotDao.findLotId(link_final);
                lotView.outLot(out, lot, lotDao.findLotCategoryName(lot.getCategory(), lot.getName())); //Вивід всіх товарів на головну сторінку
                break;
        }
    }
}
