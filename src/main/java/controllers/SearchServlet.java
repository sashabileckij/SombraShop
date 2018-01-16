package controllers;

import dao.LotDaoImpl;
import models.Lot;
import views.LotView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Сервлет призначений для пошуку продукту за його іменим
 */

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private String search;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        search = request.getParameter("inputSearch");

        if (search != null) {
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        LotDaoImpl lotDao = new LotDaoImpl();
        ArrayList<Lot> lots;
        LotView lotView = new LotView();

        out.println("<div class=\"container\">");
        if (search != null) {
            lots = lotDao.findLotName(search);        //Пошук лота за іменим
            lotView.outCarPage(out, lots);            //Виведення лотів при пошуку
        }
    }
}
