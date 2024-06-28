<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Novo Serviço</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Adicionar Novo Serviço</h2>
        <form action="AddServiceServlet" method="post">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required><br><br>
            
            <label for="description">Descrição:</label>
            <input type="text" id="description" name="description" required><br><br>
            
            <label for="price">Preço:</label>
            <input type="number" min="1" id="price" name="price" required><br><br>
            
            <input type="submit"  value="Adicionar Serviço">
        </form>

        <br>
        <a href="ListServicesServlet">Voltar</a>
    </div>
</body>
</html>
