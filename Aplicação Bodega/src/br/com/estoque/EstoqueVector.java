package br.com.estoque;

import br.com.exceptions.PJCException;
import br.com.exceptions.PNEException;
import br.com.produto.Produto;
import br.com.produto.ProdutoPerecivel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import br.com.persistencia.BancoDeProdutos;

public class EstoqueVector implements IEstoque{

// Atributos 
    Vector<Produto> produtos = new Vector<>();
    BancoDeProdutos bancodedados = new BancoDeProdutos();
    String path = bancodedados.retornarCaminho();
    
// Métodos Públicos de IEstoque
    @Override
    public void adicionar(Produto produto) throws PJCException {
        try{
            if (buscar(produto.getCodigo()) != null){       // eu adiciono novamente o mesmo produto, com cuidado de não alterar alguma informação
                Produto aux = buscar(produto.getCodigo());  // faço isso para toda vez que o programa rodar, o Vetor ter o produto na memória
                produtos.add(new Produto(aux.getCodigo()));
                throw new PJCException();
            } else{
                produtos.add(new Produto(produto.getCodigo()));
                try {
                    bancodedados.gravarProduto(produto);
                } catch (IOException ex) { }
            }
        } catch(PNEException | PJCException e){ }
    }

    @Override
    public Produto buscar(String codigo) throws PNEException {
        File arquivo = new File(path, codigo + ".txt");
        List linhas = new ArrayList<>();
        
        try{
            if (arquivo.isFile()){   // checa se o arquivo existe              
                try ( 
                   Scanner leitor = new Scanner(new File(path + codigo + ".txt"))) {
                    while (leitor.hasNextLine()) {
                        linhas.add(leitor.nextLine()); //adiciona cada linha a uma posição do array
                    }
                }
                
            // Criei um produto auxiliar com os mesmos atributos:
                Produto produtoAux = new Produto(codigo);
                
            // >>> Irei atribur os valores ao produtoAux <<<
                
            // NOME:
                produtoAux.setNome((String)linhas.get(1));
            // PREÇO:
            // OBS: Não da pra converter diretamente um objeto String para double ou int
                double[] doublelinhas = new double[linhas.size()];
                doublelinhas[1] = Double.parseDouble((String)linhas.get(2));
                produtoAux.setPreco((double) doublelinhas[1]);
            // QUANTIDADE:
                int[] intlinhas = new int[(linhas.size())];
                intlinhas[1] = Integer.parseInt((String) linhas.get(3));
                produtoAux.setQuantidade(intlinhas[1]);
            // VALIDADE:
                if(produtoAux instanceof ProdutoPerecivel )
                    ((ProdutoPerecivel) produtoAux).setValidade((String) linhas.get(4));
                
                return produtoAux;  // Retorna o produto.
            }
            else{
                throw new PNEException();
            }
            
        } catch (PNEException | FileNotFoundException  e){ }
        
        return null;
    }

    @Override
    public void apagar(String codigo) throws PNEException {
        Produto aux = buscar(codigo);
        
        try{
            if(aux == null){
                throw new PNEException();
            } else {
                for(int i = 0; i < produtos.size(); i++){
                    Produto p = produtos.get(i);
                    if ( p.getCodigo().equals(codigo))
                        produtos.remove(p);
                }
            }
            bancodedados.desgravarProduto(codigo);
        } catch (PNEException e){ }
    }
 
    @Override
    public int quantidade() {
        return produtos.size();
    }

    @Override
    public Produto[] produtosEmEstoque() {
        
        // roda o array uma vez contando quantos elementos estão em falta
        int emFalta = 0;
        
        for(int i = 0; i < produtos.size(); i++){
            try {
                Produto p = buscar(produtos.get(i).getCodigo());
                if (p.getQuantidade() > 0){
                    emFalta++;                  // se encontrar algum produto com 0, incremente o contador
                } else {
                }
            } catch (PNEException ex) {}
            
        }
        
        Produto produto[] = new Produto[emFalta]; // cria o array com exatamente as 'n' posições em falta 
        int quant = 0;
        
        for(int j = 0; j < produtos.size(); j++){
            try {
                Produto p = buscar(produtos.get(j).getCodigo());
                if (p.getQuantidade() > 0){
                    produto[quant] = p;
                    quant++;                    // incrementa para acessar outra posição do array
                }
            }   catch (PNEException ex) { }
        }
            
        return produto;
    }

    @Override
    public Produto[] produtosEmFalta() {
        
        // roda o array uma vez contando quantos elementos estão em falta
        int emFalta = 0;
        
        for(int i = 0; i < produtos.size(); i++){
            try {
                Produto p = buscar(produtos.get(i).getCodigo());
                if (p.getQuantidade() == 0){
                    emFalta++;                  // se encontrar algum produto com 0, incremente o contador
                }
            } catch (PNEException ex) {}
            
        }
        
        Produto produto[] = new Produto[emFalta]; // cria o array com exatamente as 'n' posições em falta 
        int quant = 0;
        
        for(int j = 0; j < produtos.size(); j++){
            try {
                Produto p = buscar(produtos.get(j).getCodigo());
                if (p.getQuantidade() == 0){
                    produto[quant] = p;
                    quant++;                    // incrementa para acessar outra posição do array
                }
            }   catch (PNEException ex) { }
        }
            
        return produto;
    }
    
}
