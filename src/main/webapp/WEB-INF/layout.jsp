<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="preScript"/>
</head>
<body data-context-path="${pageContext.request.contextPath }">
<tiles:insertAttribute name="headerMenu" />
<hr />

<tiles:insertAttribute name="contentPage"/>

<hr />

<tiles:insertAttribute name="postScript"/>
</body>
</html>














