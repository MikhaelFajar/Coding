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
import model.Derita;
import model.Mahasiswa;

/**
 *
 * @author General
 */
public class PenyakitControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            HttpSession session = request.getSession();
            String nim = (String) session.getAttribute("nim");
            String nimPeserta = (String) session.getAttribute("nimPeserta");
            String[] kdPenyakitList = request.getParameterValues("kdPenyakit");
            for (int i = 0; i < kdPenyakitList.length; i++) {
                Derita penyakit = new Derita();
                penyakit.setKodePenyakit(kdPenyakitList[i]);
                if (nim != null) {
                    penyakit.setNim(nim);
                    RequestDispatcher rd = request.getRequestDispatcher("W06_DAFTAR_BARU.jsp");
                    rd.forward(request, response);
                }
                if (nimPeserta != null) {
                    penyakit.setNim(nimPeserta);
                    RequestDispatcher rd = request.getRequestDispatcher("W08_DAFTAR_LAMA.jsp");
                    rd.forward(request, response);
                }
                try {
                    MahasiswaKontrol.getKoneksiMahasiswa().confirmPenyakit(penyakit);
//                    Mahasiswa peserta=new Mahasiswa();
//                    peserta.setPenyakit("Ya");
//                    peserta.setNim(nim);
//                    MahasiswaKontrol.getKoneksiMahasiswa().updatePenyakit(peserta);
                } catch (SQLException ex) {
                    Logger.getLogger(PenyakitControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PenyakitControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PenyakitControl at " + request.getContextPath() + "</h1>");
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
