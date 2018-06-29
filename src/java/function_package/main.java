/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kacper-PC
 */
public class main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet main</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet main at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");
        String background = request.getParameter("background_color");
        String axisX = request.getParameter("x_axis");
        String axisY = request.getParameter("y_axis");
        String linesColor = request.getParameter("lines_color");
        String functionColor = request.getParameter("function_color");
        int axisY_r = Integer.valueOf(request.getParameter("y_axis_range"));
        int axisX_r = Integer.valueOf(request.getParameter("x_axis_range"));
        int a = Integer.valueOf(request.getParameter("a"));
        int b = Integer.valueOf(request.getParameter("b"));
        int c = Integer.valueOf(request.getParameter("c"));
        double resDelta = delta(a, b, c);
        double x1 = 0;
        double x2 = 0;
        double p = 0;
        double q = 0;

        if (resDelta > 0) {

            x1 = getX1(a, b, resDelta);
            x2 = getX2(a, b, resDelta);
            double b1 = -1 * b;
            double a2 = 2 * a;
            p = b1 / a2;
            a2 = 4 * a;
            double del1 = resDelta * -1;
            q = del1 / a2;
        }

        BufferedImage img = new BufferedImage(axisX_r * 20, axisY_r * 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        // In real life this would call some charting software...
        g.setColor(Color.decode(background));

        g.fillRect(0, 0, axisX_r * 20, axisY_r * 20);
        g.setColor(Color.decode(linesColor));

        g.setStroke(new BasicStroke(2));
        g.drawLine(axisX_r * 20 / 2, 0, axisX_r * 20 / 2, axisY_r * 20);
        g.drawLine(0, axisY_r * 20 / 2, axisX_r * 20, axisY_r * 20 / 2);

        g.setColor(Color.decode(axisX));
        int scale = 10;
        g.setFont(new Font("sansserif", Font.BOLD, 14));
        while (scale < axisY_r * 20) {

            g.drawLine(axisX_r * 20 / 2 - 1, scale, axisX_r * 20 / 2 + 1, scale);
            g.drawString(String.valueOf((axisY_r * 20 / 2 - scale) / 20), axisX_r * 20 / 2 + 5, scale + 4);
            scale += 20;
        }

        scale = 20;
        g.setColor(Color.decode(axisY));
        while (scale < axisX_r * 20) {

            g.drawLine(scale, axisY_r * 20 / 2 - 1, scale, axisY_r * 20 / 2 + 1);
            g.drawString(String.valueOf((axisX_r * 20 / 2 - scale) / 20 * -1), scale - 3, axisY_r * 20 / 2 - 5);
            scale += 20;
        }

        p = (axisX_r * 20 / 2) + p * 20;

        g.setColor(Color.decode(functionColor));
        double unscaledX1 = x1;
        double unscaledX2 = x2;

        x1 = (axisX_r * 20 / 2) + x1 * 20;

        x2 = (axisX_r * 20 / 2) + x2 * 20;

        q = (axisY_r * 20 / 2) + q * 20 * -1;

        double[] points = new double[500];
//while (count<500){
        if (a > 0) {
            int count = 0;
            double p1 = p;
            double q1 = q;
            double p2 = p;
            double x1Temp = x1;
            double x2Temp = x2;
            double i = q1 - 20;
            double i2 = q1 - 20;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            while (count < 10) {

                i = getRes(a, b, c, unscaledX1) * axisY_r / 2 + q1;
                i2 = getRes(a, b, c, unscaledX2) * axisY_r / 2 + q1;
                //   g.drawLine(p1, q1, x1Temp, i);
                //   g.drawLine(p2, q1, x2Temp, i);
                Shape l = new Line2D.Double(p1, q1, x1Temp, i);
                Shape l2 = new Line2D.Double(p2, q1, x2Temp, i);
                g.draw(l);
                g.draw(l2);
                x1Temp -= 1;
                x2Temp += 1;

                unscaledX1 -= 0.1;
                unscaledX2 += 0.1;
                p1 = x1Temp + 1;
                p2 = x2Temp - 1;
                q1 = i;
                count++;

            }
        } else {
            int count = 0;
            double p1 = p;
            double q1 = q;
            double p2 = p;
            double x1Temp = x2;
            double x2Temp = x1;
            double i = q1 - 20;
            double i2 = q1 - 20;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            while (count < 10) {
                i = (getRes(a, b, c, unscaledX1) * axisY_r / 2 - q1) * -1;
                //   g.drawLine(p1, q1, x1Temp, i);
                //  g.drawLine(p2, q1, x2Temp, i);
                Shape l = new Line2D.Double(p1, q1, x1Temp, i);
                Shape l2 = new Line2D.Double(p2, q1, x2Temp, i);
                g.draw(l);
                g.draw(l2);
                x1Temp -= 1;
                x2Temp += 1;

                unscaledX1 -= 0.1;
                unscaledX2 += 0.1;
                p1 = x1Temp + 1;
                p2 = x2Temp - 1;
                q1 = i;
                count++;

            }

        }
        g.drawString("y="+a+"x^2+"+b+"x+"+c,30,30);
        OutputStream os = response.getOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);

        if (!ImageIO.write(img, "jpeg", ios)) {
            log("Boo hoo, failed to write JPEG");
        }
        ios.close();
        os.close();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public double delta(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    public double getX1(double a, double b, double delta) {
        double x = (-b + (Math.sqrt(delta) * -1)) / (2 * a);
        return (x);
    }

    public double getX2(double a, double b, double delta) {
        double x = (-b + (Math.sqrt(delta))) / (2 * a);
        return (x);
    }

    public double getRes(double a, double b, double c, double d) {
        double res = (a * d * d) + (b * d) + c;
        return res * -1;

    }

    private int screenX(double x, double axisX) {
        return (int) (axisX + x * 20); //converts -15<x<15 to screen coords
    }

    private int screenY(double y, double axisY) {
        return (int) (axisY + y * 20); //converts -15<y<15 to screen coords
    }
}
