<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div align="center" >
<h3> Menu </h3>
	<ul >
		<li>
			<a href="${pageContext.request.contextPath}/list.form">View</a><br>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/add.form">Add</a><br>
		<span><B>IP : <c:out value="${IP}" /></B></span>
		</li> 
	</ul>
</div>