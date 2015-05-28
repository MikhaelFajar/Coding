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
import model.Mahasiswa;

/**
 *
 * @author General
 */
public class DaftarLamaControl extends HttpServlet {

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

            String pilih = request.getParameter("process");
            Mahasiswa mhs = new Mahasiswa();

            String nimPeserta = request.getParameter("nimPeserta");
            mhs.setNim(nimPeserta);
            mhs.setPassword(nimPeserta);
            String namaPeserta = request.getParameter("namaPeserta");
            mhs.setNama(namaPeserta);
            String alamatPeserta = request.getParameter("alamatPeserta");
            mhs.setAlamat(alamatPeserta);

            String pilihJurusan = request.getParameter("pilihjurusan");
            if (pilihJurusan.equalsIgnoreCase("Teknik Informatika")) {
                mhs.setProdi("Teknik Informatika");
            } else if (pilihJurusan.equalsIgnoreCase("Teknik Elektro")) {
                mhs.setProdi("Teknik Elektro");
            } else if (pilihJurusan.equalsIgnoreCase("Teknik Mesin")) {
                mhs.setProdi("Teknik Mesin");
            } else if (pilihJurusan.equalsIgnoreCase("Matematika Murni")) {
                mhs.setProdi("Matematika Murni");
            }

            String makanan = request.getParameter("konsumsi");
            mhs.setKonsumsi(makanan);
            mhs.setTahun("2014");
            mhs.setStatus("1");

            if (pilih != null) {
                HttpSession session = request.getSession();
                session.setAttribute("nimPeserta", nimPeserta);
                session.setAttribute("namaPeserta", namaPeserta);
                session.setAttribute("alamatPeserta", alamatPeserta);
                session.setAttribute("pilihjurusan", pilihJurusan);

                if (pilih.equalsIgnoreCase("PILIH ALERGI")) {
                    PanitiaKontrol.getKoneksiPanitia().insertMahasiswaLama(mhs);
                    RequestDispatcher rd = request.getRequestDispatcher("W10_ALERGI.jsp");
                    rd.forward(request, response);
                } else if (pilih.equalsIgnoreCase("PILIH PENYAKIT")) {
                    String nim = (String) session.getAttribute("nimPeserta");
                    if (MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(nim) == true) {
                        RequestDispatcher rd = request.getRequestDispatcher("W11_PENYAKIT.jsp");
                        rd.forward(request, response);
                    } else if (MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(nim) == false) {
                        PanitiaKontrol.getKoneksiPanitia().insertMahasiswaLama(mhs);
                        RequestDispatcher rd = request.getRequestDispatcher("W11_PENYAKIT.jsp");
                        rd.forward(request, response);
                    }
                } else if (pilih.equalsIgnoreCase("DAFTAR")) {
                    String nim = (String) session.getAttribute("nimPeserta");
                    if (MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(nim) == true) {
                        MahasiswaKontrol.getKoneksiMahasiswa().updateDataKonsumsi(mhs);
                        if ((session.getAttribute("nimPeserta") != null)
                                && (session.getAttribute("namaPeserta") != null)
                                && (session.getAttribute("alamatPeserta") != null)
                                && (session.getAttribute("pilihjurusan") != null)) {
                            session.removeAttribute("nimPeserta");
                            session.removeAttribute("namaPeserta");
                            session.removeAttribute("alamatPeserta");
                            session.removeAttribute("pilihjurusan");
                            session.invalidate();
                        }
                        RequestDispatcher rd = request.getRequestDispatcher("W05_HOME_PANITIA.jsp");
                        rd.forward(request, response);
                    } else if (MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(nim) == false) {
                        PanitiaKontrol.getKoneksiPanitia().insertMahasiswaLama(mhs);
                        if ((session.getAttribute("nimPeserta") != null)
                                && (session.getAttribute("namaPeserta") != null)
                                && (session.getAttribute("alamatPeserta") != null)
                                && (session.getAttribute("pilihjurusan") != null)) {
                            session.removeAttribute("nimPeserta");
                            session.removeAttribute("namaPeserta");
                            session.removeAttribute("alamatPeserta");
                            session.removeAttribute("pilihjurusan");
                            session.invalidate();
                        }
                        RequestDispatcher rd = request.getRequestDispatcher("W05_HOME_PANITIA.jsp");
                        rd.forward(request, response);
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DaftarLamaControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DaftarLamaControl at " + request.getContextPath() + "</h1>");
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
