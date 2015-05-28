/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Mahasiswa;

/**
 *
 * @author General
 */
public class PanitiaKontrol {

    private Connection conn;

    public PanitiaKontrol(Connection koneksi) {
        this.conn = koneksi;
    }

    public static PanitiaKontrol getKoneksiPanitia() throws SQLException {
        PanitiaKontrol kon = new PanitiaKontrol(koneksi.Koneksi.getKoneksiHome());
        return kon;
    }

    public boolean LoginAdmin(String keyword) throws SQLException {
        PreparedStatement prestat = null;
        ResultSet rset = null;
        try {
            String query = "Select idadmin,passadmin from pinissi where idadmin=? ";
            prestat = conn.prepareStatement(query);
            prestat.setString(1, keyword);
            rset = prestat.executeQuery();

            while (rset.next()) {
                rset.getString("idadmin");
                rset.getString("passadmin");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (prestat != null) {
                    prestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public List<Mahasiswa> lihatDaftarMahasiswa(Mahasiswa keyword) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conn.setAutoCommit(false);
            statement = conn.prepareStatement("select nim, konsumsi, nokelompok, nama, prodi, alamat "
                    + "from mahasiswa where status= ? order by prodi, nim");
            statement.setString(1, keyword.getStatus());
            result = statement.executeQuery();
            List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
            while (result.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(result.getString("nim"));
                mhs.setNama(result.getString("nama"));
                mhs.setAlamat(result.getString("alamat"));
                mhs.setKonsumsi(result.getString("konsumsi"));
                mhs.setKelompok(result.getString("nokelompok"));
                mhs.setProdi(result.getString("prodi"));
                mahasiswa.add(mhs);
            }

            conn.commit();
            return mahasiswa;
        } catch (SQLException exception) {
            throw exception;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException exception) {
                throw exception;
            }
        }
    }

    public void insertMahasiswaLama(Mahasiswa keyword) throws SQLException {
        PreparedStatement prestat = null;
        ResultSet rset = null;
        try {
            String query = "insert into mahasiswa(nim, konsumsi, tahunpenyelenggaraan, "
                    + "nokelompok, nama, alamat, status, password, prodi)"
                    + " values (?,?,?,?,?,?,?,?,?)";
            prestat = conn.prepareStatement(query);
            prestat.setString(1, keyword.getNim());
            prestat.setString(2, keyword.getKonsumsi());
            prestat.setString(3, keyword.getTahun());
            prestat.setString(4, keyword.getKelompok());
            prestat.setString(5, keyword.getNama());
            prestat.setString(6, keyword.getAlamat());
            prestat.setString(7, keyword.getStatus());
            prestat.setString(8, keyword.getPassword());
            prestat.setString(9, keyword.getProdi());
            prestat.executeUpdate();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (prestat != null) {
                    prestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
}
