package clinica.servlet;

import clinica.Service;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;

@WebServlet("/AddServiceServlet")
public class AddServiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
       
    		//Obtem os valores inseridos no formulario de addService.jsp
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));

            // Obtem a lista de serviços do ListServicesServlet
            List<Service> services = ListServicesServlet.getServices();

            // Gera id++
            //services.size(): num de elementos na lista
            // > 0 ? verifica se esta vazio (se tiver id = 1)
            //services.size() - 1).getId() - 1: pega o id do ultimo na lista
            //+1: ultimo id + 1 (id++)
            int newId = services.size() > 0 ? services.get(services.size() - 1).getId() + 1 : 1;

            // Adiciona serviço na lista
            Service newService = new Service(newId, name, description, price);
            services.add(newService);

            // Redireciona para ListServicesServlet
            response.sendRedirect("ListServicesServlet");
       
    }
}
