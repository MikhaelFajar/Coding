<%@page import="model.Mahasiswa"%>
<%@page import="control.MahasiswaKontrol"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ISSIS</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
        <link href="newcss.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
            function Customalert(){
                this.render = function(dialog){
                    var winW = window.innerWidth;
                    var winH = window.innerHeight;
                    var dialogoverlay = document.getElementById('dialogoverlay');
                    var dialogbox = document.getElementById('dialogbox');
                    dialogoverlay.style.display = "block";
                    dialogoverlay.style.height = winH+"px";
                    dialogbox.style.left = (winW/2) - (550 * .5)+"px";
                    dialogbox.style.top = "100px";
                    dialogbox.style.display = "block";
                    document.getElementById('dialogboxhead').innerHTML = "ALERT";
                    document.getElementById('dialogboxbody').innerHTML = dialog;
                    document.getElementById('dialogboxfoot').innerHTML = '<button onclick="alert.ok()">OK</button>';
                }
                this.ok = function(){
                    document.getElementById('dialogbox').style.display = "none";
                    document.getElementById('dialogoverlay').style.display = "none";
                }
            }
            var Alert = new Customalert();
        </script>
        <style type="text/css">
            #dialogoverlay{
                display: none;
                opacity: .8;
                position: fixed;
                top: 0px;
                left: 0px;
                background: #FFF;
                width: 100%;
                z-index: 10;
            }
            #dialogbox{
                display: none;
                position: fixed;
                background: #000;
                border-radius: 7px;
                width: 550px;
                z-index: 10;
            }
            #dialogbox > div{background: #FFF; margin: 8px; }
            #dialogbox > div > #dialogboxhead{background: #666; font-size: 19px; padding: 10px; color: #CCC;}
            #dialogbox > div > #dialogboxbody{background: #333; padding: 20px; color: #FFF;}
            #dialogbox > div > #dialogboxfoot{background: #666; padding: 10px; text-align: right;}

            .service_box a{
                float: left;
                display: block;
                height: 20px;
                padding: 2px 10px 0 5px;
                margin: 0 0 0 30px;
                font-size: 14px;
                text-align: center;
                font-weight: bold;
                text-decoration: none;
                color: #074256;
                outline: none;
            }
        </style>
    </head>
    <%
        String uName = (String) session.getAttribute("nim");
        String nimPeserta = (String) session.getAttribute("nimPeserta");
        Mahasiswa mhs = new Mahasiswa();
        if (uName != null) {
            mhs.setNim(uName);
        }
        if (nimPeserta != null) {
            mhs.setNim(nimPeserta);
        }
        String nama = MahasiswaKontrol.getKoneksiMahasiswa().tampilDataMahasiswa(mhs).getNama();
        String nim = MahasiswaKontrol.getKoneksiMahasiswa().tampilDataMahasiswa(mhs).getNim();
        String alamat = MahasiswaKontrol.getKoneksiMahasiswa().tampilDataMahasiswa(mhs).getAlamat();
        String jurusan = MahasiswaKontrol.getKoneksiMahasiswa().tampilDataMahasiswa(mhs).getProdi();
    %>
    <body>
        <div id="dialogoverlay"></div>
        <div id="dialogbox">
            <div>
                <div id="dialogboxhead"></div>
                <div id="dialogboxbody"></div>
                <div id="dialogboxfoot"></div>                
            </div>
        </div>
        <div id="templatemo_site_title_bar_wrapper">
            <div id="templatemo_site_title_bar">
                <div id="site_title">
                    <img src="images/10x3.png" width="260" height="65"></img>
                </div>

                <div id="site_title_bar_right_section">

                    <div id="templatemo_menu">
                        <ul>
                            <li><a href="W04_HOME_MABA.jsp"><span></span>HOME</a></li>
                            <li><a href="W06_DAFTAR_BARU.jsp"><span></span>DAFTAR</a></li>
                            <li><a href="W07_LIHAT_INFORMASI.jsp"><span></span>INFORMASI</a></li>
                            <li><a href="logout.jsp"><span></span>LOGOUT</a></li>
                        </ul>
                    </div>
                </div>        
            </div>
        </div>

        <div id="templatemo_banner_wrapper">
            <div id="templatemo_banner">
                <div class="service_box">
                    <fieldset style="width: 800px; margin:  20px auto;">
                        <legend align="left">
                            <strong><h1>&nbsp&nbsp;INPUT DATA MAHASISWA&nbsp&nbsp;</h1></strong>
                        </legend>
                        <form action="ConfirmasiMahasiswaControl" method="post">
                            <table border="0" align="left">
                                <td colspan="4"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>NIM</strong></td><td>&nbsp&nbsp&nbsp;</td><td><% out.print(nim);%></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>NAMA</strong></td><td>&nbsp&nbsp&nbsp;</td><td><% out.print(nama);%></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>ALAMAT</strong></td><td>&nbsp&nbsp&nbsp;</td><td><% out.print(alamat);%></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>JURUSAN</strong></td><td>&nbsp&nbsp&nbsp;</td><td><% out.print(jurusan);%></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>ALERGI</strong></td><td>&nbsp&nbsp&nbsp;</td>
                                <td><a href="W10_ALERGI.jsp" >PILIH</a></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>RIWAYAT PENYAKIT</strong></td><td>&nbsp&nbsp&nbsp;</td>
                                <td><a href="W11_PENYAKIT.jsp">PILIH</a></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;</td><td><strong>KONSUMSI</strong></td><td>&nbsp&nbsp&nbsp;</td><td>
                                    <input type="checkbox" name="konsumsi" value="Vege">vege</input>
                                    <input type="checkbox" name="konsumsi" value="Non-Vege">non - vege</input>
                                </td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td colspan="2" align="center"><input onclick="Alert.render('SELAMAT ANDA TELAH TERDAFTAR')" type="submit" name="input" value="DAFTAR"></td>
                                <tr></tr>
                            </table>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>