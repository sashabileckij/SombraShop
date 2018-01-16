package views;

import models.City;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Клас для виводу даних Міста
 */
public class CityView {
    public void outCity(PrintWriter out, ArrayList<City> cities){
        out.println("<div class=\"text-left\">\n" +
                "    <div class=\"container\">\n" +
                "        <form action=\"/admin_edit_cities\" method=\"POST\" class=\"navbar-form navbar-left\">\n" +
                "            <label class=\"control-label \" >Add new city:</label>\n" +
                "            <input class=\"form-control\" name=\"inputCity\" id=\"inputCity\">\n" +
                "            <button  type=\"submit\" class=\"btn btn-default\">Add</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</div>\n");
        out.println("<div class=\"container\">\n" +
                "    <table class=\"table table-striped\">\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <th>City Name</th>\n" +
                "            <th>Role</th>\n" +
                "            <th>Active Status</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "<tbody>");
        for(City city:cities){
            String active = null;
            if (city.getRole()==1) {
                active = "glyphicon glyphicon-ok";
            } else active = "glyphicon glyphicon-remove";
            out.println("<tr>\n" +
                    "            <td>"+city.getName()+"</td>\n" +
                    "            <td>"+city.getRole()+"</td>\n" +
                    "<td><form action=\"/admin_edit_cities\" method=\"POST\" class=\"form_size\">\n" +
                    "<button type=\"submit\" name=\"id\" value=\"" + city.getId() + "\" class=\"btn  btn-default\">\n" +
                    "        <span class=\"" + active + "\" aria-hidden=\"true\">\n" +
                    "        </span>\n" +
                    "</button></td>\n" +
                    "        </tr>");
        }
    }
}
