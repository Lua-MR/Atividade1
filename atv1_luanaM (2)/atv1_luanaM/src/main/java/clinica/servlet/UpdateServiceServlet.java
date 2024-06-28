package clinica.servlet;

import clinica.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;

@WebServlet("/UpdateServiceServlet")
public class UpdateServiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Obtem os valores inseridos
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        // Obtem a lista de serviços do ListServicesServlet
        List<Service> services = ListServicesServlet.getServices();

        // Atualiza os novos valores
        //Service service : services: foreach
        for (Service service : services) {
            if (service.getId() == id) {
                service.setName(name);
                service.setDescription(description);
                service.setPrice(price);
                break;
            }
        }

        // Volta para lista os serviços
        response.sendRedirect(request.getContextPath() + "/ListServicesServlet");
    }
}
