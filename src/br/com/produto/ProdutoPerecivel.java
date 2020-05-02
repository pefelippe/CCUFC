package br.com.produto;

public class ProdutoPerecivel extends Produto{
    // Atributo
    private String validade;
    
    // Construtor
    public ProdutoPerecivel(String codigo) {
        super(codigo);
    }

    // Getters e Setters
    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    
}
