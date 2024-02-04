<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<div class="col-lg-12">
    <center>
        <div class="tableStyle">
            <table width="25%">
                <thead>
                <th class="paddingLeft">ID</th>
                <th class="paddingLeft">Naam</th>
                <th class="paddingLeft">Bewerk</th>
                <th class="paddingLeft">Verwijder</th>
                </thead>
                <tbody>
                    <s:iterator value="categories">
                        <tr>
                            <td class="paddingLeft"><s:property value="id" /></td>
                            <td class="paddingLeft"><s:property value="name" /></td>
                            <td class="paddingLeft"><a href="editCategoryPage2?id=${id}" >Bewerk</a></td>
                            <td class="paddingLeft"><a href="removeCategoryPage2?id=${id}" >Verwijder</a></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table></div>
        <h1><a href="addCategoryPage" class="btnStyle">Categorie toevoegen</a></h1></center>
        <a href="index" class="goBackBtnStyle">Ga terug</a>
    <br><br><br>
    <p>

</div>
<%@include file="../../includes/footer.jsp" %>