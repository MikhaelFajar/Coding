<%-- 
    Document   : logout
    Created on : Nov 28, 2014, 11:15:51 AM
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
        <%
            if (session.getAttribute("nim") != null) {
                session.removeAttribute("nim");
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("W01_HOME.jsp");
                rd.forward(request, response);
            }
        %>
    </body>
</html>
