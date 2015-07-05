/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "send_data", urlPatterns = {"/send_data"})
public class send_data extends HttpServlet {

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

            final String mail = "g_rico_c@hotmail.com";

            InetAddress address = InetAddress.getLocalHost();
            String maquina = address.getHostName();

            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String R_curso = request.getParameter("curso");
            String R_money = request.getParameter("money");
            String R_days = request.getParameter("days");
            String R_requisitos = request.getParameter("OK");

            String comentarios = request.getParameter("coment");

            String msg = "Aspirante: " + nombre + "<br><br> Enviado desde: " + maquina + "<br><br> Email de Contacto: " + email + "<br><br> Le interesa el curso: " + R_curso + "<br><br> Estaria dispuesto a pagar: " + R_money + "<br><br> Prefiere que sea: " + R_days + "<br><br> Esta de acuerdo con los requisitos: " + R_requisitos + "<br><br> Comentarios: " + comentarios;

//            Logica.cMail mailto = new Logica.cMail(mail, "Respuestas de la encuesta", msg);
//            mailto.SendMail();

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gracias por contestar</title>");
            out.println("<link href=\"css/index-css.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"final\">");
            out.println("<h1>Gracias por sus Respuestas</h1>");
            out.println("<p>Si desea más informacion acerca del curso, no dude en mande un e-mail a <a href=\"mailto:g_rico_c@hotmail.com?Subject=Dudas%20sobre%20el%20curso%20de%20Java\" target=\"_top\">g_rico_c@hotmail.com</a> </p>");
            out.println("<p>No olvides seguirnos en <a href=\"https://www.facebook.com/CentrodeAprendizajeDigital\" target=\"_blank\">facebook</a></p>");
            out.println("<br><br>   <input onclick=\"window.close();\" type=\"button\" value=\"Terminar\"/>");
            out.println("</div>");
            out.println("<div id=\"footerfinal\">\n"
                    + "\n"
                    + "            Centro de Aprendizaje Digital 2015 \n"
                    + "            Easysoft Company\n"
                    + "\n"
                    + "        </div>");
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
        response.sendError(405, "Este método esta Bloqueado por el Administrador");
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
