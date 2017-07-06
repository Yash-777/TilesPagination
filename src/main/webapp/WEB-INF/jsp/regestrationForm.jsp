<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
<form:form commandName="newuserdto" method="POST" action="${pageContext.request.contextPath}/regestrationForm.form">
	<table>
	<tr> <td align="right">First Name : </td>
		 <td><form:input  path="firstName" cssStyle="border-radius: 5px;" value="${empdto.id}"/></td>
		 <td><form:errors path="firstName" cssStyle="color: #ff0000;" /></td>
	</tr>
	<tr> <td align="right">Last Name : </td>
		 <td><form:input path="lastName" cssStyle="border-radius: 5px;"/></td>
		 <td><form:errors path="lastName" cssStyle="color: #ff0000;" /></td>
	</tr>
	<tr> <td align="right">Password : </td>
		 <td><form:password  path="password" cssStyle="border-radius: 5px;"/></td>
		 <td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
	</tr>
	<tr> <td align="right">Confirm Password : </td>
		 <td><form:password  path="conformPassword" cssStyle="border-radius: 5px;"/></td>
		 <td><form:errors path="conformPassword" cssStyle="color: #ff0000;" /></td>
	</tr>
	<tr> <td align="right">Email : </td>
		 <td><form:input path="email" cssStyle="border-radius: 5px;"/></td>
		 <td><form:errors path="email" cssStyle="color: #ff0000; "/></td>
	</tr>
	
	</table>
	<input type="submit" value="Register"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<c:url value='login.form'/>'>Log in</a>
	
</form:form>
</div>