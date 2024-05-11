<!DOCTYPE html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Style/readStyle.css">
    <title>READ</title>
</head>
<body>
<main>
    <H1>SUAS TAREFAS</H1>
    <div class="divCTable">
        <table border="1" class="table">
            <tr>
                <th>ID</th>
                <th>TAREFAS</th>
                <th>STATUS DA TAREFA</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="tasks" items="${tasks}">
                <tr>
                    <td>${tasks.id}</td>
                    <td>${tasks.nametask}</td>
                    <td>${tasks.statusTask}</td>
                    <td>
                        <form action="/DeleteTarefa" method="post" class="formAction">
                            <input type="hidden" name="id" value="${tasks.id}">
                            <button type="submit" class="botao">
                                <img src="Imagens/trash-alt-svgrepo-com.svg" alt="" class="imgDiv">
                            </button>
                            <a href="tarefaCrate.jsp?id=${tasks.id}&nomeTask=${tasks.nametask}&statusTask=${tasks.statusTask}">Update</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="HomeLogado.html">Voltar Para a home</a>
    </div>
</main>
</body>
</html>