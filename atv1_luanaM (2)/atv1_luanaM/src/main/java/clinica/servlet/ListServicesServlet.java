package clinica.servlet;

import clinica.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListServicesServlet")
public class ListServicesServlet extends HttpServlet {
    
    // Lista servicos
    private static List<Service> services = new ArrayList<>();

    //executa quando inicializa só 1 vez, quando adiciona nao repete
    static {
        // Adiciona servicos
        services.add(new Service(1, "Unhas", "Mão", 19.99));
        services.add(new Service(2, "Cabelo", "Lavagem", 55.00));
        services.add(new Service(3, "Massagem", "Massagem", 70.00));
        services.add(new Service(4, "Maquiagem", "Maquiagem", 150.00));
    }

    //retorna a lista de servicos para AddServiceServelet
    public static List<Service> getServices() {
        return services;
    }

    //Atualiza a lista de servicos para DeleteServiceServelet
    public static void setServices(List<Service> updatedServices) {
        services = updatedServices;
    }
    

    //retorna o nome do servico baseado no id
    //Mostra o nome na listSession.jsp
    //Service service : services: foreach que percorre a lista
    public static String getServiceName(int serviceId) {
        for (Service service : services) {
            if (service.getId() == serviceId) {
                return service.getName();
            }
        }
        return "Serviço não encontrado";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // deixa os dados acessiveis pro jsp
        request.setAttribute("services", services);

        // encaminha pra lista de servico
        //RequestDispatcher: exibi a lista 
        RequestDispatcher dispatcher = request.getRequestDispatcher("listServices.jsp");
        dispatcher.forward(request, response);
    }
}
