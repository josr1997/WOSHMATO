<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">

<div class="col-lg-12">

    <center>
        <div class="tableStyle">
            <table width="100%" id="taskTable">
                <thead>
                <th class="paddingLeft">ID</th>
                <th class="paddingLeft">Naam</th>
                <th class="paddingLeft">Beschrijving</th>
                <th class="paddingLeft">Klokuren</th>
                <th class="paddingLeft">Lesuren</th>
                <th class="paddingLeft">Categorie</th>
                <th class="paddingLeft">Gearchiveerd</th>
                <th class="paddingLeft">Bewerk</th>
                <th class="paddingLeft">Archiveer</th>
                </thead>
                <tbody>
                    <s:iterator value="tasks">
                        <tr><p value="%{archived}">
                            <td class="paddingLeft"><s:property value="id" /></td>
                            <td class="paddingLeft"><s:property value="name" /></td>
                            <td class="paddingLeft"><s:property value="description" /></td>
                            <td class="paddingLeft"><fmt:formatNumber type="number" maxFractionDigits="1" value="${clockhour}" /></td>
                            <td class="paddingLeft"><fmt:formatNumber type="number" maxFractionDigits="1" value="${lessonhour}" /></td>
                            <td class="paddingLeft"><s:property value="%{category.name}" /></td>
                            <td class="paddingLeft" id="taskArchived"><s:if test="%{archived}">ja</s:if><s:else>nee</s:else></td>
                            <td class="paddingLeft"><a href="editTaskPage2?id=${id}">Bewerk</a></td>
                            <td class="paddingLeft"><s:if test="%{archived}"><a href="archiveTaskPage2?id=${id}">De-archiveer</a></s:if><s:else><a href="archiveTaskPage2?id=${id}">Archiveer</a></s:else></td>
                        </tr>    
                    </s:iterator>
                </tbody>
            </table></div></center>
    <div class="center"><a href="addTaskPage" class="btnStyle">Taak toevoegen</a></div><div class="end"><a href="index" class="goBackBtnStyle">Ga terug</a></div>
</div>
<%@include file="../../includes/footer.jsp" %>