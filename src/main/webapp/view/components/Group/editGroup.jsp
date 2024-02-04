<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<link href="resources/css/StrutsStyling.css" rel="stylesheet" type="text/css"/>
<div class="col-lg-12">
    <s:form action="editGroup" method="POST">
        <h1>Groep wijzigen</h1>
        <s:textfield type="hidden" id="groupId" name="groupId" value="%{#attr.groupId}"/> 
        <s:textfield type="hidden" id="hiddenTeam" name="hiddenTeam" value="%{#attr.groupTeam}"/>
        <s:textfield type="hidden" id="hiddenTeacher" name="hiddenTeacher" value="%{#attr.groupTeacher}"/>
        <s:textfield id="groupName" name="groupName" type="text" label="Naam van de groep" value="%{#attr.groupName}"/><p>
        <s:select list="teamList" listValue="%{id + ' ' +  name}" name="team" label="Team" id="team"/><p>
        <s:select list="teacherList" listValue="%{id + ' ' + name + ' ' + insertion + ' ' + lastname}" name="teacher" label="Coach" id="teacher" headerValue="Selecteer een coach" headerKey="0"/><p>
        <s:textfield id="groupArchived" name="groupArchived" type="number" maxLength="1" size="1" value="%{#attr.groupArchived}" label="Gearchiveerd"/><p>
        <s:submit value="verzenden" class="submitBtnStyle"/><p>
        </s:form>
        <a href="indexGroup" class="goBackBtnStyle">Ga terug</a>
</div>
<script src="resources/js/Content.js"></script>
<script src="resources/js/Group.js"></script>
<%@include file="../../includes/footer.jsp" %>