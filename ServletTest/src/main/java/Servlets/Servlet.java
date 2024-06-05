package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import autenticacao.ContaManager;
import autenticacao.DatabaseConfigurator;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContaManager contaManager;

    public Servlet() {
        String dbeaverConfigFilePath = "C:/Users/Caio Bisesti/eclipse-workspace/ServletTest/src/main/java/Servlets/dbeaver-config.json";
        
        DatabaseConfigurator dbConfigurator = DatabaseConfigurator.fromDBeaverConfig(dbeaverConfigFilePath);
        
        // Inicializa a instância de ContaManager corretamente
        contaManager = new ContaManager(dbConfigurator);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        // Verifica se as credenciais são válidas
        if (contaManager.verificarCredenciais(usuario, senha)) {
            // Redireciona para a página de sucesso
            response.sendRedirect("Sucesso.jsp");
        } else {
            // Credenciais inválidas, redireciona de volta para o login
            response.sendRedirect("Login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redireciona para a página de login
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
