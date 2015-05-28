<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ISSIS</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
        <link href="newcss.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
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
                            <strong><h1>&nbsp&nbsp;INFORMASI&nbsp&nbsp;</h1></strong>
                        </legend>
                        <form action="LoginServlet" method="post">
                            <table border="0" align="left">
                                <td><strong>kelompok : </strong></td><td><input type="text" name="kelompok" size="20px"></input></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>Perlengkapan : </strong></td><td><input type="textarea" name="nim" size="80px"></input></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <!--                                <a href="file:///C:\Programs\sort.mw">Link 1</a>-->
                                <% String reportSource = request.getServletContext().getRealPath("/files/jarkom6.txt");%>
                                <a href="file:///<% out.print(reportSource); %>">click</a>
                            </table>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>