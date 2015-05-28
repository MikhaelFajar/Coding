<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="control.PanitiaKontrol"%>
<%@page import="control.MahasiswaKontrol"%>
<%@page import="model.Mahasiswa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ISSIS</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
        <link href="newcss.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="script/jquery.tablesorter.js"></script>
        <script type="text/javascript" src="script/jquery.tablesorter.min.js"></script>
        <script type="text/javascript" src="script/jquery-latest.min.js"></script>
        <script type="text/javascript">
        </script>
        <style>
            #templatemo_banner input {
                float: left;
                display: block;
                height: 20px;
                padding: 1px 450px 1px 450px;
                margin: 0 0 0 30px;
                font-size: 14px;
                text-align: center;
                font-weight: bold;
                text-decoration: none;
                color: #074256;	
                outline: none;
            }
            table {border-collapse: collapse;}
            th {padding: 0 5em 0 0.5em;
                background-color: coral;
                border-top: 2px solid crimson;
                border-bottom: 2px solid crimson;
            }
            td {padding: 0 5em 0 0.5em;
                background-color: #FFC;
                border-top: 1px solid maroon;
            }
        </style>
    </head>
    <%
        Mahasiswa peserta = new Mahasiswa();
        peserta.setStatus("1");
        List<Mahasiswa> daftarPeserta = PanitiaKontrol.getKoneksiPanitia().lihatDaftarMahasiswa(peserta);
    %>
    <body>
        <div id="templatemo_site_title_bar_wrapper">
            <div id="templatemo_site_title_bar">
                <div id="site_title">
                    <img src="images/10x3.png" width="260" height="65"></img>
                </div>

                <div id="site_title_bar_right_section">
                    <div id="templatemo_menu">
                        <ul>
                            <li><a href="W05_HOME_PANITIA.jsp"><span></span>HOME</a></li>
                            <li><a href="W08_DAFTAR_LAMA.jsp"><span></span>DAFTAR</a></li>
                            <li><a href="W09_LIHAT_PESERTA.jsp"><span></span>PESERTA</a></li>
                            <li><a href="logoutPanitia.jsp"><span></span>LOGOUT</a></li>
                        </ul>
                    </div>
                </div>        
            </div>        
        </div>

        <div id="templatemo_banner_wrapper">
            <div id="templatemo_banner">
                <fieldset style=" width: 1000px; margin: 0px auto;">
                    <legend align="left">
                        <strong><h1>&nbsp&nbsp;DAFTAR PESERTA PINISSI&nbsp&nbsp;</h1></strong>
                    </legend>
                    <form action="cobaCetak" method="post">
                        <table id="myTable" class="tablesorter" align="center" width="50%" >
                            <br></br>
                            <thead>
                                <tr>
                                    <th>NIM</th>
                                    <th>NAMA</th>
                                    <th>ALAMAT</th>
                                    <th>JURUSAN</th>
                                    <th>KELOMPOK</th>
                                    <th>ALERGI</th>
                                    <th>PENYAKIT</th>
                                    <th>KONSUMSI</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 0; i < daftarPeserta.size(); i++) {
                                        String nim = daftarPeserta.get(i).getNim();
                                %>

                                <tr>
                                    <td align="center" ><% out.print(daftarPeserta.get(i).getNim());%></td>
                                    <td><% out.print(daftarPeserta.get(i).getNama());%></td>
                                    <td><% out.print(daftarPeserta.get(i).getAlamat());%></td>
                                    <td><% out.print(daftarPeserta.get(i).getProdi());%></td>
                                    <td align="center"><% out.print(daftarPeserta.get(i).getKelompok());%></td>
                                    <td align="center">
                                        <ul>
                                            <%
                                                Mahasiswa mhs = new Mahasiswa();
                                                mhs.setNim(nim);
                                                MahasiswaKontrol m = new MahasiswaKontrol(koneksi.Koneksi.getKoneksiHome());
                                                ResultSet reset = m.tampilAlergi(mhs);
                                                while (reset.next()) {%>
                                            <li><%out.println(reset.getString("namaalergi"));%></li><%
                                                }
                                            %>
                                        </ul>
                                    </td>
                                    <td align="center">
                                        <ul>
                                            <%
                                                ResultSet rs;
                                                rs = MahasiswaKontrol.getKoneksiMahasiswa().tampilPenyakit(mhs);
                                                while (rs.next()) {
                                            %>
                                            <li><% out.println(rs.getString("namapenyakit"));%></li><%}%>
                                        </ul>
                                    </td>
                                    <td><% out.print(daftarPeserta.get(i).getKonsumsi());%></td>
                                </tr>
                                <% }%>
                                <td colspan="8" align="center"><input type="submit" name="input" value="CETAK"</input></td>
                            </tbody>
                        </table>   
                    </form>
                </fieldset>
            </div>
        </div>
    </body>
</html>