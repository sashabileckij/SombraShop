package views;

import java.io.PrintWriter;

/**
 * Виводить HTML сторінку bootstrap
 */
public class IndexView {

    private PathHtmlSingleton pathHtmlSingleton;

    public IndexView() {
        pathHtmlSingleton = PathHtmlSingleton.getInstance();
    }

    public void outTopPage(PrintWriter out) {
        out.println(pathHtmlSingleton.getTop());
    }

    public void outBottomPage(PrintWriter out) {
        out.println(pathHtmlSingleton.getBottom());
    }

    public void outMenu(PrintWriter out) {
        out.println(pathHtmlSingleton.getMenu());
    }

    public void outMenuAdmin(PrintWriter out) {
        out.println(pathHtmlSingleton.getMenu_admin());
    }

    public void outMenu_Login(PrintWriter out) {
        out.println(pathHtmlSingleton.getMenu_login());
    }

    public void outLogin(PrintWriter out) {
        out.println(pathHtmlSingleton.getLogin());
    }

    public void outRegistration(PrintWriter out) {
        out.println(pathHtmlSingleton.getRegistration());
    }

    public void outUser(PrintWriter out) {
        out.println(pathHtmlSingleton.getUser());
    }

    public void outAdmin(PrintWriter out) {
        out.println(pathHtmlSingleton.getAdmin());
    }



}


