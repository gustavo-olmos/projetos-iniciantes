<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de livros</title>
</head>
<body>
    <h1>Livros cadastrados com sucesso:</h1>
    <table>
        <thead>
            <tr>
                <th>Livro</th>
                <th>Autor</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lista" items="${lista}">
                <tr>
                    <td>${lista.nome}</td>
                    <td>${lista.autor}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="index.jsp"> voltar! </a>
</body>
</html>
