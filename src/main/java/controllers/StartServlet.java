package controllers;

import dao.LotDaoImpl;
import models.Lot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import views.LotView;
import views.NavigatorView;
import views.PathHtmlSingleton;

/**
 * Головний сервлет
 * Його функціонал: вивід всіх продуктів, а також загрузка всіх html сторінок для подальшої роботи
 */

@WebServlet(name = "StartServlet", urlPatterns = {"/*"})
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NavigatorView navigatorView = new NavigatorView();
        LotDaoImpl lotDao = new LotDaoImpl();
        ArrayList<Lot> lots;
        ArrayList<Lot> lots1;
        LotView lotView = new LotView();

        navigatorView.outNavigator(out, lotDao.findLotCategory());       //Вивід всіх категорій

        lots = lotDao.findLotCategory();

        if (request.getPathInfo().equals("/")) {
            lots = lotDao.viewsLots();
            lotView.outCarPage(out, lots);                               //Вивід всіх лотів
        } else {
            for (Lot lot : lots) {
                if (request.getPathInfo().equals("/" + lot.getCategory())) {
                    lots1 = lotDao.findLotCategory(lot.getCategory());
                    lotView.outCarPage(out, lots1);                      //Вивід всіх лотів за натисненою категорєю
                    break;
                }
            }
        }
    }

    /**
     * Загрузка всіх html сторінок для подальшої роботи
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        PathHtmlSingleton pathHTML = PathHtmlSingleton.getInstance();
        if (pathHTML.getPath().equals("")) {
            pathHTML.setPath(getServletContext().getRealPath("/html/"));
        }
        pathHTML.setTop("top.html");
        pathHTML.setMenu("menu.html");
        pathHTML.setMenu_admin("menu_admin.html");
        pathHTML.setMenu_login("menu_login.html");
        pathHTML.setBottom("bottom.html");
        pathHTML.setLogin("login.html");
        pathHTML.setRegistration("registration.html");
        pathHTML.setUser("user.html");
        pathHTML.setAdmin("admin.html");
        System.out.println("Path\t" + pathHTML.getPath());
    }
}
