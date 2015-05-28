/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Idap;
import model.Mahasiswa;

/**
 *
 * @author General
 */
public class AlergiControl extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            String nim = (String) session.getAttribute("nim");
            String nimPeserta = (String) session.getAttribute("nimPeserta");
            System.out.println(nim);


            String[] kdAlergiList = request.getParameterValues("kdAlergi");
            for (int i = 0; i < kdAlergiList.length; i++) {
//                if (kdAlergiList[i].equals("A001")) {
//                    Idap alergi = new Idap();
//                    alergi.setKodeAlergi(kdAlergiList[i]);
//                    alergi.setNim(nim);
//                    MahasiswaKontrol.getKoneksiMahasiswa().confirmAlergi(alergi);
//                }else{
//                    System.out.println("asdasjdbfakjsfb");
//                }
                Idap alergi = new Idap();
                alergi.setKodeAlergi(kdAlergiList[i]);
                if (nim != null) {
                    alergi.setNim(nim);
                    RequestDispatcher rd = request.getRequestDispatcher("W06_DAFTAR_BARU.jsp");
                    rd.forward(request, response);
                }
                if (nimPeserta != null) {
                    alergi.setNim(nimPeserta);
                    RequestDispatcher rd = request.getRequestDispatcher("W08_DAFTAR_LAMA.jsp");
                    rd.forward(request, response);
                }
                MahasiswaKontrol.getKoneksiMahasiswa().confirmAlergi(alergi);
//                Mahasiswa peserta = new Mahasiswa();
//                peserta.setAlergi("Ya");
//                peserta.setNim(nim);
//                MahasiswaKontrol.getKoneksiMahasiswa().updateAlergi(peserta);
            }

            session.setAttribute("alergi", kdAlergiList);

        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }



        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlergiControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlergiControl at " + request.getContextPath() + "</h1>");
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
