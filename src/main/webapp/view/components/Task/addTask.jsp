<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<link href="resources/css/StrutsStyling.css" rel="stylesheet" type="text/css"/>
<div class="col-lg-12">
    <h1>Taak toevoegen</h1>
    <form action="addTask" class="whiteSpace">
        <s:textfield id="taskName" name="taskName" type="text" label="Naam van de taak"/><br/>
        <s:textfield id="taskDescription" name="taskDescription" type="text" label="Beschrijving"/><br/>
        <s:textfield id="taskLessonHours" name="taskLessonHours" type="text" label="Lesuren"/><br/>
        <s:textfield id="taskClockHours" name="taskClockHours" type="text" label="Klokuren"/><br/>
        <s:select onchange="categorySelect()" list="categoriesList" listValue="name" name="category" label="Categorie" id="category" headerValue="Selecteer een categorie" headerKey="undefined" key="name"/><br/>
        <input type="submit" value="Verzenden" class="btn btn-primary" id="submitId"/>
    </form>
</div>
<a href="indexTask" class="goBackBtnStyle">Ga terug</a>
<script src="resources/js/Content.js"></script>
<%@include file="../../includes/footer.jsp" %>