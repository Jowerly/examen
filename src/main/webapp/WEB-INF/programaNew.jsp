<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType= "text/HTML; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Agregar un nuevo programa</h1>
    <form:form action="/programa/new"  modelAttribute="programa" method="POST">
        <form:label path="title">Titulo: </form:label>
        <form:input path="title" type="text" name="title"></form:input>
        <form:errors path="title" style="color: red;"></form:errors>
        <br><br>
        <form:label path="proveedor">Red: </form:label>
        <form:input path="proveedor" type="proveedor"></form:input>
        <form:errors path="proveedor" style="color: red;"></form:errors>
        <br><br>
        <form:label path="descripcion">Descripcion: </form:label>
        <form:input path="descripcion" type="descripcion"></form:input>
        <form:errors path="descripcion" style="color: red;"></form:errors>
        <button type="submit">cancelar</button> <button type="submit">Enviar</button>
    </form:form>
</body>
</html>