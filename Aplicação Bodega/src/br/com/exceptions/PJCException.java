package br.com.exceptions;

import javax.swing.JOptionPane;

public class PJCException extends Exception{
    
    @Override
    public String getMessage(){
        return "Produto já cadastrado";
    }
    
}
