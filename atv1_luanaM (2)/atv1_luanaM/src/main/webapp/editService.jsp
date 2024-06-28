<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Serviço</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <%@ page import="clinica.Service" %>

    <div class="service-details-container">
        <div class="image-container">
            <img src="imgs/img2.jpg" alt="Imagem 2" class="image2">
        </div>
        <div class="service-details">
            <h2>Editar Serviço</h2>
            <form action="UpdateServiceServlet" method="post">
                <input type="hidden" name="id" value="${service.getId()}">
                <label for="name">Nome:</label>
                <input type="text" id="name" name="name" value="${service.getName()}">
                <br>
                <label for="description">Descrição:</label>
                <input type="text" id="description" name="description" value="${service.getDescription()}">
                <br>
                <label for="price">Preço:</label>
                <input type="text" id="price" name="price" value="${service.getPrice()}">
                <br>
                <br>
                <button type="submit">Salvar</button>
            </form>
            <a href="ListServicesServlet">Voltar</a>
        </div>
    </div>
</body>
</html>
