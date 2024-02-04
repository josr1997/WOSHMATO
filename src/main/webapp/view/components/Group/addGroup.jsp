<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<link href="resources/css/StrutsStyling.css" rel="stylesheet" type="text/css"/>
<div class="col-lg-12">
    <s:form action="addGroup" method="POST">
        <h1>Groep toevoegen</h1>
        <s:textfield id="groupName" name="groupName" type="text" label="Naam van de groep"/><p>
        <s:select list="teamList" listValue="%{id + ' ' +  name}" name="team" label="team" id="team" headerValue="Selecteer een team" headerKey="0"/><p>
        <s:select list="teacherList" listValue="%{id + ' ' + name + ' ' + insertion + ' ' + lastname}" name="teacher" label="coach" id="teacher" headerValue="Selecteer een coach" headerKey="0"/><p>
        <s:submit value="verzenden" class="submitBtnStyle"/><p>
        </s:form>
        <a href="indexGroup" class="goBackBtnStyle">Ga terug</a>
</div>
<script src="resources/js/Content.js"></script>
<%@include file="../../includes/footer.jsp" %>