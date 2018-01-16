package controllers;

import models.User;
import views.IndexView;
import views.PathHtmlSingleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Головний фільтр
 * Його функціонал: Вивід початку та кінця html сторінки, та перевірка на авторизацію, динамічне меню
 */
@WebFilter(filterName = "IndexFilter", value = {"/*", "/register","/login","/lot/*","/user/*","/search"})
public class IndexFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PathHtmlSingleton pathHtmlSingleton = PathHtmlSingleton.getInstance();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        IndexView indexView = new IndexView();
        User user = (User) session.getAttribute("user");

        indexView.outTopPage(out);                          //Вивід початку html сторінки
        if (user == null) {
            indexView.outMenu(out);                         //Вивід шапки для користувачів які не пройшли авторизації
        } else if (user.getLogin().equals("admin")) {
            indexView.outMenuAdmin(out);                    //Вивід шапки для тих хто зайшов як адміністратор
        } else indexView.outMenu_Login(out);                //Вивід шапки для авторизованих користувачів
        chain.doFilter(request, response);
        indexView.outBottomPage(out);                       //Вивід кінця html сторінки
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
