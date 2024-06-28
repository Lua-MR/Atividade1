<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clinica de estética</title>
       <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ page import="clinica.Service" %>
<%@ page import="java.util.List" %>

    <h2>Clinica Sakura</h2>
    
     <div class="image-container">
        <img src="imgs/img.jpg" alt="Imagem 1" class="image1">
    </div>
    
      <div class="table-container">

        <table border="1">
        <tr>
           
            <th>Nome</th>
            <th>Preço</th>
            <th>Ações</th>
        </tr>
        <%
            List<Service> services = (List<Service>) request.getAttribute("services");
            if (services != null && !services.isEmpty()) {
                for (Service service : services) {
        %>
                    <tr>
                        
                        <td><%= service.getName() %></td>
                       
                        <td><%= service.getPrice() %></td>
                        <td>
                            <a href="ViewServiceServlet?id=<%= service.getId() %>">Detalhes</a>
							<a id="deleteLink" href="DeleteServiceServlet?id=<%= service.getId() %>">Deletar</a>
                  
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="5">Nenhum serviço encontrado!</td>
                </tr>
        <%
            }
        %>
    </table>
    
      <a href="addService.jsp">Adicionar serviço</a>
    </div>
  
</body>
</html>
