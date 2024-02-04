<%-- 
    Document   : HelloWorldStrutsTest
    Created on : 9-jun-2016, 13:10:12
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World!</title>
    </head>
    <body>
        <h1><s:property value="helloWorldInput" /></h1><!-- gets HomeAction.java's helloWorldInput. -->
    </body>
</html>
