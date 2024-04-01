<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="fileVO" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile" />
	<form:errors path="uploadFile"/>
	<input type="file" name="uploadFile" />
	<form:input path="uploader" />
	<form:errors path="uploader" />
	<form:input type="number" path="count" />
	<form:errors path="count" />
	<button type="submit">업로드</button>
</form:form>
</body>
</html>