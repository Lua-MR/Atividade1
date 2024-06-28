<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Sessão</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Adicionar Sessão</h2>
        <form action="AddSessionServlet" method="post">
            <input type="hidden" name="serviceId" value="${param.serviceId}">
            <label for="date">Data:</label>
            <input type="date" name="date" id="date" required><br>
            <label for="time">Hora:</label>
            <input type="time" name="time" id="time" required><br>
            <button type="submit">Adicionar Sessão</button>
        </form>
                    <a href="ListServicesServlet">Voltar</a>
        
    </div>
</body>
</html>
