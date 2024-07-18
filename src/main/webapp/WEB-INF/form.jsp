<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType= "text/HTML; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</head>
<body>
    <h1 style="color: skyblue;">Bienvenidos a TVDB!</h1>
   <div class="container d-flex gap-4 justify-content-around align-items-start">
    <form:form action="/register" modelAttribute="user" method="POST"
    class="d-flex flex-column border border-4 border-secondary p-5 rounded">
    <h2>Registrarse</h2>
    <form:label path="username">Name: </form:label>
            <form:input path="username" type="text"></form:input>
            <form:errors path="username" class="text-danger"></form:errors>
            <br><br>
            <form:label path="email">Email: </form:label>
            <form:input path="email" type="email"></form:input>
            <form:errors path="email" class="text-danger"></form:errors>
            <br><br>
            <form:label path="password">Password: </form:label>
            <form:input path="password" type="password"></form:input>
            <form:errors path="password" class="text-danger"></form:errors>
            <br><br>
            <form:label path="confirmPassword" class="col-sm-4 col-form-label">Confirmacion: </form:label>
            <form:input path="confirmPassword" type="password"></form:input>
            <form:errors path="confirmPassword" class="text-danger"></form:errors>
            <br><br>
            <button type="submit">Registrarse: </button>
    </form:form>
    <h2>Login</h2>
    <form action="/login" method="post" 
    class="border border-4 border-secondary p-5 rounded d-flex flex-column">
        <label for="username">Usuario:</label>
        <input type="text" name="username">
        <label for="password">Contraseña:</label>
        <input type="password" name="password">
        <span class="text-danger">
            <c:out value="${userError}" />
        </span>
        <br>
        <button class="rounded">Iniciar Sesión</button>
    </form>
</div>

    <a href="/logout">Cerrar Sesion</a>
</body>
</html>