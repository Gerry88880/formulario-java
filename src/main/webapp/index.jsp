<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario</title>

    <style>
        body {
            font-family: Arial;
            background: linear-gradient(135deg, #fff8cc, #ffe066);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .box {
            background: white;
            padding: 25px;
            border-radius: 10px;
            width: 320px;
        }

        h2 { text-align: center; }

        input {
            width: 100%;
            margin-top: 5px;
            margin-bottom: 10px;
            padding: 7px;
        }

        button {
            width: 100%;
            padding: 10px;
            background: gold;
            border: none;
        }
    </style>
</head>

<body>

<div class="box">

    <h2>Registro</h2>

    <form action="registro" method="post">

        Nombre:
        <input type="text" name="nombre" required>

        Teléfono:
        <input type="text" name="telefono" required>

        Correo:
        <input type="email" name="correo" required>

        Universidad:
        <input type="text" name="universidad" required>

        <label>
            <input type="checkbox" name="hub">
            ¿Inscrito en Hub?
        </label>

        <button type="submit">Registrar</button>

    </form>

</div>

</body>
</html>