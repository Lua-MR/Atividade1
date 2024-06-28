<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Sessões</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <%@ page import="clinica.Session" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="clinica.servlet.ListServicesServlet" %>

    <%
        ArrayList<Session> sessions = (ArrayList<Session>) request.getAttribute("sessions");
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String serviceName = ListServicesServlet.getServiceName(serviceId);

    %>

    <h2>Lista de Sessões <%= serviceName %></h2>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Data</th>
            <th>Hora</th>
            <th>Ações</th>
        </tr>
        <% if (sessions != null && !sessions.isEmpty()) {
            for (Session sess : sessions) { %>
                <tr>
                    <td><%= sess.getId() %></td>
                    <td><%= sess.getDate() %></td>
                    <td><%= sess.getTime() %></td>
                    <td>
                        <a id="deleteLink" href="DeleteSessionServlet?id=<%= sess.getId() %>&serviceId=<%= sess.getServiceId() %>">Deletar</a>
                    </td>
                </tr>
        <%  } } else { %>
                <tr>
                    <td colspan="4">Nenhuma sessão encontrada!</td>
                </tr>
        <% } %>
    </table>
    <a href="addSession.jsp?serviceId=${param.serviceId}">Adicionar sessão</a>
    <a href="ListServicesServlet">Voltar</a>

</body>
</html>
