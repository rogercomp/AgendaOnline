<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda de contatos</title>
</head>
<body>
        <h1>Agenda Online</h1>
        <a href=listar>Listar todos</a>
        <a href=novo.html>Novo contato</a>
        <hr>
        <form action="alterar">
         <input type="hidden" name="id" value="<c:out value="${contato.id}" />" />
                Nome:<br>
                <input name="nome" value="<c:out value='${contato.nome}'/>"/><br> 
                Telefone:<br>
                <input name="telefone" value="<c:out value="${contato.telefone}"></c:out>"><br> 
                <input type=submit>
        </form>
</body>
</html>