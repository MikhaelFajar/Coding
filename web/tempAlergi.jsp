<%-- 
    Document   : tempAlergi
    Created on : Nov 29, 2014, 11:48:19 AM
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
            String nimPeserta = request.getParameter("nimPeserta");
            HttpSession session1 = request.getSession();
            session1.setAttribute("nimPeserta", nimPeserta);
            RequestDispatcher rd = request.getRequestDispatcher("W10_ALERGI.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
