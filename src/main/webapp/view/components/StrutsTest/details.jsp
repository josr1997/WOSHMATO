<%-- 
    Document   : details
    Created on : 9-jun-2016, 11:14:19
    Author     : kevin
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>
        <title>Struts Details</title>
    </head>
    <body>
    <center>

        <h2>User Details</h2>
        <br /> <br />
        <table>
            <tr>
                <td>First Name:</td>
                <td><s:property value="firstName" />
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><s:property value="lastName" />
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><s:property value="email" />
                </td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><s:property value="phone" />
                </td>
            </tr>
        </table>
                <br>
                <s:form action="HelloWorldStruts" method="POST">
   <s:textfield name="helloWorldInput" label="Hello World Input" /><!-- sets HomeAction.java's variable helloWorldInput. -->
   <s:submit />
  </s:form>
    </center>
</body>
</html>
