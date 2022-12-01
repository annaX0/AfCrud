/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Funcionarios;
import conexoes.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author annas
 */
public class Pesquisa extends javax.swing.JFrame {
       MySQL conectar = new MySQL();
       Funcionarios novoFuncionario = new Funcionarios();
    /**
     * Creates new form Cadastro
     */
    public Pesquisa() {
        initComponents();
        
    }
    
    private void pesquisaFuncionario(Funcionarios novoFuncionario){
    this.conectar.conectaBanco();
        
        String pesquisaFuncionario = txtCpf.getText();
        
        try{
        this.conectar.executarSQL("SELECT "
            + " nome,"
            + " cpf,"
            + " funcao,"
            + " telefone,"
            + " endereco,"
            + " salario" 
            + " FROM "
            + " funcionarios "
            + " WHERE "
            + " cpf = '" + pesquisaFuncionario + "'" + ";"
        );
        while (this.conectar.getResultSet().next()){
            novoFuncionario.setNome(this.conectar.getResultSet().getString(1));
            novoFuncionario.setCPF(this.conectar.getResultSet().getString(2));
            novoFuncionario.setFuncao(this.conectar.getResultSet().getString(3));
            novoFuncionario.setTelefone(this.conectar.getResultSet().getString(4));
            novoFuncionario.setEndereco(this.conectar.getResultSet().getString(5));
            novoFuncionario.setSalario(this.conectar.getResultSet().getString(6));

        }
        if (novoFuncionario.getNome() == ""){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");

        }
        
        } catch (Exception e){
            System.out.println("Erro ao consultar funcionario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário!");
            
        } finally{
            txtNone.setText(novoFuncionario.getNome());
            txtCpf.setText(novoFuncionario.getCPF());
            txtTelefone.setText(novoFuncionario.getTelefone());
            txtFuncao.setSelectedItem(novoFuncionario.getFuncao());
            txtEndereco.setText(novoFuncionario.getEndereco());
            txtSalario.setText(novoFuncionario.getSalario());

            this.conectar.fechaBanco();
                

        }
    }
    private void DeletaFuncionario(Funcionarios novoFuncionario){
        this.conectar.conectaBanco();
        
        String consultaCPF = this.txtCpf.getText();


        novoFuncionario.setNome(txtNone.getText());
        novoFuncionario.setCPF(txtCpf.getText());
        novoFuncionario.setTelefone(txtTelefone.getText());
        novoFuncionario.setFuncao((String) txtFuncao.getSelectedItem());
        novoFuncionario.setEndereco(txtEndereco.getText());
        novoFuncionario.setSalario(txtSalario.getText());
        
        try{
            this.conectar.updateSQL(
            " DELETE FROM funcionarios"
            + " WHERE"
            + " cpf = '" + consultaCPF + "'"
            );
        }catch(Exception e){
            System.out.println("Erro ao deletar funcionário" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar funcionário");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Funcionário deletado!");
        }
    }
    
    private void atualizaFuncionario(Funcionarios novoFuncionario){
        this.conectar.conectaBanco();

        String consultaCpf = this.txtCpf.getText();
        
        novoFuncionario.setNome(txtNone.getText());
        novoFuncionario.setCPF(txtCpf.getText());
        novoFuncionario.setTelefone(txtTelefone.getText());
        novoFuncionario.setFuncao((String) txtFuncao.getSelectedItem());
        novoFuncionario.setEndereco(txtEndereco.getText());
        novoFuncionario.setSalario(txtSalario.getText());
        
        try{
            this.conectar.updateSQL(
            " UPDATE funcionarios SET "
            + " nome = '" + novoFuncionario.getNome()+"'"
            + ", telefone = '" + novoFuncionario.getTelefone()+"'"
            + ", funcao = '" + novoFuncionario.getFuncao()+"'"
            + ", endereco = '" + novoFuncionario.getEndereco()+"'"
            + ", salario = '" + novoFuncionario.getSalario()+"'"
            + " WHERE"
            + " cpf = '"+ consultaCpf + "'" + ";"
            );
        }catch(Exception e){
            System.out.println("Erro ao atualizar funcionário" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário");
            
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Funcionário atualizado!");
        }    

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        txtSalario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtFuncao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(755, 544));
        jPanel1.setLayout(null);

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar);
        btnDeletar.setBounds(150, 550, 120, 50);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/binoculars.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisar);
        btnPesquisar.setBounds(330, 550, 120, 50);

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/updated.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar);
        btnAtualizar.setBounds(500, 550, 120, 50);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar);
        btnVoltar.setBounds(20, 30, 72, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa de Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel4.setText("CPF");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(120, 20, 530, 110);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel7.setText("Salário");

        jLabel5.setText("Função");

        jLabel6.setText("Endereço");

        jLabel3.setText("Nome");

        jLabel2.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porteiro", "Jardineiro", "Faxineira", "Cozinheira" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFuncao, 0, 470, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTelefone)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNone, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtNone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(120, 130, 530, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        DeletaFuncionario(novoFuncionario);
        txtNone.setText("");
        txtTelefone.setText("");
        txtFuncao.setSelectedItem("");
        txtEndereco.setText("");
        txtSalario.setText("");
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisaFuncionario(novoFuncionario);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizaFuncionario(novoFuncionario);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JComboBox<String> txtFuncao;
    private javax.swing.JTextField txtNone;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
