<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<div class="col-lg-12">
    <center>
        <div class="tableStyle">
            <table width="60%">
                <thead>
                <th class="paddingLeft">ID</th>
                <th class="paddingLeft">Naam</th>
                <th class="paddingLeft">Team</th>
                <th class="paddingLeft">Coach</th>
                <th class="paddingLeft">Gearchiveerd</th>
                <th class="paddingLeft">Bewerk</th>
                <th class="paddingLeft">Archiveer</th>
                <th class="paddingLeft">Verwijder</th>
                </thead>
                <tbody>
                    <s:iterator value="groups">
                        <tr>
                            <td class="paddingLeft"><s:property value="id"/></td>
                            <td class="paddingLeft"><a href="showStudents?id=${id}"><s:property value="name"/></a></td>
                            <td class="paddingLeft"><a href="showTeamDetails?id=${id}"><s:property value="team.name"/></a></td>
                            <td class="paddingLeft"><s:property value="teacher.name"/> <s:property value="teacher.insertion"/> <s:property value="teacher.lastname"/></td>
                            <td class="paddingLeft"><s:property value="archived"/></td>
                            <td class="paddingLeft"><a href="editGroupPage2?id=${id}">Bewerk</a></td>
                            <td class="paddingLeft"><a href="archiveGroupPage2?id=${id}">Archiveer</a></td>
                            <td class="paddingLeft"><a href="removeGroupPage2?id=${id}">Verwijder</a></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table> </div>
        <h1><a href="addGroupPage" class="btnStyle">Groep toevoegen</a></h1> </center>
        <a href="index" class="goBackBtnStyle">Ga terug</a>
    <br><br>
    <p>
</div>
<%@include file="../../includes/footer.jsp" %>