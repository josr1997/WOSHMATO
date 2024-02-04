<%@page import="nl.scalda.woshmato.models.Group"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<a href="indexGroup">Ga terug</a>
   <div class="col-lg-12">
            <h1>Team <%= request.getAttribute("teamName") %></h1>
            <h3>Coaches in dit team:</h3>
            <s:iterator value="teachers">
                            <s:property value="name"/> <s:property value="insertion"/> <s:property value="lastname"/><br>
            </s:iterator>
            <h3>Groepen in dit team:</h3>
            <s:iterator value="groups">
                            <s:property value="name"/> <s:property value="insertion"/> <s:property value="lastname"/><br>
            </s:iterator>
            
           <h3>Studenten in dit team:</h3><p>
            <s:iterator value="students">
                            <s:property value="name"/> <s:property value="insertion"/> <s:property value="lastname"/><br>
            </s:iterator>
   </div>
<%@include file="../../includes/footer.jsp" %>