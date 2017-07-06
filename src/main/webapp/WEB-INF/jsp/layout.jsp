<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html>
<head>

<title>Untitled Document</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	width:100%;
	height:100%;
}
#container {
	width:100%;
}
#header {
	width:100%;
	height:5%;
	position:fixed;
	background-color:#A0A0A0 ;
}
#sidebar {
	top: 5%;
	position:fixed;
	left:0;
	height:90%;
	width:13%;
	background-color:#D0D0D0 ;
}
#content {
	top:5%;
	position:fixed;
	right:0;
	height: 90%;
	width: 87%;
	overflow:auto;
	background-color: white;
}
#footer {
	bottom:0;
	position:fixed;
	
	width:100%;
	height:5%;
	background-color:#A0A0A0 ;
}
</style>
</head>
<body>
<div id="container">
	<div id="header"><tiles:insertAttribute name="header" /></div>
	<div id="sidebar"><tiles:insertAttribute name="menu" /></div>
	<div id="content"><tiles:insertAttribute name="body" /></div>
	<div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>