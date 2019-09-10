
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro e Edicao</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>           
            nav {
                display: flex;
                justify-content: space-between;
            }
            form {
                max-width: 400px;
                margin: auto;
                margin-top: 5em;
            }
        </style>        
    </head>
    <body role="main" class="container">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top mb-10">
            <a class="navbar-brand" href="#">Crud em java com o framework vraptor 4</a>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${linkTo[PessoasController].listar()}">Listar Pessoas</a>
                    </li>
                </ul>
        </nav>
                    
        <h1 class="">FORM</h1>
        
        <form action="${linkTo[PessoasController].salvar()}" method="post" class="form">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="hidden" name="pessoa.id" value="${pessoa.id}" class="form-control" id="id">
            </div>
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="pessoa.nome" value="${pessoa.nome}" class="form-control" id="nome">
            </div>
            <div class="form-group">
                <label for="idade">Idade:</label>
                 <input type="text" name="pessoa.idade" value="${pessoa.idade}" class="form-control" id="idade">
            </div>
            
            <input type="submit" value="Salvar" class="btn btn-success">
            
        </form>
                      
    </body>
</html>
