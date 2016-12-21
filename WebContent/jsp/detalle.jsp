<%@page import="java.sql.ResultSet"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container">
		<div class="row">
			<%
				ResultSet produc = (ResultSet) request.getAttribute("producto");
				produc.next();
			%>
			<div class="col-md-4">
			<h3><a href="CestaController?id=<%= produc.getString("ID")%>"><%= produc.getString("nombre") %></a></h3>
			<img alt="" src="imagen/<%= produc.getString("imagen") %>">
			<p><%= produc.getString("precio") %></p>
			</div>
		</div>
	</div>
</body>
</html>