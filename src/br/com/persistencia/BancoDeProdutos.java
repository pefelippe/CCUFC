package br.com.persistencia;

import br.com.estoque.IEstoque;
import br.com.produto.Produto;
import br.com.produto.ProdutoPerecivel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BancoDeProdutos {
// Atributos
    String caminho = "../Aplicação Bodega/src/bancodedados/";
    
// Construtor    
    public BancoDeProdutos() {
    File EstoqueProdutos = new File(caminho);
        if (!EstoqueProdutos.isDirectory()){
            EstoqueProdutos.mkdir();
        }
    }
    
// Métodos para persistencia
    public void gravarProduto(Produto produto) throws IOException{
        String pathArquivo = caminho + produto.getCodigo()+ ".txt";
        FileWriter arquivo = new FileWriter(pathArquivo);
        
        try (PrintWriter gravador = new PrintWriter(arquivo)){
            gravador.println(produto.getCodigo());
            gravador.println(produto.getNome());
            gravador.println(produto.getPreco());
            gravador.println(produto.getQuantidade());
            if(produto instanceof ProdutoPerecivel ) // checa se é Produto Perecivel
                gravador.println( ((ProdutoPerecivel) produto).getValidade()); 
        }    
    } 
    
    public void desgravarProduto(String codigo){
        File arquivodel = new File(caminho, codigo + ".txt");

        try{
            if (arquivodel.isFile()){
                arquivodel.delete(); // Exclue o arquivo.txt
            }
        } catch(Exception e){ } // Sem tratamento
    }

// Métodos Auxiliares
    
    public int tamanhoBanco(){                      // retorna a quantidade de arquivos
        File arquivo[];
        File diretorio = new File(caminho);
        arquivo = diretorio.listFiles();
        return arquivo.length;
    }
    
    public String retornarCaminho(){                // retorna o path
        return caminho;
    }  
    
    public File[] listadeArquivos(){              // retorna os arquivos no diretorio
        File arquivo[];
        File diretorio = new File(caminho);
        arquivo = diretorio.listFiles();
        return arquivo;
    }
}
