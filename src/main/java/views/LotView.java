package views;

import models.Lot;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Клас для виводу даних лотів
 */
public class LotView {

    public void outLot(PrintWriter out, Lot fatherLot, ArrayList<Lot> lots){
        out.println("<div class=\"container col-lg-3\">\n" +
                "    <div class=\"page-header\">\n" +
                "    </div>\n" +
                "    <div id=\"carousel2\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "        <ol class=\"carousel-indicators\">\n" +
                "            <li data-target=\"#carousel2\" data-slide-to=\"0\" class=\"active\"></li>");
        for (int i = 0; i < lots.size(); i++) {
            out.println("<li data-target=\"#carousel2\" data-slide-to=\"" + i + "\"></li>");
        }
        out.println("</ol>\n" +
                "        <a type=\"button\" class=\"btn \" data-toggle=\"modal\" data-target=\"#myModal1\">\n" +
                "            <div class=\"carousel-inner\">\n" +
                "                        <div class=\"item active\">\n" +
                "                          <img src=\"../../../img" + fatherLot.getJpg() + "\" alt=\"" + fatherLot.getJpg() + "\">\n" +
                "                        </div>");
        int i = 0;
        for (Lot lot : lots) {
            if (i != 0) {
                out.println("<div class=\"item\">\n" +
                        "                    <img src=\"../../../img" + lot.getJpg() + "\">\n" +
                        "                </div>");
            }
            i++;
        }
        out.println("</div>\n" +
                "        </a>\n" +
                "        <a class=\"left carousel-control\" href=\"#carousel2\" role=\"button\" data-slide=\"prev\">\n" +
                "            <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n" +
                "            <span class=\"sr-only\">Previous</span>\n" +
                "        </a>\n" +
                "        <a class=\"right carousel-control\" href=\"#carousel2\" role=\"button\" data-slide=\"next\">\n" +
                "            <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n" +
                "            <span class=\"sr-only\">Next</span>\n" +
                "        </a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<div><h1></h1></div>\n" +
                "<div><h1></h1></div>\n" +
                "<div><h1></h1></div>\n" +
                "<div class=\"container\">\n" +
                "    <div><h1></h1></div>\n" +
                "    <div><h1></h1></div>\n" +
                "    <div><h1></h1></div>\n" +
                "    <div><h1></h1></div>\n" +
                "    <div class=\"container col-lg-5 alert alert-success\">");
        out.println("<h1>" + fatherLot.getName() + "<span class=\"col-lg-offset-3 text-right label label-success\">Success</span></h1>");
        out.println("</div>\n" +
                "    <div class=\"col-lg-5\">");
        out.println("</div>\n" +
                "    <div class=\"col-lg-5\">\n" +
                "        <h4>Location: fdhdj</h4>\n" +
                "        <h4>Cena: " + fatherLot.getPrice() + "</h4>\n" +
                "        <div><h1></h1></div>\n" +
                "        <div><h1></h1></div>\n" +
                "        <form action=\"/lot/\" method=\"POST\" class=\"form-horizontal\">\n" +
                "            <button href=\"/lot/buy\" class=\"btn btn-lg btn-primary \" id=\"buy\" name=\"buy\" value=\""+fatherLot.getId()+"\" type=\"submit\">Buy</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "\n" +
                "</div>\n" +
                "<div id=\"myModal1\" class=\"modal fade\" role=\"dialog\">\n" +
                "    <div class=\"modal-dialog\">\n" +
                "        <div class=\"modal-content\">\n" +
                "            <div class=\"modal-header\">\n" +
                "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                "            </div>\n" +
                "\n" +
                "            <div id=\"carousel1\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "                <ol class=\"carousel-indicators\">\n" +
                "                    <li data-target=\"#carousel1\" data-slide-to=\"0\" class=\"active\"></li>");

        for (i = 0; i < lots.size(); i++) {
            out.println("<li data-target=\"#carousel1\" data-slide-to=\"" + i + "\"></li>");
        }
        out.println("</ol>\n" +
                "                <!-- Wrapper for slides -->\n" +
                "                <a type=\"button\" class=\"btn \" data-toggle=\"modal\" data-target=\"#myModal1\">\n" +
                "                    <div class=\"carousel-inner\">\n" +
                "                        <div class=\"item active\">\n" +
                "                            <img src=\"../../../img" + fatherLot.getJpg() + "\" alt=\"1\">\n" +
                "                        </div>");
        i = 0;
        for (Lot lot : lots) {
            if (i != 0) {
                out.println("<div class=\"item\">\n" +
                        "                            <img src=\"../../../img" + lot.getJpg() + "\" alt=\"" + i + "\">\n" +
                        "                        </div>");
            }
            i++;
        }
        out.println(" </div>\n" +
                "                </a>\n" +
                "                <a class=\"left carousel-control\" href=\"#carousel1\" role=\"button\" data-slide=\"prev\">\n" +
                "                    <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n" +
                "                    <span class=\"sr-only\">Previous</span>\n" +
                "                </a>\n" +
                "                <a class=\"right carousel-control\" href=\"#carousel1\" role=\"button\" data-slide=\"next\">\n" +
                "                    <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n" +
                "                    <span class=\"sr-only\">Next</span>\n" +
                "                </a>\n" +
                "            </div>\n" +
                "            <div class=\"modal-footer\">\n" +
                "                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<p></p>\n" +
                "<p></p>\n" +
                "<p></p>\n" +
                "<div class=\"row\">\n" +
                "    <div class=\"col-sm-10\">\n" +
                "        <div class=\"panel panel-default\">\n" +
                "            <div class=\"panel-heading\">\n" +
                "                <h3 class=\"panel-title\">About the product</h3>\n" +
                "            </div>\n" +
                "            <div class=\"panel-body\">\n" +
                "                Panel content\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>");
    }

    public void outCarPage(PrintWriter out, ArrayList<Lot> lots) {
        for (Lot lot : lots) {
            if(lot!=null)
            out.println("\n" +
                    "    <div class=\"col-sm-4 col-md-3 container-fluid\">\n" +
                    "        <div class=\"thumbnail container-fluid\">\n" +
                    "            <div class=\"caption container-fluid\">\n" +
                    "<form action=\"/lot/\" method=\"POST\" class=\"form-horizontal\">"+
                    "<button class=\"btn btn-lg btn-link btn-block\" id=\"id\" type=\"submit\" name=\"id\" value=\""+lot.getId()+"\">"+
                    "                <p>\n" +
                    "                    <a><img src=img/" + lot.getJpg() + "></a>\n" +
                    "                    <a>" + lot.getName() + "</a>\n" +
                    "                    <p></p>" +
                    "                    <a>Currert price: " + lot.getPrice() + "</a>\n" +
                    "                </p>\n" +
                    "</button>"+
                    "</form>"+
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>");
        }
    }


}
