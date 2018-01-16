package views;

import models.User;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Клас для виводу даних про користувачів
 */
public class UserView {
    public void outUsertable(PrintWriter out, ArrayList<User> users) {
        out.println("\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <table class=\"table\">\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th>id</th>\n" +
                "                    <th>Login</th>\n" +
                "                    <th>Email</th>\n" +
                "                    <th>Number</th>\n" +
                "                    <th>Role</th>\n" +
                "                    <th>Active status</th>\n" +
                "                    <th>Edit</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody>");
        for (User user : users) {
            if (user.getLogin().equals("admin"))
            {
                continue;
            }
            else {
                String active = null;
                if (user.getRole().equals("1")) {
                    active = "glyphicon glyphicon-ok";
                } else active = "glyphicon glyphicon-remove";
                out.println("<tr>\n" +
                        "                <td>" + user.getId() + "</td>\n" +
                        "                <td>" + user.getLogin() + "</td>\n" +
                        "                <td>" + user.getEmail() + "</td>\n" +
                        "                <td>" + user.getNumber() + "</td>\n" +
                        "                <td>" + user.getRole() + "</td>\n" +
                        "                <td><form action=\"/admin\" method=\"POST\" class=\"form_size\">\n" +
                        "<button href=\"/admin/block\" type=\"submit\" name=\"id\" value=\"" + user.getId() + "\" class=\"btn  btn-default\" aria-label=\"Left Align\">\n" +
                        "        <span class=\"" + active + "\" aria-hidden=\"true\">\n" +
                        "        </span>\n" +
                        "</button></td>\n" +
                        "                <td>" + "<!-- Trigger the modal with a button -->\n" +
                        "<button type=\"button\" class=\"btn btn-info btn-lg\" data-toggle=\"modal\" data-target=\"#myModal" + user.getId() + "\">Edit</button>\n" +
                        "<form action=\"/admin\" method=\"POST\" class=\"form-horizontal\">\n" +
                        "<!-- Modal -->\n" +
                        "<div id=\"myModal" + user.getId() + "\" class=\"modal fade\" role=\"dialog\">\n" +
                        "    <div class=\"modal-dialog\">\n" +
                        "        <!-- Modal content-->\n" +
                        "        <div class=\"modal-content\">\n" +
                        "            <div class=\"modal-header\">\n" +
                        "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                        "<div class=\"text-center\" s>"+
                        "                <h4 class=\"modal-title\">Edit User</h4>\n" +
                        "            </div>\n" +
                        "            </div>\n" +
                        "            <div class=\"modal-body\">\n" +
                        "                <label for=\"login\">Login</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" id=\"login\" name=\"login\" value=\"" + user.getLogin() + "\">\n" +
                        "\n" +
                        "                <label for=\"email\">Email</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\" value=\"" + user.getEmail() + "\">\n" +
                        "\n" +
                        "                <label for=\"number\">Number</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" id=\"number\" name=\"number\" value=\"" + user.getNumber() + "\">\n" +
                        "                <p></p>\n" +

                        "                <div class=\"container text-center \">\n" +
                        "                <button href=\"/admin/edit\" type=\"submit\" name=\"id\" value=\"" + user.getId() + "\" class=\"btn btn-primary btn-block\">Змінити</button>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "</form>" + "</td>\n" +
                        "            </tr>");
            }
        }
    }
}
