<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/layout.jsp" %>
<a href="index.jsp">Back to Start</a>
 <div class="col-lg-12">
        <h1>Alle Teams</h1>
        <table class="table table-striped table-bordered declarations-table responsive">
            <tr>
                <th>ID Team  </th>
                <th>Naam Team</th>
            </tr>
            <c:forEach var="team" items="${teams}">
                <tr>
                    <td>${team.id}</td>
                    <td>${team.name}</td>
                </tr>
            </c:forEach>
        </table>
 </div>
<div class="col-lg-12">
    <h3>Delete Team</h3>
    <form action="deleteTeam">
        Input team id:<br>
        <input type="text" id="id" name="id"><br>
        <input type="submit" value="Delete team">
    </form>
</div>

<%@include file="includes/footer.jsp" %>