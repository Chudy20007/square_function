package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Date;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/getdata.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"WebContent/basic.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"WebContent/register_style.css\" />\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("        \n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"row row-custom\">\n");
      out.write("                    aaa\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row row-custom\">\n");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("<div class=\"col-md-12 col-md-12-custom\">\n");
      out.write("    <form method=\"POST\" style=\"margin-top: 20px;\" id='form' action=\"main\" style=\"text-align: center\">\n");
      out.write("         <b>Value a: </b> <input type=\"number\" id=\"x_axis\" name=\"a\" value=\"3\" placeholder=\"3\" /><br/><br/>\n");
      out.write("        <b>Value b </b> <input type=\"numer\" id=\"y_axis\" name=\"b\" value=\"2\" placeholder=\"2\" /><br/><br/>\n");
      out.write("         <b>Value c </b> <input type=\"numer\" id=\"x_axis\" name=\"c\" value=\"-1\" placeholder=\"4\" /><br/><br/>\n");
      out.write("        \n");
      out.write("        <b>X points: </b> <input type=\"color\" id=\"x_axis\" name=\"x_axis\" value=\"black\" placeholder=\"\" /><br/><br/>\n");
      out.write("        <b>Y points: </b> <input type=\"color\" id=\"y_axis\" name=\"y_axis\" value=\"black\" placeholder=\"\" /><br/><br/>\n");
      out.write("        <b>Function color: </b> <input type=\"color\" id=\"function_color\" name=\"function_color\" value=\"black\" placeholder=\"\" /><br/><br/>\n");
      out.write("        <b>Background color: </b> <input type=\"color\" id=\"background_color\" name=\"background_color\" value=\"yellow\" placeholder=\"\" /><br/><br/>\n");
      out.write("        <b>Lines color: </b> <input type=\"color\" id=\"lines_color\" name=\"lines_color\" value=\"\" placeholder=\"\" /><br/><br/>\n");
      out.write("        <b>X-axis range: </b> <input type=\"number\" id=\"x_axis_range\" name=\"x_axis_range\" value=\"50\" placeholder=\"\" /><br/><br/>\n");
      out.write("        <b>Y-axis range: </b> <input type=\"number\" id=\"y_axis_range\" name=\"y_axis_range\" value=\"30\" placeholder=\"\" /><br/><br/>\n");
      out.write("        \n");
      out.write("        <input type=\"submit\" onclick='return sprawdz();' value=\"Przeslij\" />\n");
      out.write("        <br/><br/>\n");
      out.write("        <script src=\"WebContent/sprawdz_formularz.js\"></script>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row row-custom\">\n");
      out.write("                    <div class=\"footer\">\n");
      out.write("                        Wszystkie prawa zastrzeżone. <address>a.kowalski@wwx.pl</address>\t\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
