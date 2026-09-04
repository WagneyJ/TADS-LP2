package br.edu.ifsp.biblioteca.exception;

public class RegraDeNegocioException extends RuntimeException{

    public RegraDeNegocioException(String mensagem){
        super(mensagem); //super chama o contrutor da classe pai
    }
}
