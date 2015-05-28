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
    </head>
    <style>
        .service_box input {
            float: left;
            display: block;
            height: 20px;
            padding: 2px 10px 0 5px;
            margin: 0 0 0 30px;
            font-size: 14px;
            text-align: left;
            font-weight: bold;
            text-decoration: none;
            color: #074256;	
            outline: none;
        }
    </style>
    <body>
        <div id="templatemo_site_title_bar_wrapper">
            <div id="templatemo_site_title_bar">
                <div id="site_title">
                    <img src="images/10x3.png" width="260" height="65"></img>
                </div>

                <div id="site_title_bar_right_section">
                    <div id="templatemo_menu">
                        <ul>
                            <li><a href="W01_HOME.jsp"><span></span>HOME</a></li>
                            <li><a href="W02_LOGIN_MABA.jsp"><span></span>MAHASISWA</a></li>
                            <li><a href="W03_LOGIN_PANITIA.jsp"><span></span>PANITIA</a></li>
                        </ul>
                    </div>
                </div>        
            </div>        
        </div>

        <div id="templatemo_banner_wrapper">
            <div id="templatemo_banner">
                <div class="service_box">
                    <fieldset style="width: 400px; margin:  50px auto;">
                        <legend align="left">
                            <strong><h1>&nbsp&nbsp;LOGIN MAHASISWA&nbsp&nbsp;</h1></strong>
                        </legend>
                        <form action="LoginControl" method="post">
                            <table border="0" align="center">
                                <td><strong>NIM</strong></td><td><input type="text" name="nim"></input></td><tr></tr>
                                <td colspan="2"></td><tr></tr>
                                <td><strong>PASSWORD</strong></td><td><input type="password" name="pass"></input></td><tr></tr>
                                <td colspan="2" align="center">
                                    <input type="submit" name="input" value="LOGIN"></input></td>
                                <tr></tr>
                            </table>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>