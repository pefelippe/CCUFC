package br.com.produto;

public class Produto {
    // Atributos
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor 
    public Produto(String codigo) {
        this.codigo = codigo;
    }
    
    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
