package clinica.servlet;

import clinica.Session;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;

@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    		//Obtem os valores inseridos no formulario de addSession.jsp
            int serviceId = Integer.parseInt(request.getParameter("serviceId"));
            String date = request.getParameter("date");
            String time = request.getParameter("time");

            // Obtem a lista do ListSessionsServlet
            List<Session> currentSessions = ListSessionsServlet.getSessions();

            // Gera id++
            //services.size(): num de elementos na lista
            // > 0 ? verifica se esta vazio (se tiver id = 1)
            //services.size() - 1).getId() - 1: pega o id do ultimo na lista
            //+1: ultimo id + 1 (id++)
            int newId = currentSessions.size() > 0 ? currentSessions.get(currentSessions.size() - 1).getId() + 1 : 1;

       
            // Adiciona a nova sessao a lista de sessoes
            Session newSession = new Session(newId, serviceId, date, time);
            currentSessions.add(newSession);
            //Atualiza a lista de sessao no ListSessionsServlet
            ListSessionsServlet.setSessions(currentSessions);

            // Redireciona paraListSessionsServlet do mesmo serviceId
            response.sendRedirect("ListSessionsServlet?serviceId=" + serviceId);
       
    }
}
