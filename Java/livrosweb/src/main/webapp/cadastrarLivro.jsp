<%--
  Created by IntelliJ IDEA.
  User: guolm
  Date: 27/07/2022
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cadastro</title>
</head>
<body>
    <h2>Digite um nome e um autor nos campos abaixo:</h2>
    <fieldset>
        <form action="teste-servlet" method="post">
            <legend>Dados</legend>
            <div>
                <label for="idNome">Nome:</label>
                <input type="text" id="idNome" name="nome">
            </div>
            <div>
                <label for="idAutor">Autor</label>
                <input type="text" id="idAutor" name="autor">
            </div>
                <input type="submit" value="Enviar">
        </form>
    </fieldset>
</body>
</html>
