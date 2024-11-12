package br.edu.ifpr.irati.servlet;

import br.edu.ifpr.irati.service.Service;
import br.edu.ifpr.irati.service.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="controleservlet", urlPatterns = {"/professor/listar",
                                                   "/professor/editar",
                                                   "/tarefa/listar"})
public class ControleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.split("/").length == 3){
            String entity = path.split("/")[1];
            String method = path.split("/")[2];
            Service service = ServiceFactory.getService(entity);
            switch (method){
                case "listar":
                    service.listar(req, resp);
                    break;
                case "editar":
                    service.editar(req, resp);
                    break;
                case "salvar":
                    service.salvar(req, resp);
                    break;
                case "excluir":
                    service.excluir(req, resp);
                    break;
                default:
                    //enviar para uma tela de erro
                    break;
            }
        }

    }
}
