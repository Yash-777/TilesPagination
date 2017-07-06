<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%
HttpSession nsession = request.getSession(false);
Object userSession = session.getAttribute("userName");
session.removeAttribute("userName");
out.print("Removed Session : "+userSession);
session.invalidate();
%>
<core:redirect url="/login.form"/>