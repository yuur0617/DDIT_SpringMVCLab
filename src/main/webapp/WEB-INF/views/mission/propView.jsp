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
<input type="radio" name="contentType" value="application/x-form-urlencoded"/>parameter
<input type="radio" name="contentType" value="application/json"/>json
<form:form modelAttribute="property">
	<form:input path="propertyName" required="true" />
	<form:errors path="propertyName"/>
	<form:input path="propertyValue" required="true" />
	<form:errors path="propertyValue"/>
	<form:input path="description"/>
	<form:errors path="description"/>
	<form:input path="propDate" type="date"/>
	<form:errors path="propDate" />
	<form:input path="propTimestamp" type="datetime-local"/>
	<form:errors path="propTimestamp" />
	<button>전송</button>
</form:form>

<!-- 1. 등록의 모든 절차는 비동기로 처리할 것. -->
<!-- 2. 등록에 사용되는 모든 컨텐츠는 json 송수신할 것. -->
<!-- 3. contentType 라디오버튼에 따라 전송 컨텐츠의 종류가 달라짐. -->

</body>
</html>















