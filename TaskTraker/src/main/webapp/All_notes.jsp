<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="com.entity.tasktraker.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes : Task-Traker</title>
<%@ include file="all_js_css.jsp"%>

</head>
<body>

	<div class="container">
		<%@ include file="navbar.jsp"%>
		<br>
		<h6 class="text-uppercase">ALL Notes :</h6>

		<div class="row">

			<div class="col-12">


				<%
					Session s = FactoryProvider.getFactory().openSession();
					Query q = s.createQuery("from Note");
					List<Note> list = q.list();

					for (Note note : list) {
				%>


				<div class="card mt-3">
					<img class="card-img-top m-4  mx-auto" style="max-width: 100px;"
						src="img/notes.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text">
							<%=note.getContent()%>
						</p>
						<p><%=note.getAddedDtae()%>
						</p>
						<div class="container text-center mt-2">
							<a href="DeleteServlet1?note_id=<%=note.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="edit.jsp?note_id=<%=note.getId()%>"
								class="btn btn-primary">Update</a>
						</div>
					</div>
				</div>

				<%
					}

					s.close();
				%>


			</div>
		</div>

	</div>
</body>
</html>