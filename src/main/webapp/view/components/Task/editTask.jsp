<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<link href="resources/css/StrutsStyling.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<div class="col-lg-12">
    <h1>Taak wijzigen</h1>
    <form action="editTask" method="POST">
        <s:textfield type="hidden" id="taskId" name="taskId" value="%{#attr.taskId}"/> 
        <s:textfield type="hidden" id="categoryHidden" name="categoryHidden" value="%{#attr.taskCategory.getName()}"/><br/>
        <s:textfield id="taskName" name="taskName" type="text" label="Naam van de taak" value="%{#attr.taskName}"/><br/>
        <s:textfield id="taskDescription" name="taskDescription" type="text" label="Beschrijving" value="%{#attr.taskDescription}"/><br/>
        <s:textfield id="taskLessonHours" name="taskLessonHours" type="text" label="Lesuren" value="%{#attr.taskLessonHour}"/><br/>
        <s:textfield id="taskClockHours" name="taskClockHours" type="text" label="Klokuren" value="%{#attr.taskClockHour}"/>
        <s:textfield id="taskArchived" name="taskArchived" type="hidden" maxLength="1" size="1" value="%{#attr.taskArchived}"/><br/>
        <p>
            <s:select list="categoriesList" id="taskCategory" name="taskCategory" label="nieuwe categorie" listValue="name" value="%{#attr.taskCategory}"/>
        <p>
         <input type="submit" id="submitId" class="btn btn-primary" value="Verzenden"/>
        </form>
        <a href="indexTask" class="goBackBtnStyle">Ga terug</a>
</div>
<script src="resources/js/Content.js"></script>
<script src="resources/js/task.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%@include file="../../includes/footer.jsp" %>