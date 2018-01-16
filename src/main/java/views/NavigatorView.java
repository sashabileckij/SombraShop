package views;

import models.Lot;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Клас для виводу даних для навігації по категоріях
 */
public class NavigatorView {
    public void outNavigator(PrintWriter out, ArrayList<Lot> lots) {
        out.println("<div class=\"row\">\n" +
                "  <nav class=\"navbar navbar-default\" role=\"navigation\">\n" +
                "    <div class=\"container-fluid\">\n" +
                "      <div class=\"collapse navbar-collapse\">\n" +
                "        <ul class=\"nav navbar-nav navbar-left\">");
        for (Lot lot1 : lots) {
            out.println("          <li><a href=\"/" + lot1.getCategory() + "\">" + lot1.getCategory() + "</a></li>");
        }
        out.println(    "        </ul>\n" +
                        "        <u1 class=\"nav navbar-nav navbar-right\">\n" +
                        "          <li><a href=\"/\">All</a></li>\n" +
                        "        </u1>\n" +
                        "      </div><!-- /.navbar-collapse -->\n" +
                        "    </div><!-- /.container-fluid -->\n" +
                        "  </nav>\n" +
                        "</div>\n" +
                        "\n"+
                        "<div class=\"container\">");
    }
}
