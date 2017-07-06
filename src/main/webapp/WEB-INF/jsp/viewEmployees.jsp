<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!-- Display Tag -->
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Spring Pagination using Display Tag</title>
	<link rel="stylesheet" type="text/css" href="css/displaytag.css">
</head>
	
<body>
<div align="center">
<form:form commandName="empdto" action="" method="post"> 
	<h2 align="center">Employee List</h2>
	<!-- To change column style please form this classes ISIS OR ITS OR Mars OR Simple OR Report OR Mark Column 
	We have chosen style class="its"-->
	<display:table id="row_id" export="false"  name="empdto.empList" requestURI="/list.form" pagesize="15" cellpadding="2px;" cellspacing="2px;">
		<display:column property="id" title="ID" sortable="false" style="border:1;"/>
		<display:column property="name" title="Name" sortable="true" style="border:1;"/>
		<display:column property="age" title="Age" sortable="true" style="border:1;"/>
		<display:column property="salary" title="Salary" sortable="true" style="border:1;"/>
		<display:column property="address" title="Address" sortable="true" style="border:1;"/>
	<display:column title="Edit">
		<c:set var="clm_id" value="${row_id.id}"/>
		<a href="${pageContext.request.contextPath}/editemp.form?id=${clm_id}">Edit</a>
	</display:column>
	<display:column title="Delete">
		<c:set var="clm_id" value="${row_id.id}"/>
		<a href="${pageContext.request.contextPath}/deleteEmp.form?id=${clm_id}"
		onclick="selectobjID(${clm_id})">Delete</a>
	</display:column>
	</display:table>
</form:form>
</div>
</body>
</html>
</tiles:putAttribute>
</tiles:insertDefinition>