<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/layout.jsp" %>
<a href="index.jsp">Back to Start</a>
 <div class="col-lg-12">
        <h1>Alle Docenten</h1>
        <p>${teachers}</p>
        <table class="table table-striped table-bordered declarations-table responsive">
            <tr>
                <th>ID</th>
                <th>Naam</th>
                <th>Tussenvoegsel</th>
                <th>Achternaam</th>
                <th>Email</th>
                <th>Afkorting</th>
            </tr>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.insertion}</td>
                    <td>${teacher.lastname}</td>
                    <td>${teacher.email}</td>
                    <td>${teacher.abbrivation}</td>
                </tr>
            </c:forEach>
        </table>
 </div>
<div class="col-lg-12">
    <h3>Delete Team</h3>
    <form action="deleteTeacher">
        Input team id:<br>
        <input type="text" id="id" name="id"><br>
        <input type="submit" value="Delete Docent">
    </form>
</div>

<%@include file="includes/footer.jsp" %>