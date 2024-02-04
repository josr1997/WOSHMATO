<%-- 
    Document   : processTeam
    Created on : 1-jun-2016, 13:42:40
    Author     : Jeroen
--%>
<%@page import="nl.scalda.woshmato.datalayer.*" %>
<%@page import="nl.scalda.woshmato.models.Team" %>
<%
System.out.println(request);
//System.out.println(request.getParameter("name"));

//Team t = new Team(request.getParameter("name"), 1);
//DAOTeam.getInstance().createTeam(t, 1);

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Team</title>
    </head>
    <body>
        <p>${groupids}</p>
    </body>
</html>