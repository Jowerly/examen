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
    <h1>${programa.title}</h1>  <a href="programaList.jsp">Volver al panel</a>
    <h2>${programa.username}</h2>
    <h2>${programa.proveedor}</h2>
    <h3>${programa.descripcion}</h3>
    <button type="submit">Editar</button>
    <br><br>
    <table>
        <thead>
            <th>Name: </th>
            <th>Rating: </th>
        </thead>
        <tbody  class="table table-bordered table-striped">
            
            <td>${user.username}</td>
            <td>${user.valoracion}</td>
        </tbody>
    </table>
    <h3>Deja una calificacion</h3> <label value></label><button type="submit">Calificar</button>
</body>
</html>