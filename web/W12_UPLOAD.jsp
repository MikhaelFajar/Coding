<%-- 
    Document   : W12_UPLOAD
    Created on : Dec 16, 2014, 12:53:30 PM
    Author     : General
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISSIS</title>
    </head>
    <body>
        <form action="FetchDataAndFile.jsp" enctype="multipart/form-data" name="form1" id="form1" method="post">
            Upload Files:
            <input type="file" name="img1"><br>
            <input type="submit" name="submit" value="Upload">
        </form>
    </body>
</html>
