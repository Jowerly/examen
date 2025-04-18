<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType= "text/HTML; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <h1>Bienvenidos, ${UserEntity.username}</h1>
        <h1><c:out value=""/></h1>
        <header class="container-xxl box">
            <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <th>Programa</th>
            <th>Red</th>
            <th>Promedio de Calificaciones</th>
        </thead>
        </div>
        <tbody> 
            <c:forEach var="programa" items="${programas}">
            <tr>    
            <td>
                <p><c:out value="${programa.title}"/></p>
                <p><c:out value="${programa.proveedor}"/></p>
                <p><c:out value="${programa.descripcion}"/></p>
                <p><c:out value="${programa.valoracion}"/></p>
            </tr>
            </c:forEach>

        </tbody>
        </table>
        </header>   
<main>
    <button <a href="programaNew.jsp">Agregar un Programa</a>  </button>
<a href=""></a>
</main> 
</body>
</html>