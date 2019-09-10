
package com.mycompany.aulawebnot210819.model.entity;

public class Pessoa {
    
    private Integer id;
    private String nome;
    private int idade;
    
    public String dados(){
        return "ID:"+id+", Nome:"+nome+", Idade:"+idade+"\n";
    }

    
    public String teste(){
        return String.valueOf(id);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}
