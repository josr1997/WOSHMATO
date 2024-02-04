<%@include file="includes/layout.jsp"%>
<div class="col-lg-12">
    <h1>Create Teacher</h1>
    <form action="createTeacher">
        <input type="text" name="teacherName"placeholder="Name"><br>
        <input type="text" name="teacherLastname"placeholder="Lastname"><br>
        <input type="text" name="teacherAbbrevation"placeholder="Abbrevation"><br>
        <input type="text" name="teacherFTE"placeholder="FTE"><br>
        <input type="text" name="teacherInsertion"placeholder="Insertion"><br>
        <input type="text" name="teacherEmail" placeholder="Email"><br>

                        
        <input type="submit">        
    </form>
</div>
<%@include file="includes/footer.jsp" %>