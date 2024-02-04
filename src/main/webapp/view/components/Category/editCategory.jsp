<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../includes/layout.jsp" %>
<link href="resources/css/content.css" rel="stylesheet" type="text/css">
<link href="resources/css/StrutsStyling.css" rel="stylesheet" type="text/css"/>
<div class="col-lg-12">
    <h1>Categorie wijzigen</h1>
    <p>
        <s:form action="editCategory" method="POST">
            <s:textfield type="hidden" id="categoryId" name="categoryId" value="%{#attr.categoryId}"/> 
            <s:textfield id="categoryName" name="categoryName" type="text" label="Naam van de category" value="%{#attr.categoryName}"/>
        <p>
            <s:submit value="verzenden" class="submitBtnStyle"/>
        </s:form>
        <a href="indexCategory" class="goBackBtnStyle">Ga terug</a>
</div>
<script src="resources/js/Content.js"></script>
<%@include file="../../includes/footer.jsp" %>