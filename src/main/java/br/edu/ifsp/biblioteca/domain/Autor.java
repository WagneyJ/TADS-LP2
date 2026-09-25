package br.edu.ifsp.biblioteca.domain;

public class Autor {
    private Long id;
    private String nome;

    public Autor (String nome) {
        this.nome = nome;
    }

    public Long getId(){            //Acessa as infos dos métodos Private
        return this.id;
    }

    public void setId(Long id) {    //Altera as infos dos métodos Private
        this.id = id;   //this referencia um parametro da classe e não do metodo
    }

    public String getNome(){
        return this.nome;
    }

    public void setId(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
