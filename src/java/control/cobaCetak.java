/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author General
 */
public class cobaCetak extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection kon = null;
        String reportSource = "";
        try {
            kon = new koneksi.Koneksi().getKoneksiHome();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        reportSource = request.getServletContext().getRealPath("/LaporanRPL/data_mhs_fixbanget.jasper");
//                
//        reportSource="E:/Modul Kuliah/Semester 5/RPL O/RPL_PINISSI_TAMP/LaporanRPL/data_mhs.jasper";

        Map<String, Object> params = new HashMap<String, Object>();
        try {

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportSource, params, kon);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("W09_LIHAT_PESERTA.jsp");
        rd.forward(request, response);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cobaCetak</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cobaCetak at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
