package clinica.servlet;

import clinica.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;

@WebServlet("/DeleteServiceServlet")
public class DeleteServiceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	    
    	    //Obtem o id do item da tabela ListService.jsp
            int serviceId = Integer.parseInt(request.getParameter("id"));

            // Obtem a lista de servicos de ListServicesServlet
            List<Service> serviceList = ListServicesServlet.getServices();

            // Remove o servico daqquele id
            //removeIf: Apaga item da lista pelo id
            //service -> service.getId() == serviceId: pega o id que for igual ao obtido
            serviceList.removeIf(service -> service.getId() == serviceId);

            // Atualiza a lista ListServicesServlet
            ListServicesServlet.setServices(serviceList);

            // Redireciona para a pagina com a lista atualizada
            //request.getContextPath(): "comum para realizar redirecionamentos após operações que alteram o estado da aplicação
            //garante que o navegador do cliente seja automaticamente direcionado para página"
            response.sendRedirect(request.getContextPath() + "/ListServicesServlet");
        
    }
}
