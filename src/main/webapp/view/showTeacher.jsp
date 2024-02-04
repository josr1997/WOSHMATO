<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/layout.jsp" %>
<a href="index.jsp">Back to Start</a>
    <div class="col-lg-12">
        <h1>Alle Docenten</h1>
        <table class="table table-striped table-bordered declarations-table responsive">
            <tr>
                <th>ID Teacher</th>
                <th>Naam Teacher</th>
            </tr>
                <c:forEach var="person" items="${teachers}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

<%@include file="includes/footer.jsp" %>