package br.com.estoque;

import br.com.exceptions.PNEException;
import br.com.exceptions.PJCException;
import br.com.produto.Produto;

public interface IEstoque {
    public void adicionar(Produto produto) throws PJCException;
    public Produto buscar (String codigo) throws PNEException;
    public void apagar(String codigo) throws PNEException;
    public int quantidade();
    public Produto[] produtosEmEstoque();
    public Produto[] produtosEmFalta();
}
