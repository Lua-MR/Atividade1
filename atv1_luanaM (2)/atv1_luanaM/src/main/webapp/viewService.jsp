<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Serviço</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <%@ page import="clinica.Service" %>
    
    <div class="service-details-container">
        <div class="image-container">
            <img src="imgs/img2.jpg" alt="Imagem 2" class="image2">
        </div>
        <div class="service-details">
            <h2>Detalhes do Serviço</h2>
            <p>Id: ${service.getId()}</p>
            <p>Nome: ${service.getName()}</p>
            <p>Descrição: ${service.getDescription()}</p>
            <p>Preço: ${service.getPrice()}</p>
            <a href="addSession.jsp?serviceId=${service.getId()}">Agendar Sessão</a>
            <a href="ListSessionsServlet?serviceId=${service.getId()}">Ver Sessões Agendadas</a>
            <a href="ListServicesServlet">Voltar</a>
            <a href="ViewServiceServlet?id=${service.getId()}&action=edit">Editar detalhes</a>
        </div>
    </div>
</body>
</html>
