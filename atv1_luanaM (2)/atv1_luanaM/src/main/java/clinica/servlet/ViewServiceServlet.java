package clinica.servlet;

import clinica.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/ViewServiceServlet")
public class ViewServiceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
      
        // Obtem id
        int serviceId = Integer.parseInt(request.getParameter("id"));
        // Obtem o serviço do id
        Service service = getServiceById(serviceId);

        if (service != null) {
            // requisita o servico
            request.setAttribute("service", service);

            // Obtém a açao
            String action = request.getParameter("action");
            // se for "edit"
            if ("edit".equals(action)) {
                // Encaminha para editService
                request.getRequestDispatcher("editService.jsp").forward(request, response);
            } else {
                // Encaminha para viewService.jsp
                request.getRequestDispatcher("viewService.jsp").forward(request, response);
            }
        } else {
            // Não encontrou, cria erro
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Serviço não encontrado.");
        }
    }

    // Obtem serviço pelo id
    private Service getServiceById(int serviceId) {
        //lista de servicos
        for (Service service : ListServicesServlet.getServices()) {
            if (service.getId() == serviceId) {
                return service;
            }
        }
        return null;
    }
}
