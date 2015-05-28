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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Mahasiswa;

/**
 *
 * @author General
 */
public class LoginControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            String nim = request.getParameter("nim");
            String passwd = request.getParameter("pass");

            HttpSession session = request.getSession();
            session.setAttribute("nim", nim);
            session.setAttribute("password", passwd);

            if (MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(nim) == true) {
                // SUDAH TERDAFTAR
                JOptionPane.showMessageDialog(null, "Selamat Datang Mahasiswa "+nim,"",JOptionPane.INFORMATION_MESSAGE);
                RequestDispatcher rd = request.getRequestDispatcher("W04_HOME_MABA.jsp");
                rd.forward(request, response);
            } else {
                //BELUM TERDAFTAR
                JOptionPane.showMessageDialog(null, "LOGIN GAGAL","",JOptionPane.ERROR_MESSAGE);
                RequestDispatcher rd = request.getRequestDispatcher("W01_HOME.jsp");
                rd.forward(request, response);
            }
//            String nim = request.getParameter("nim");
//            String pass = request.getParameter("password");
//
//            if ((nim.equals("") && pass.equals("")) && ((nim.equals(null) && pass.equals(null)))) {
//                response.sendRedirect("Form_LoginErr.jsp");
//            }
//
//            Mahasiswa mhs = new Mahasiswa();
//            
//
//            mhs.setNim(nim);
//
//            if (MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(mhs) == true) {
//                System.out.println(MahasiswaKontrol.getKoneksiMahasiswa().LoginMahasiswa(mhs));
//                HttpSession session = request.getSession();
//                session.setAttribute("uname", nim);
//                session.setMaxInactiveInterval(900);
//                response.sendRedirect("W04_HOME_MABA.jsp");
//            } else {
//                response.sendRedirect("Form_LoginErr.jsp");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
