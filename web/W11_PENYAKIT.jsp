<%-- 
    Document   : W10_PENYAKIT
    Created on : Nov 16, 2014, 12:51:41 PM
    Author     : CORE
--%>

<%@page import="java.util.List"%>
<%@page import="model.RiwayatPenyakit"%>
<%@page import="control.MahasiswaKontrol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="newcss.css" rel="stylesheet" type="text/css" />
        <title>ISSIS</title>
        <style>
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
    String uName=(String)session.getAttribute("nim");
    String nimPeserta=(String)session.getAttribute("nimPeserta");
    List<RiwayatPenyakit> penyakit= MahasiswaKontrol.getKoneksiMahasiswa().lihatPenyakit();
    %>
    <body>
        <div id="templatemo_site_title_bar_wrapper">
            <div id="templatemo_site_title_bar">
                <div id="site_title">
                    <img src="images/10x3.png" width="260" height="65"></img>
                </div>
            </div>        
        </div>
        
        <div id="templatemo_banner_wrapper">
            <div id="templatemo_banner">
                <fieldset style="width: 500px; margin:  20px auto;">
                    <legend align="left">
                        <strong><h1>&nbsp&nbsp;DAFTAR PENYAKIT&nbsp&nbsp;</h1></strong>
                    </legend>
                    <form action="PenyakitControl" method="post">
                        <table border="0" align="center">
                            <br>
                            <th><strong>KODE PENYAKIT</strong></th><th><strong>NAMA PENYAKIT</strong></th><th></th>
                            <tr></tr>
                            <% for(int i=0; i<penyakit.size(); i++){
                                
                            %>
                            <td><strong><% out.print(penyakit.get(i).getKodepenyakit()); %></strong></td><td><strong><% out.print(penyakit.get(i).getNamapenyakit()); %></strong></td><td>
                                <input type="checkbox" name="kdPenyakit" value="<% out.print(penyakit.get(i).getKodepenyakit()); %>"></td>
                            <tr></tr>
                            <% } %>
                            <tr></tr><tr></tr>
                            <td></td><td></td>
                            <td><input align="center" type="submit" value="TAMBAHKAN"</td>
                        </table>
                    </form>
                </fieldset>
            </div>
        </div>
    </body>
</html>
