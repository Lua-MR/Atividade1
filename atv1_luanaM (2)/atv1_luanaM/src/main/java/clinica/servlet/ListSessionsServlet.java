package clinica.servlet;

import clinica.Session;
import clinica.Service;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListSessionsServlet")
public class ListSessionsServlet extends HttpServlet {

    // Lista sessoes
    private static List<Session> sessions = new ArrayList<>();
    
  //executa quando inicializa só 1 vez, quando adiciona nao repete
    static {
        // Adiciona sessao
        sessions.add(new Session(1, 1, "2024-07-01", "10:00"));
        sessions.add(new Session(2, 2, "2024-07-02", "11:00"));
        sessions.add(new Session(3, 1, "2024-08-01", "10:00"));
        sessions.add(new Session(4, 2, "2024-08-02", "11:00"));
    }

    //retorna a lista de session AddSessionServelet
    public static List<Session> getSessions() {
        return sessions;
    }

  //Atualiza a lista de session para DeleteSessionServelet
    public static void setSessions(List<Session> updatedSessions) {
        sessions = updatedSessions;
    }

    //retorna a lista de sessoes daquele servico
    //cria nova lista para apenas essas sessoes
    //Session session : sessions: foreach que percorre a lista
    private List<Session> getSessionsByServiceId(int serviceId) {
        List<Session> sessionsByServiceId = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getServiceId() == serviceId) {
                sessionsByServiceId.add(session);
            }
        }
        return sessionsByServiceId;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    		//obtem o id
            String serviceIdStr = request.getParameter("serviceId");
            
            //se nao tiver o id
            if (serviceIdStr == null || serviceIdStr.isEmpty()) {
                // Obtém a lista de servico de esServlet
                List<Service> services = ListServicesServlet.getServices();
                request.setAttribute("services", services);

                // Encaminha para listService.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("listServices.jsp");
                dispatcher.forward(request, response);
                return; 
            }

            int serviceId = Integer.parseInt(serviceIdStr);
            //obtem as sessoes do id
            List<Session> sessionsByServiceId = getSessionsByServiceId(serviceId);
            
            //encaminha as informacoes para listsessions.jsp
            request.setAttribute("sessions", sessionsByServiceId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listSessions.jsp");
            dispatcher.forward(request, response);
       
    }
}
