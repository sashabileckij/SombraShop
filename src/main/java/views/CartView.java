package views;

import dao.LotDaoImpl;
import models.Cart;
import models.Lot;

import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * Клас для виводу даних кошика
 */
public class CartView {
    public void outCartTable(PrintWriter out, ArrayList<Cart> carts){
        LotDaoImpl lotDao = new LotDaoImpl();
        out.println("<div class=\"container col-lg-offset-1 col-lg-10\">\n" +
                "    <h2 class=\"text-center\">You Cart</h2>\n" +
                "    <table class=\"table table-hover\">\n" +
                "        <thead>\n" +
                "\n" +
                "        <tr>\n" +
                "            <th>NameLot</th>\n" +
                "            <th>Price</th>\n" +
                "            <th>Photo</th>\n" +
                "            <th>Confirm</th>\n" +
                "            <th>Remove</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>");
        for (Cart cart : carts) {
            Lot lot;
            lot = lotDao.findLotId(cart.getId_lot());
            out.println("<tr><td>" + lot.getName() + "</td>\n" +
                    "            <td>" + lot.getPrice() + "</td>\n" +
                    "            <div class=\"container\">\n" +
                    "                <td><img class=\"col-lg-2\" src=\"../../../img" + lot.getJpg() + "\" alt=\"\"></td>\n" +
                    "            </div>\n" +
                    "            <td>\n" +
                    "                <form class=\"col-lg-offset-2\" action=\"/cart/\" method=\"POST\" class=\"col-lg-3 form-horizontal\">\n" +
                    "                    <button class=\"btn btn-primary btn-block\" id=\"active\" name=\"active\" value=\"" + "1" + lot.getId() + "\" type=\"submit\">\n" +
                    "                        <span class=\"glyphicon glyphicon-ok\"></span>\n" +
                    "                    </button>\n" +
                    "                </form>\n" +
                    "            </td>\n" +
                    "            <td>\n" +
                    "                <form class=\"col-lg-offset-2\" action=\"/cart/\" method=\"POST\" class=\"col-lg-3 form-horizontal\">\n" +
                    "                    <button  class=\" btn btn-primary btn-block\" id=\"remove\" name=\"active\" value=\"" + "0" + lot.getId() + "\" type=\"submit\">\n" +
                    "                       <span class=\"glyphicon glyphicon-remove\"></span>\n" +
                    "                    </button>\n" +
                    "                </form>\n" +
                    "            </td></tr>");
        }
        out.println("</tbody>\n" +
                "    </table>\n" +
                "</div>");
    }

}
