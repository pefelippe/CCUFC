
package br.com.bodega;

import br.com.estoque.IEstoque;
import br.com.exceptions.PJCException;
import br.com.exceptions.PNEException;
import br.com.produto.Produto;
import java.io.File;
import java.util.Arrays;
import javax.swing.JOptionPane;
import br.com.persistencia.BancoDeProdutos;

public class Bodega {
    
//Atributos
    private final IEstoque Estoque ;
    BancoDeProdutos bancodedados = new BancoDeProdutos();
    
// Construtor
    public Bodega(IEstoque estoque) {
        this.Estoque = estoque;
    }
    
 //Métodos Públicos   
    public void adicionarProduto(Produto produto) throws PJCException{
        
        try{
            Produto aux = Estoque.buscar(produto.getCodigo());
            
            if(aux != null){                 
                throw new PJCException();   //checa se o produto existe
            }
            else{
                Estoque.adicionar(produto); // Adiciona no estoque
                JOptionPane.showMessageDialog(null, "A conta " + produto.getCodigo() + " foi cadastrada com sucesso.");
            }

        } catch (PNEException | PJCException e){
            JOptionPane.showMessageDialog(null, "A conta " + produto.getCodigo() + " já foi cadastrada.");
        } 
    }
    
    public void removerProduto(String codigo) throws PNEException{
        
        try{
            Produto aux = Estoque.buscar(codigo); 
            
            if(aux == null){
                throw new PNEException();
            }
            
            else{
                Estoque.apagar(codigo); // Apaga do estoque
                JOptionPane.showMessageDialog(null, "A conta " + codigo + " foi removida com sucesso.");
            }
        } catch (PNEException e){ 
            JOptionPane.showMessageDialog(null, "A conta não foi cadastrada.");
        }                 
        
    }
    
    public void estocarProduto (String codigo, int quantidade){
        try{
            Produto aux = Estoque.buscar(codigo);
            if(aux == null){
                throw new PNEException();       // Checa se o produto existe
            }
            else{
                int qntEstoque = 0;
                qntEstoque += aux.getQuantidade() + quantidade;
                aux.setQuantidade(qntEstoque);
               try{
                   Estoque.apagar(codigo);
                   Estoque.adicionar(aux);
                   JOptionPane.showMessageDialog(null, quantidade + " unidades estocadas. ");
               } catch(PJCException e) { }
            }
        } catch (PNEException e){
            JOptionPane.showMessageDialog(null, "Produto não encontrado. ");
        }

    }
    
    public void venderProduto(String codigo, int quantidade) throws PNEException{
        
        try{
            Produto aux = Estoque.buscar(codigo);
            int novaQnt = aux.getQuantidade() - quantidade;
            
            if(aux == null){
                throw new PNEException();               // Produto não foi encontrado.
            } else{
                try{
                    if(novaQnt < 0){
                        throw new IndexOutOfBoundsException(); // tentando vender mais do que possui
                    } 
                    else{
                        aux.setQuantidade(novaQnt);
                        JOptionPane.showMessageDialog(null, novaQnt + " unidades restantes.");
                        
                        try{
                            Estoque.apagar(codigo);
                            Estoque.adicionar(aux);
                        } catch(PJCException e) { }
                    }
                }
                catch(IndexOutOfBoundsException e){ 
                    JOptionPane.showMessageDialog(null,  "Tentando vender mais que possui do produto.");
                }  
            }
        }catch (PNEException e){ 
            JOptionPane.showMessageDialog(null, "Produto não encontrado. ");
        }
       
    }
    
    public Produto consultarProduto (String codigo) throws PNEException{
        Produto aux = Estoque.buscar(codigo);
        
        try{
            if(aux == null){
                throw new PNEException();
            }
            
            
        } catch(PNEException e) { 
            JOptionPane.showMessageDialog(null, "Produto não encontrado. ");
        } 
        
        return aux;
    }
   
    
    public Produto[] listarProdutos(){
        File arquivo[] = bancodedados.listadeArquivos();    
        
        Produto[] produtos = new Produto[bancodedados.tamanhoBanco()] ; // criar um vetor dinamico
        Produto produtoaux;

        for (int i = 0; i < bancodedados.tamanhoBanco()  ; i++){
            
            String nomeArquivo = arquivo[i].getName();      // pega o nome de cada arquivo no estoque
            String arrayAux[] = nomeArquivo.split(".txt");  // retira o ".txt"
            
            try {
                produtoaux = Estoque.buscar(arrayAux[0]);   // variavel auxiliar que vai salvar o que for retornado no buscar
                produtos[i] = produtoaux;                   // salva os produtos no array
            } catch (PNEException ex) { }                   // nao precisa de tramamento
        }
        return produtos;
    }
    

    public Produto[] listarProdutosEmFalta() throws PNEException {
        File arquivo[] = bancodedados.listadeArquivos();  
        
        Produto produtoaux;
        
// roda uma vez, contando quantos produtos estão em estoque

        int contador = 0;
        
        for (int i = 0; i < bancodedados.tamanhoBanco(); i++){
            String nomeArquivo = arquivo[i].getName();      // pega o nome de cada arquivo no estoque
            String arrayAux[] = nomeArquivo.split(".txt");  // retira o ".txt"
            produtoaux = Estoque.buscar(arrayAux[0]);
            if(produtoaux.getQuantidade() == 0){
                contador++;
            }
        }
        
    // Atributos  "reais" 
        
        Produto produto[] = new Produto[contador]; // cria um array com a quantidade certa de produtos
        int contadorReal = 0;
        
        for (int j = 0; j < bancodedados.tamanhoBanco(); j++){
            String nomeArquivo = arquivo[j].getName();      // pega o nome de cada arquivo no estoque
            String arrayAux[] = nomeArquivo.split(".txt");  // retira o ".txt"
            produtoaux = Estoque.buscar(arrayAux[0]);
            
            if (produtoaux.getQuantidade() == 0) {
                produto[contadorReal] = produtoaux;
                contadorReal++;
            }
        }
        System.out.println(Arrays.toString(produto));
        return produto;
    }
    

    
    
    
}
