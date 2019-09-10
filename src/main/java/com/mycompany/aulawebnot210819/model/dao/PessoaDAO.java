
package com.mycompany.aulawebnot210819.model.dao;

import com.mycompany.aulawebnot210819.model.entity.Pessoa;
import com.mycompany.aulawebnot210819.model.jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PessoaDAO {

    public static void main(String[] args) {

        
        PessoaDAO pdao = new PessoaDAO();

        Pessoa p = new Pessoa();
         p.setNome("gilma");
         p.setIdade(31);
        
        System.out.println(pdao.add(p));

        

        for (Pessoa pe : pdao.buscarPessoas()) {
           System.out.println(pe.dados());
        }
        
         //Pessoa p = pdao.buscarPessoa(35);
         //p.setNome("deb alter");
         //p.setIdade(31);
        
       // System.out.println(pdao.add(p));
        
        //System.out.println(pdao.update(p));
        
    }

    /**
     * Método para deletar uma pessoa pelo ID
     * @param id
     */
    public boolean excluir(int id) {
        try {
            //criar um objeto Connection para receber a conexão
            Connection con = Conexao.criarConexao();
            //comando sql
            String sql = "delete from tb_pessoa where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setInt(1, id);
            
            if(ps.executeUpdate()==1)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    
    /**
     * Método para add uma pessoa
     */
    public boolean add(Pessoa pessoa) {
        try {
            //criar um objeto Connection para receber a conexão
            Connection con = Conexao.criarConexao();
            //comando sql
            String sql = "insert into tb_pessoa (nome, idade) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            
            if(ps.executeUpdate()==1)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    public boolean update(Pessoa pessoa) {
        try {
            //criar um objeto Connection para receber a conexão
            Connection con = Conexao.criarConexao();
            //comando sql
            String sql = "update tb_pessoa set nome=?, idade=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setInt(3, pessoa.getId());
            
            if (ps.executeUpdate()==1)
                return true;
                    
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Método para retornar uma pessoa pelo ID
     */
    public Pessoa buscarPessoa(int id) {
        try {
            //criar um objeto Connection para receber a conexão
            Connection con = Conexao.criarConexao();
            //comando sql
            String sql = "select * from tb_pessoa where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setInt(1, id);
            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Pessoa> buscarPessoas() {
        try {
            //criar um objeto Connection para receber a conexão
            Connection con = Conexao.criarConexao();
            //comando sql
            String sql = "select * from tb_pessoa";
            PreparedStatement ps = con.prepareStatement(sql);
            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            //cria uma lista de pessoas para retornar
            List<Pessoa> pessoas = new ArrayList();
            //laço para buscar todas as pessoas do banco
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                //add pessoa na lista
                pessoas.add(p);
            }
            //retorna a lista de pessoas
            return pessoas;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
