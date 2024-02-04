<%@include file="includes/layout.jsp" %>
<div class="col-lg-12">
    <h1>Hello World!</h1>
    <a href="createTeam.jsp">Create Team</a><br/>
    <form action="loadTeams">
        <input value="Team Overview" type="submit"><br/>
    </form>
    <form action="deleteTeam">
        <input value="Delete team" type="submit"><br/>
    </form>
    <a href="createTeacher.jsp">Create Teacher</a>
    <form action="editTeacher">
        <input value="Edit Teacher" type="submit"></br>
    </form>
    <form action="deleteTeacher">
        <input value="Delete teacher" type="submit"><br/>
    </form>
</div>
<%@include file="includes/footer.jsp" %>