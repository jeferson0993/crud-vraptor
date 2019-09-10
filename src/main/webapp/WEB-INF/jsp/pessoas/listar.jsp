
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Pessoas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>           
            nav {
                display: flex;
                justify-content: space-between;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">Crud em java com o framework vraptor 4</a>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${linkTo[PessoasController].form()}">Cadastrar Pessoa</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${linkTo[PessoasController].listar()}">Listar Pessoas</a>
                    </li>
                </ul>
        </nav>
        <main role="main" class="container">

            <div class="starter-template mt-5 pt-5">
                <h2>Lista de Pessoas: </h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">NOME</th>
                            <th scope="col">IDADE</th>
                            <th colspan="2">AÇÕES</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pessoaList}" var="pessoa">
                        <tr>
                            <td>${pessoa.id}</td>
                            <td>${pessoa.nome}</td>
                            <td>${pessoa.idade}</td>
                            <td>
                                <a href="${linkTo[PessoasController].editar()}?id=${pessoa.id}" class="btn btn-primary">Editar</a>                    
                            </td>
                            <td>
                                <a href="${linkTo[PessoasController].excluir()}?id=${pessoa.id}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <table style="width:100%">

                </table>
            </div>

        </main>         
    </body>
</html>
