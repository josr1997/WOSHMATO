<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/layout.jsp" %>

<a href="index.jsp">Back to Start</a>

<div class="col-lg-12">
    <div class="row">
        <table style="width:40%">
            <h1>List of Tasks</h1>
            <tr>
                <td>ID Taak</td>
                <td>Naam Taak</td>
                <td>Beschrijving</td>
                <td>Lesuur</td>
                <td>Klok uur</td>
            </tr>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.name}</td>
                    <td>${task.description}</td>
                    <td>${task.classHour}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="includes/footer.jsp" %>