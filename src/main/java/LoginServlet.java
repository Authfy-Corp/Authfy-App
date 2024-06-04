
import autenticacao.ContaManager;
import autenticacao.DatabaseConfigurator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet1")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String dbeaverConfigFilePath = "AuthfyApp/src/main/java/dbeaver-config.json";

        DatabaseConfigurator dbConfigurator = DatabaseConfigurator.fromDBeaverConfig(dbeaverConfigFilePath);
        
        // Criar uma instância de ContaManager
        ContaManager contaManager = new ContaManager(dbConfigurator);

        // Verificar credenciais usando o componente de autenticação
        boolean credenciaisValidas = contaManager.verificarCredenciais(username, password);

        if (credenciaisValidas) {
            request.setAttribute("message", "Bem-vindo!");
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Login ou senha incorretos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
