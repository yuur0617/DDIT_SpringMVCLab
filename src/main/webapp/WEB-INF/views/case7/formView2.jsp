<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<div style="border: 1px solid red;">
	${org.springframework.validation.BindingResult.sample }
</div>
<form:form method="post" modelAttribute="sample">
<pre>
	<form:input path="strParam"/>
	<form:errors path="strParam" element="span" cssClass="error"/>
	<form:input path="numParam" type="number" />
	<form:errors path="numParam" element="span" cssClass="error"/>
	<form:input path="chParam"/>
	<form:errors path="chParam" element="span" cssClass="error"/>
	<form:input path="dateParam" type="date"/>
	<form:errors path="dateParam" element="span" cssClass="error"/>
	<form:input path="dateTimeParam" type="datetime-local"/>
	<form:errors path="dateTimeParam" element="span" cssClass="error"/>
	<form:input path="optionParam" type="number"/>
	<form:errors path="optionParam" element="span" cssClass="error"/>
	<form:button type="submit">전송</form:button>
	
	<form:input path="inner.innerParam1"/>
	<form:errors path="inner.innerParam1"/>
	<form:input path="inner.innerParam2" type="number"/>
	<form:errors path="inner.innerParam2"/>
	
	<form:input type="text" path="innerList[0].innerParam3" />
	<form:errors path="innerList[0].innerParam3"/>
	<form:input path="innerList[0].innerParam4" />
	<form:errors path="innerList[0].innerParam4"/>
	<form:input path="innerList[1].innerParam3" />
	<form:errors path="innerList[1].innerParam3"/>
	<form:input path="innerList[1].innerParam4" />
	<form:errors path="innerList[1].innerParam3"/>
</pre>
</form:form>














