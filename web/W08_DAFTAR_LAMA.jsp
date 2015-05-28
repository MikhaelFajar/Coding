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
        </style>
    </head>
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
                <div class="service_box">
                    <fieldset style="width: 800px; margin:  20px auto;">
                        <legend align="left">
                            <strong><h1>&nbsp&nbsp;INPUT DATA MAHASISWA&nbsp&nbsp;</h1></strong>
                        </legend>
                        <form action="DaftarLamaControl" method="post">
                            <table border="0" align="left">
                                <!--                                <td><strong> apakah anda ingin mengikuti PINISSI ?</strong></td><td><input type="checkbox" name="checkya" op><label><strong>YA</strong></label></td><tr></tr>-->
                                <td colspan="2"></td><tr></tr>
                                <%if (session.getAttribute("nimPeserta") == null
                                            || session.getAttribute("namaPeserta") == null
                                            || session.getAttribute("alamatPeserta") == null
                                            || session.getAttribute("pilihjurusan") == null){
                                    String sessionInput = "";
                                    %>                                
                                <td><strong>NIM</strong></td><td><input type="text" name="nimPeserta" size="20px" value="<% sessionInput.toString(); %>"></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>NAMA</strong></td><td><input type="text" name="namaPeserta" size="70px" value="<% sessionInput.toString(); %>"></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>ALAMAT</strong></td><td><input type="text" name="alamatPeserta" size="70px" value="<% sessionInput.toString(); %>"></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>JURUSAN</strong></td><td><select name="pilihjurusan">
                                        <option value="Teknik Informatika">TEKNIK INFORMATIKA
                                        </option>
                                        <option value="Teknik Elektro">TEKNIK ELEKTRO
                                        </option>
                                        <option value="Teknik Mesin">TEKNIK MESIN
                                        </option>
                                        <option value="Matematika Murni">MATEMATIKA MURNI
                                        </option>
                                    </select></td>
                                <% }else { %>
                                    <td><strong>NIM</strong></td><td><input type="text" name="nimPeserta" size="20px" value="<%=session.getAttribute("nimPeserta")%>"></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>NAMA</strong></td><td><input type="text" name="namaPeserta" size="70px" value="<%=session.getAttribute("namaPeserta")%>"></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>ALAMAT</strong></td><td><input type="text" name="alamatPeserta" size="70px" value="<%=session.getAttribute("alamatPeserta")%>"></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>JURUSAN</strong></td><td><select name="pilihjurusan">
                                        <option><%out.print(session.getAttribute("pilihjurusan"));%>
                                        </option>
<!--                                        <option value="te">TEKNIK ELEKTRO
                                        </option>
                                        <option value="tm">TEKNIK MESIN
                                        </option>
                                        <option value="mm">MATEMATIKA MURNI
                                        </option>-->
                                    </select></td>
                                <%}%>
                                <tr></tr>
                                <td colspan="2"></td><tr></tr>                   
                                <td><strong>ALERGI</strong></td>
                                <td>
                                    <form action="DaftarLamaControl" method="post">
                                        <input type="submit" name="process" value="PILIH ALERGI"></input>
                                    </form>
                                </td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>RIWAYAT PENYAKIT</strong></td>
                                <td>                
                                    <input type="submit" name="process" value="PILIH PENYAKIT"></input>                                   
                                </td><tr></tr>
                                <td colspan="2"></td><tr></tr>                                
                                <td><strong>KONSUMSI</strong></td><td>
                                    <input type="radio" name="konsumsi" value="Vege">VEGE</input>
                                    <input type="radio" name="konsumsi" value="Non-Vege">NON-VEGE</input>
                                </td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td colspan="2" align="center">
                                    <input onclick="Alert.render('SELAMAT ANDA TELAH TERDAFTAR')" type="submit" name="process" value="DAFTAR"></td>            
                                <tr></tr>
                            </table>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>