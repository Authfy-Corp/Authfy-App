package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import autenticacao.Conta;
import autenticacao.ContaManager;
import autenticacao.DatabaseConfigurator;




@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContaManager contaManager;

    public void init() throws ServletException {
String dbeaverConfigFilePath = "C:/Users/Caio Bisesti/eclipse-workspace/ServletTest/src/main/java/Servlets/dbeaver-config.json";
        
        DatabaseConfigurator dbConfigurator = DatabaseConfigurator.fromDBeaverConfig(dbeaverConfigFilePath);
        
        // Inicializa a instância de ContaManager corretamente
        contaManager = new ContaManager(dbConfigurator);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("confirmarSenha");

        if (senha.equals(confirmarSenha)) {
            // Verifica se o login já está em uso
            if (!contaManager.verificarLoginExistente(usuario)) {
                // Adiciona a nova conta
                Conta novaConta = new Conta(usuario, senha);
                contaManager.adicionarConta(novaConta);

                // Redireciona para a página de sucesso
                response.sendRedirect("Sucesso.jsp");
            } else {
                // Login já está em uso, redireciona de volta para a página de cadastro com mensagem de erro
                response.sendRedirect("Cadastro.jsp?erro=login_existente");
            }
        } else {
            // As senhas não coincidem, redireciona de volta para a página de cadastro com mensagem de erro
            response.sendRedirect("Cadastro.jsp?erro=senhas_nao_coincidem");
        }
    }

    public void destroy() {
        // Faça qualquer limpeza necessária, se aplicável
    }
}
