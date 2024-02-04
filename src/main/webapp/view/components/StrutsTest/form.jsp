<%-- 
    Document   : form
    Created on : 9-jun-2016, 11:12:49
    Author     : kevin
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>

<html>
<head>
<title>Struts Form</title>
</head>
<body>
 <center>

  <h2>Registration Form</h2>
  <br /> <br />
  <form:form action="details">
   <form:textfield name="firstName" label="First Name: " />
   <form:textfield name="lastName" label="Last Name: " />
   <form:textfield name="email" label="Email: " />
   <form:textfield name="phone" label="Phone: " />
   <form:submit />
  </form:form>
 </center>
</body>
</html>
