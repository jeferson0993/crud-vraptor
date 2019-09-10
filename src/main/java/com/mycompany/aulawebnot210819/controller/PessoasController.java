
package com.mycompany.aulawebnot210819.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.mycompany.aulawebnot210819.model.dao.PessoaDAO;
import com.mycompany.aulawebnot210819.model.entity.Pessoa;
import java.util.List;

@Controller
public class PessoasController {
    
    PessoaDAO dao = new PessoaDAO();
     
    public void form(){
    }
   
    @Path("/")
    public List<Pessoa> listar(){
        return dao.buscarPessoas();
    }
    
    @Path("/add")
    public void salvar(Pessoa pessoa, Result result){
        //add pessoa no BD
        if(pessoa.getId() == null)
            dao.add(pessoa);
        else
            dao.update(pessoa);
        //redireciona para listar.jsp
        result.redirectTo(this).listar();
    }
    
    public void editar(int id, Result result){
        Pessoa p = dao.buscarPessoa(id);
        //faz a inclusão do obj pessoa na página form.jsp
        result.include("pessoa",p);
        //redireciona para form.jsp
        result.redirectTo(this).form();
    }
    
    public void excluir(int id, Result result){
        Pessoa p = dao.buscarPessoa(id);
        dao.excluir(p.getId());
        result.redirectTo("/");
    }
}
