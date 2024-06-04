import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import autenticacao.ContaManager;
import autenticacao.DatabaseConfigurator;
import autenticacao.Conta;

@WebServlet("/RegisterServlet1")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String dbeaverConfigFilePath = "AuthfyApp/src/main/java/dbeaver-config.json";

        DatabaseConfigurator dbConfigurator = DatabaseConfigurator.fromDBeaverConfig(dbeaverConfigFilePath);
        
        // Criar uma instância de ContaManager
        ContaManager contaManager = new ContaManager(dbConfigurator);
        
        // Adicionar nova conta usando o componente de autenticação
        Conta novaConta = new Conta(username, password);
        contaManager.adicionarConta(novaConta);

        // Exibir mensagem de sucesso e redirecionar para a página de login
        request.setAttribute("message", "Cadastrado com sucesso");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
