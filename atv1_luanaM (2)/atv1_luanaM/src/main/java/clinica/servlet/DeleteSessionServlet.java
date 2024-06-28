package clinica.servlet;

import clinica.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;

@WebServlet("/DeleteSessionServlet")
public class DeleteSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
      
    	    //Obtem o id do item da tabela ListSession.jsp
            int sessionId = Integer.parseInt(request.getParameter("id"));
            int serviceId = Integer.parseInt(request.getParameter("serviceId"));

            // Obtém a lista de sessões do servlet ListSessionsServlet
            List<Session> sessionList = ListSessionsServlet.getSessions();

            // Remove o servico daqquele id
            //removeIf: Apaga item da lista pelo id
            //service -> service.getId() == serviceId: pega o id que for igual ao obtido
            sessionList.removeIf(session -> session.getId() == sessionId);

            // Atualiza a lista ListSessionsServlet
            ListSessionsServlet.setSessions(sessionList);

            // Redireciona de volta ListSessions daquele id
            response.sendRedirect("ListSessionsServlet?serviceId=" + serviceId);
        } 
}
