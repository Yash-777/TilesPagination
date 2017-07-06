<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>LoginForm</title>
<style type="text/css">
 body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      } 
login-box {
		width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #000;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 10px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);  
}
</style>

</head>
<body onload='document.userLogin.mail.focus();'>

<!-- <div class="container"> -->
<div id="login-box" align="center" >

<form:form name="userLogin" commandName="loginDto" method="POST" action="${pageContext.request.contextPath}/login.form">
	<table>
	<tr> <td align="right">Email ID	: </td>
		<td><form:input id="email" path="email" cssStyle="border-radius: 5px;"/></td>
	</tr>
	<tr align="right"><td/>
		<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
	</tr>	
	<tr> <td align="right">Password	: </td>
		<td><form:password id="password" path="password" cssStyle="border-radius: 5px;"/></td>
	</tr>
	<tr align="right"><td/>
		<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
	</tr>
	</table>
	<label class="checkbox" >
		<input id="RememberMe" value="remember-me" type="checkbox" > Remember me
	</label> <br/>
	<input id="Login"  type="submit" value="Login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="reset" type="reset">
</form:form>
 
<a href="<c:url value='regestrationForm.form'/>"> New User </a>
</div>
</body>
</html>
