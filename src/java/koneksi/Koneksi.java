/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author General
 */
public class Koneksi {

   static String url="", userID="", passwd="";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public static Connection getKoneksiBaru() {
        Connection conn = null;
   
        OracleDataSource ds;
        try {
            ds = new OracleDataSource();
            ds.setURL(url);
            conn = ds.getConnection(userID, passwd);
            System.out.println("Koneksi is Ok");
        } catch (SQLException ex) {
            System.out.println("error detect: " + ex.getMessage());
        }
        return conn;
    }
    
    public static Connection getKoneksi() {
        Koneksi kn=new Koneksi();
        String url = "jdbc:Oracle:thin:@172.23.9.185:1521:orcl";
        String userID = "mhs125314029";
        String passwd = "mhs125314029";
        Connection conn = null;

        OracleDataSource ds;
        try {
            ds = new OracleDataSource();
//            ds.setURL(kn.getUrl());
            ds.setURL(url);
//            conn = ds.getConnection(kn.getUserID(), kn.getPasswd());
            conn=ds.getConnection(userID,passwd);
            System.out.println("Koneksi is Ok");
        } catch (SQLException ex) {
            System.out.println("error detect: " + ex.getMessage());
        }
        return conn;
    }
    
//    public static Connection getKoneksiSQL() {
//        Koneksi kn=new Koneksi();
//        String url = "jdbc:mysql:thin:@localhost:1521:xe";
//        String userID = "root";
//        String passwd = "root";
//        Connection conn = null;
//
//        DriverManager ds;
//        try {
//            ds = new Oracle();
////            ds.setURL(kn.getUrl());
//            ds.setURL(url);
////            conn = ds.getConnection(kn.getUserID(), kn.getPasswd());
//            conn=ds.getConnection(userID,passwd);
//            System.out.println("Koneksi is Ok");
//        } catch (SQLException ex) {
//            System.out.println("error detect: " + ex.getMessage());
//        }
//        return conn;
//    }
    
    public static Connection getKoneksiHome() {
        Koneksi kn=new Koneksi();
        String url = "jdbc:Oracle:thin:@localhost:1521:xe";
        String userID = "hr";
        String passwd = "hr";
        Connection conn = null;

        OracleDataSource ds;
        try {
            ds = new OracleDataSource();
            ds.setURL(url);
            conn=ds.getConnection(userID,passwd);
            System.out.println("Koneksi is Ok");
        } catch (SQLException ex) {
            System.out.println("error detect: " + ex.getMessage());
        }
        return conn;
    }

}
