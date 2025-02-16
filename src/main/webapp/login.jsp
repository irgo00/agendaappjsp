<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<p>Página de Login</p>

<p> O formulário deve levar para um servlet pelo caminho /login ou similar.
    O servlet deve validar o email e a senha digitados. Se estiverem corretos e o cadastro estiver ativo,
    deve armazenar uma variável de sessão com o objeto logado (que pode ser um professor ou um aluno) sob o nome
    usuarioLogado.
    Ao final o servlet deve redirecionar para home.jsp. Lá já tem um código para criação uma
    de uma barra de navegação lateral e também para exibição de disciplinas associadas tanto
    para professores quanto para alunos. A página só é criada se um objeto válido estiver setado na sessão com o nome
    usuarioLogado.
</p>

<form action="login/validar">
    <div class="row">
        <div class="input-field col s6">
            <input id="email" name="email" type="email" class="validate">
            <label for="email">E-mail</label>
        </div>
    </div>
    <div class="row">
        <div class="input-field col s6">
            <input id="senha" name="senha" type="password" class="validate">
            <label for="senha">Senha</label>
        </div>
    </div>
    <button class="btn waves-effect waves-light" type="submit" name="action">Login
    </button>
</form>

<%@ include file="footer.jsp" %>
</body>
</body>
</html>