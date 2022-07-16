<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<%--@elvariable id="product" type="ru.gb.spring1lesson6.model.Product"--%>
<form:form action="/product/create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>


    <br>
    name: <form:input path="name"/>

    <br>

    cost: <form:textarea path="cost"/>

    <br>

    <input type="submit" value="Save"/>

</form:form>

</body>
</html>
