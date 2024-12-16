<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifpr.irati.model.Disciplina"%>
<%@page import="br.edu.ifpr.irati.model.Professor"%>
<%@page import="br.edu.ifpr.irati.service.ProfessorService"%>
<%@page import="br.edu.ifpr.irati.dao.GenericDAO"%>
<%@page import="br.edu.ifpr.irati.dao.Dao"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.Integer"%>

<%
    ProfessorService professorService = new ProfessorService();

    Professor professor = new Professor();
    int id = 0;
    boolean editar = true;
    boolean responder = false;

    try {
        id = Integer.parseInt(request.getParameter("id"));
        responder = request.getParameter("responder") != null && request.getParameter("responder").equals("true");

        if (id > 0) {

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Cadastrar Professor</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
    <div class="row">
        <div class="col s12">
            <div class="col s6 offset-s3">
                <h3 text-align="center">Cadastrar Professor</h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s12">
            <div class="col s6 offset-s3">
                <form class="col s12"
                <%if(id != 0){%>
                action="resposta"
                <%} else{%>
                action="contato"
                <%}%>
                method="POST">
                        <input type="hidden" name="id" value="<%= professor.getId() %>" />
                        <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">person</i>
                            <input id="nome" name="nome" type="text" class="validate" value="<%= professor.getNome() %>" <%= editar ? "" : "disabled" %>>
                            <label for="nome">Nome</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">email</i>
                            <input id="email" name="email" type="email" class="validate" value="<%= professor.getEmail() %>" <%= editar ? "" : "disabled" %>>
                            <label for="email">Email</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">business_center</i>
                            <div style="margin-left: 50px;">
                                <label>
                                    <input class="with-gap" name="ativo" type="radio" id="ativo" />
                                    <span>Ativo</span>
                                </label>
                                <label style="margin-left: 20px;">
                                    <input class="with-gap" name="ativo" type="radio" id="inativo" />
                                    <span>Inativo</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">mode_edit</i>
                            <textarea id="texto" name="texto" class="materialize-textarea" <%= editar ? "" : "disabled" %>><%= professor.getSenha() %></textarea>
                            <label for="texto">Texto</label>
                        </div>
                    </div>

                    <%
                    if (responder == true) {
                    %>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">reply</i>
                            <textarea id="resposta" name="resposta" class="materialize-textarea"></textarea>
                            <label for="resposta">Resposta</label>
                        </div>
                    </div>
                    <%
                    }
                    %>

                    <div class="row">
                        <div class = "input-field col 12">
                            <a href="listacontatos.jsp" style ="background-color: #d3d3d3; color: #4a4a4a; box-shadow: none;" class="waves-effect waves-light btn-small">Professores Cadastrados</a>
                        </div>
                    </div>

                    <div class="row">
                        <button class="btn waves-effect waves-light col s12" type="submit" name="enviar">Cadastrar</button>
                        <br>
                    </div>

                </form>
        </div>
    </div>
    <script type="text/javascript" src="//code.jquery.com/jquery-2.1.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
        $(document).ready(function() {
            $('select').formSelect();
        });
    </script>
</body>
</html>

