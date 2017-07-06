<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
<div class="body" align = "center">

<h1 align="center"> Employee Details </h1>
<form:form commandName="empdto" method="POST" action="${pageContext.request.contextPath}/editemp.form">
<table align="center" >
	<tr> <td align="right">Employee ID : </td>
		<td><form:input path="id" readonly="true" cssStyle="border-radius: 5px;" value="${empdto.id}"/></td>
	</tr>
	<tr> <td align="right">Employee Name: </td>
		<td><form:input path="name" cssStyle="border-radius: 5px;" value="${empdto.name}"/></td>
	</tr>	
	<tr align="right"><td/> <td><form:errors path="name" cssStyle="color: #ff0000;" /></td></tr>
	
	<tr> <td align="right">Employee Age: </td>
		<td><form:input id="age" path="age" cssStyle="border-radius: 5px;" value="${empdto.age}"/></td>
	</tr>
	<tr align="right"><td/> <td><form:errors path="age" cssStyle="color: #ff0000;" /></td></tr>
		
	<tr> <td align="right">Employee Salary: </td>
		<td><form:input path="salary" cssStyle="border-radius: 5px;" value="${empdto.salary}"/></td>
	</tr>
	<tr align="right"><td> </td> <td><form:errors path="salary" cssStyle="color: #ff0000;" /></td></tr>
	
	<tr> <td align="right">Employee Address: </td>
		<td><form:input path="address" cssStyle="border-radius: 5px;" value="${empdto.address}"/></td>
	</tr>
	<tr align="right"><td> </td> <td><form:errors path="address" cssStyle="color: #ff0000;" /></td></tr>
	
	<tr> <td colspan="2" align="center"> <input name="update" type="submit" value="Update" ></td> </tr>
</table>
</form:form>
</div>
</tiles:putAttribute>
</tiles:insertDefinition>	