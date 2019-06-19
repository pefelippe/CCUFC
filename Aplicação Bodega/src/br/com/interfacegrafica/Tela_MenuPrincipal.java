package br.com.interfacegrafica;

import br.com.bodega.Bodega;
import br.com.estoque.EstoqueArray;
import br.com.estoque.EstoqueVector;
import br.com.exceptions.PJCException;
import br.com.exceptions.PNEException;
import br.com.produto.Produto;
import java.awt.Color;
import java.util.Arrays;

public class Tela_MenuPrincipal extends javax.swing.JFrame {

    public Tela_MenuPrincipal() {
        initComponents();
        setTitle("Aplicação Bodega");        
        setBackground(new Color(53,33,89));
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        bt_consultar = new javax.swing.JButton();
        bt_listar = new javax.swing.JButton();
        bt_cad2 = new javax.swing.JButton();
        bt_vender = new javax.swing.JButton();
        bt_rem = new javax.swing.JButton();
        bt_cad1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bt_estocar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(54, 33, 89));
        setLocation(new java.awt.Point(500, 100));

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setBorder(null);

        bt_consultar.setText("Consultar Produto");
        bt_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_consultarActionPerformed(evt);
            }
        });

        bt_listar.setText("Listar Produtos");
        bt_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listarActionPerformed(evt);
            }
        });

        bt_cad2.setText("Cadastrar Produto Perecivel");
        bt_cad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cad2ActionPerformed(evt);
            }
        });

        bt_vender.setText("Vender Produto");
        bt_vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_venderActionPerformed(evt);
            }
        });

        bt_rem.setText("Remover Produto");
        bt_rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_remActionPerformed(evt);
            }
        });

        bt_cad1.setText("Cadastrar Produto Não-Perecível");
        bt_cad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cad1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(216, 35, 35));
        jLabel1.setText("Menu Principal");

        jLabel2.setBackground(new java.awt.Color(1, 1, 1));
        jLabel2.setFont(new java.awt.Font("Serif", 1, 22)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Aplicação Bodega v 1.0");

        bt_estocar.setText("Estocar Produto");
        bt_estocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_estocarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt_cad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_cad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_rem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_vender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_estocar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_listar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_cad2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_cad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_rem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_vender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_estocar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cad1ActionPerformed
        Tela_Cadastro1 show = new Tela_Cadastro1();
        show.setVisible(true);
        show.setTitle("Cadastro");        
        show.setBackground(new Color(53,33,89));
        show.setResizable(false);
        show.setLayout(null);
        show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        show.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_cad1ActionPerformed

    private void bt_cad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cad2ActionPerformed
        Tela_Cadastro2 show = new Tela_Cadastro2();
        show.setVisible(true);
        show.setTitle("Cadastro");        
        show.setBackground(new Color(53,33,89));
        show.setResizable(false);
        show.setLayout(null);
        show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        show.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_cad2ActionPerformed

    private void bt_remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_remActionPerformed
        Tela_Remover show = new Tela_Remover();
        show.setVisible(true);
        show.setTitle("Remover");        
        show.setBackground(new Color(53,33,89));
        show.setResizable(false);
        show.setLayout(null);
        show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        show.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_remActionPerformed

    private void bt_venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_venderActionPerformed
        Tela_Vender show = new Tela_Vender();
        show.setVisible(true);
        show.setTitle("Vender");        
        show.setBackground(new Color(53,33,89));
        show.setResizable(false);
        show.setLayout(null);
        show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        show.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_venderActionPerformed

    private void bt_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_consultarActionPerformed
        Tela_Consultar show = new Tela_Consultar();
        show.setVisible(true);
        show.setTitle("Consultar");        
        show.setBackground(new Color(53,33,89));
        show.setResizable(false);
        show.setLayout(null);
        show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        show.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_consultarActionPerformed

    private void bt_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listarActionPerformed
        Tela_Listar show;
        try {
            show = new Tela_Listar();
            show.setVisible(true);
            show.setTitle("Listar");        
            show.setBackground(new Color(53,33,89));
            show.setResizable(false);
            show.setLayout(null);
            show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            show.setLocationRelativeTo(null);
            
        } catch (PNEException ex) { }

    }//GEN-LAST:event_bt_listarActionPerformed

    private void bt_estocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_estocarActionPerformed
        Tela_Estocar show = new Tela_Estocar();
        show.setVisible(true);
        show.setTitle("Estocar");        
        show.setBackground(new Color(53,33,89));
        show.setResizable(false);
        show.setLayout(null);
        show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        show.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_estocarActionPerformed

   public static void main(String args[]) throws PJCException, PNEException {
       EstoqueVector estoque = new EstoqueVector();
       Bodega bodega =  new Bodega(estoque);
        
      /* Produto produto =  new Produto("tete");
       Produto produto2 = new Produto("teste");
       Produto produto3 = new Produto ("teste3");
       produto3.setQuantidade(1);
       
       estoque.adicionar(produto);
       estoque.adicionar(produto2);
       estoque.adicionar(produto3);
       
       //estoque.apagar("tete");
       //estoque.apagar("teste");
       //estoque.apagar("teste3");
       
       //produto3.setQuantidade(1);
       //estoque.adicionar(produto3);
       
       System.out.println(Arrays.toString(estoque.produtosEmEstoque()));
       System.out.println(Arrays.toString(estoque.produtosEmFalta())); */
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cad1;
    private javax.swing.JButton bt_cad2;
    private javax.swing.JButton bt_consultar;
    private javax.swing.JButton bt_estocar;
    private javax.swing.JButton bt_listar;
    private javax.swing.JButton bt_rem;
    private javax.swing.JButton bt_vender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
