<%-- 
    Document   : testable
    Created on : Dec 9, 2014, 7:12:01 PM
    Author     : General
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="script/jquery.tablesorter.js"></script>
        <script type="text/javascript" src="script/jquery-latest.min.js"></script>
        <script type="text/javascript" src="script/jquery.tablesorter.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() 
            { 
                $("#myTable").tablesorter(); 
            } 
        ); 
        </script>

        <title>JSP Page</title>
    </head>
    <body>
        <table id="myTable" class="tablesorter" align="center" width="100%" >
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
                                <tr>
                                    <td align="center" >125314032</td>
                                    <td>fajar</td>
                                    <td>kandang</td>
                                    <td>TI</td>
                                    <td align="center">3</td>
                                    <td align="center">apaaja</td>
                                    <td align="center">apaaja</td>
                                    <td>non</td>
                                </tr>
                                <tr>
                                    <td align="center" >125314100</td>
                                    <td>chandra</td>
                                    <td>jalan</td>
                                    <td>TM</td>
                                    <td align="center">10</td>
                                    <td align="center">bpaaja</td>
                                    <td align="center">bpaaja</td>
                                    <td>vege</td>
                                </tr>
                            </tbody>
                        </table>
<!--        <table id="myTable" class="tablesorter"> 
            <thead> 
                <tr> 
                    <th>Last Name</th> 
                    <th>First Name</th> 
                    <th>Email</th> 
                    <th>Due</th> 
                    <th>Web Site</th> 
                </tr> 
            </thead> 
            <tbody> 
                <tr> 
                    <td>Smith</td> 
                    <td>John</td> 
                    <td>jsmith@gmail.com</td> 
                    <td>$50.00</td> 
                    <td>http://www.jsmith.com</td> 
                </tr> 
                <tr> 
                    <td>Bach</td> 
                    <td>Frank</td> 
                    <td>fbach@yahoo.com</td> 
                    <td>$50.00</td> 
                    <td>http://www.frank.com</td> 
                </tr> 
                <tr> 
                    <td>Doe</td> 
                    <td>Jason</td> 
                    <td>jdoe@hotmail.com</td> 
                    <td>$100.00</td> 
                    <td>http://www.jdoe.com</td> 
                </tr> 
                <tr> 
                    <td>Conway</td> 
                    <td>Tim</td> 
                    <td>tconway@earthlink.net</td> 
                    <td>$50.00</td> 
                    <td>http://www.timconway.com</td> 
                </tr> 
            </tbody> 
        </table> -->
    </body>
</html>
