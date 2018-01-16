package controllers;

import dao.CityDaoImpl;
import models.City;
import views.CityView;
import views.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет призначений для адміністратора
 * Його функціонал:  Добавлення та редагування нових міст, також робить їх активними або не активними.
 */

@WebServlet(name = "AdminEditCitiesServlet", urlPatterns = "/admin_edit_cities")
public class AdminEditCitiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        CityDaoImpl cityDao = new CityDaoImpl();
        City city;

        String inputCity = request.getParameter("inputCity");    //Ввід міста

        if (inputCity != null) {
            cityDao.createdCity(inputCity);                       //Створення нового міста в базі даних
            response.sendRedirect("/admin_edit_cities");       //Перезагружаємр сторінку
        }

        String id = request.getParameter("id");                //Ввід id міста

        if (id != null) {
            city = cityDao.findCityById(id);
            if (city != null) {
                cityDao.editCityRole(city);                       //Якщо місто доступно то ми його блочимо або навпаки
                response.sendRedirect("/admin_edit_cities");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        CityView cityView = new CityView();
        CityDaoImpl cityDao = new CityDaoImpl();

        indexView.outAdmin(out);                                  //Вивід сторінки адміна
        cityView.outCity(out, cityDao.findAllCity());             //Вивід таблички з назвами міст та їхніми ролями
    }
}
