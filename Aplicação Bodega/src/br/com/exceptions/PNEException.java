package br.com.exceptions;

public class PNEException extends Exception{
    @Override
    public String getMessage(){
        return "Produto não Encontrado.";
    }
}
