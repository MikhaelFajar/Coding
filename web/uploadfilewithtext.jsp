<%-- 
    Document   : uploadfilewithtext
    Created on : Dec 16, 2014, 7:38:53 PM
    Author     : General
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FetchDataAndFile.jsp" enctype="multipart/form-data" name="form1" id="form1" method="post">
            First Text:<input type="text" name="firsttext"><br>
            Second Text:<input type="text" name="secondtext"><br>
            First Image:<input type="file" name="img1"><br>
            Second Image:<input type="file" name="img2"><br>
            Third Text:<input type="text" name="thirdtext"><br>
            <input type="submit" name="submit" value="Submit Product">
        </form>
    </body>
</html>
