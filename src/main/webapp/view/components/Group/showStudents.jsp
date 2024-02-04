<%@page import="nl.scalda.woshmato.models.Group"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<a href="indexGroup">Ga terug</a>
   <div class="col-lg-12">
            <h1>Groep <%= request.getAttribute("groupName") %></h1>
            <h3>Team:</h3>
            <%= request.getAttribute("groupTeam") %>
            <h3>Coach:</h3>
            <%= request.getAttribute("groupTeacher") %>
            
            <h3>Studenten in deze groep:</h3><p>
            <s:iterator value="studentList">
                            <s:property value="name"/> <s:property value="insertion"/> <s:property value="lastname"/><br>
            </s:iterator>
   </div>
<%@include file="../../includes/footer.jsp" %>