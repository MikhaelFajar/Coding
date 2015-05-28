/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Alergi;
import model.Derita;
import model.Idap;
import model.Mahasiswa;
import model.RiwayatPenyakit;
import org.eclipse.jdt.internal.compiler.ast.WhileStatement;

/**
 *
 * @author General
 */
public class MahasiswaKontrol {

    private Connection conn;

    public MahasiswaKontrol(Connection koneksi) {
        this.conn = koneksi;
    }

    public static MahasiswaKontrol getKoneksiMahasiswa() throws SQLException {
        MahasiswaKontrol kon = new MahasiswaKontrol(koneksi.Koneksi.getKoneksiHome());
        return kon;
    }

    public Mahasiswa tampilDataMahasiswa(Mahasiswa keyword) throws SQLException {
        PreparedStatement preparestatCari = null;
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            String sql = "select nim,nama,alamat,prodi"
                    + " From mahasiswa "
                    + "where nim=?";
            preparestatCari = conn.prepareStatement(sql);
            preparestatCari.setString(1, keyword.getNim());
            rs = preparestatCari.executeQuery();
            Mahasiswa mhs = new Mahasiswa();
            if (rs.next()) {
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setAlamat(rs.getString("alamat"));
                mhs.setProdi(rs.getString("prodi"));
            }
            return mhs;
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestatCari != null) {
                    preparestatCari.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public void updateDataKonsumsi(Mahasiswa keyword) throws SQLException {
        PreparedStatement preparestat = null;
        try {
            conn.setAutoCommit(true);
            String sql = "update mahasiswa set konsumsi=? , status=? "
                    + "where nim=?";
            preparestat = conn.prepareStatement(sql);
            preparestat.setString(1, keyword.getKonsumsi());
            preparestat.setString(2, keyword.getStatus());
            preparestat.setString(3, keyword.getNim());
            preparestat.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestat != null) {
                    preparestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

//    public void updateStatus(Mahasiswa keyword) throws SQLException {
//        PreparedStatement preparestat = null;
//        try {
//            conn.setAutoCommit(true);
//            String sql = "update into mahasiswa set status=1 "
//                    + "where nim=?";
//            preparestat = conn.prepareStatement(sql);
//            preparestat.setString(1, keyword.getNim());
//            preparestat.executeUpdate();
//            conn.commit();
//        } catch (SQLException ex) {
//            conn.rollback();
//            throw ex;
//        } finally {
//            try {
//                conn.setAutoCommit(true);
//                if (preparestat != null) {
//                    preparestat.close();
//                }
//            } catch (SQLException ex) {
//                throw ex;
//            }
//        }
//    }
    public boolean LoginMahasiswa(String keyword) throws SQLException {
        PreparedStatement prestat = null;
        ResultSet rset = null;
        try {
            String query = "Select nim,password from mahasiswa where nim=? ";
            prestat = conn.prepareStatement(query);
            prestat.setString(1, keyword);
            rset = prestat.executeQuery();
            System.out.println(rset.toString());
            while (rset.next()) {
                rset.getString("Nim");
                rset.getString("password");
                System.out.println("cek login");
                return true;
            }
            System.out.println("cek dua");
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

    public List<Alergi> lihatAlergi() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conn.setAutoCommit(false);
            statement = conn.prepareStatement("select kodealergi, namaalergi "
                    + "from alergi");
            result = statement.executeQuery();
            List<Alergi> alergi = new ArrayList<Alergi>();
            while (result.next()) {
                Alergi ale = new Alergi();
                ale.setKodeAlergi(result.getString("kodealergi"));
                ale.setNamaAlergi(result.getString("namaalergi"));
                alergi.add(ale);
            }

            conn.commit();
            return alergi;
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

    public List<RiwayatPenyakit> lihatPenyakit() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conn.setAutoCommit(false);
            statement = conn.prepareStatement("select kodepenyakit, namapenyakit "
                    + "from riwayatpenyakit");
            result = statement.executeQuery();
            List<RiwayatPenyakit> rPenyakit = new ArrayList<RiwayatPenyakit>();
            while (result.next()) {
                RiwayatPenyakit pnykt = new RiwayatPenyakit();
                pnykt.setKodepenyakit(result.getString("kodepenyakit"));
                pnykt.setNamapenyakit(result.getString("namapenyakit"));
                rPenyakit.add(pnykt);
            }

            conn.commit();
            return rPenyakit;
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

    public void updateAlergi(Mahasiswa keyword) throws SQLException {
        PreparedStatement preparestat = null;
        try {
            conn.setAutoCommit(true);
            String sql = "update mahasiswa set alergi=? "
                    + "where nim=?";
            preparestat = conn.prepareStatement(sql);
            preparestat.setString(1, keyword.getAlergi());
            preparestat.setString(2, keyword.getNim());
            preparestat.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestat != null) {
                    preparestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public void updatePenyakit(Mahasiswa keyword) throws SQLException {
        PreparedStatement preparestat = null;
        try {
            conn.setAutoCommit(true);
            String sql = "update mahasiswa set penyakit=? "
                    + "where nim=?";
            preparestat = conn.prepareStatement(sql);
            preparestat.setString(1, keyword.getPenyakit());
            preparestat.setString(2, keyword.getNim());
            preparestat.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestat != null) {
                    preparestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public void confirmAlergi(Idap idap) throws SQLException {
        PreparedStatement preparestat = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into idap (kodealergi, nim)"
                    + " values (?,?)";
            preparestat = conn.prepareStatement(sql);
            preparestat.setString(1, idap.getKodeAlergi());
            preparestat.setString(2, idap.getNim());
            preparestat.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestat != null) {
                    preparestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public void confirmPenyakit(Derita keyword) throws SQLException {
        PreparedStatement preparestat = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into derita (kodepenyakit, nim)"
                    + " values (?,?)";
            preparestat = conn.prepareStatement(sql);
            preparestat.setString(1, keyword.getKodePenyakit());
            preparestat.setString(2, keyword.getNim());
            preparestat.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestat != null) {
                    preparestat.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public ResultSet tampilAlergi(Mahasiswa keyword) throws SQLException {
        PreparedStatement preparestatCari = null;
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            String sql = "select namaalergi "
                    + "from alergi inner join idap on idap.kodealergi = alergi.kodealergi "
                    + "where idap.nim=?";
            preparestatCari = conn.prepareStatement(sql);
            preparestatCari.setString(1, keyword.getNim());
            rs = preparestatCari.executeQuery();
//            while(rs.next()){
//                alergi=rs.getString("namaalergi");
//            }
            return rs;
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestatCari != null) {
                    // preparestatCari.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public ResultSet tampilPenyakit(Mahasiswa keyword) throws SQLException {
        PreparedStatement preparestatCari = null;
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            String sql = "select namapenyakit "
                    + "from riwayatpenyakit inner join derita on derita.kodepenyakit = riwayatpenyakit.kodepenyakit "
                    + "where derita.nim=?";
            preparestatCari = conn.prepareStatement(sql);
            preparestatCari.setString(1, keyword.getNim());
            rs = preparestatCari.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("namapenyakit"));                
//            }
            return rs;
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (preparestatCari != null) {
                    // preparestatCari.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
}
