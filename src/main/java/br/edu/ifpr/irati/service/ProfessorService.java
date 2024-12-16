package br.edu.ifpr.irati.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProfessorService implements Service{
    @Override
    public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("listar professor");
    }

    @Override
    public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("editar professor");
    }

    @Override
    public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("salvar professor");
    }

    @Override
    public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("excluir professor");
    }

    @Override
    public void buscarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Buscar professor por id");
    }


}
