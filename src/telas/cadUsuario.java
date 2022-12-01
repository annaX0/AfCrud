/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Usuario;
import conexoes.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author annas
 */
public class cadUsuario extends javax.swing.JFrame {
       MySQL conectar = new MySQL();
       Usuario novoUsuario = new Usuario();
    /**
     * Creates new form cadUsuario
     */
    public cadUsuario() {
        initComponents();
    }
    
    private void cadastraUsuario(Usuario novoUsuario){
        
    this.conectar.conectaBanco();
    novoUsuario.setNome(txtNone.getText());
    novoUsuario.setEmail(txtEmail.getText());
    novoUsuario.setSenha(txtSenha.getText());
    
    try{
     this.conectar.insertSQL("INSERT INTO usuario("
            + " nome, "
            + " email, "
            + " senha " 
            + ") VALUES ("
            + "'" + novoUsuario.getNome() + "',"            
            + "'" + novoUsuario.getEmail()+ "',"
            + "'" + novoUsuario.getSenha()+ "'"
            + ");");
        } catch (Exception e){
            System.err.println("Erro ao cadastrar Usuario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuario");
        } finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Usuario cadastro com sucesso");    
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
        jLabel1 = new javax.swing.JLabel();
        txtNone = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnCad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(755, 544));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Novo Usuário");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(280, 30, 270, 25);
        jPanel1.add(txtNone);
        txtNone.setBounds(210, 120, 366, 37);
        jPanel1.add(txtSenha);
        txtSenha.setBounds(210, 280, 366, 37);

        jLabel2.setText("Senha");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 260, 80, 16);

        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 100, 37, 16);

        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(200, 180, 37, 16);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(210, 200, 366, 37);

        btnCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mole.png"))); // NOI18N
        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });
        jPanel1.add(btnCad);
        btnCad.setBounds(330, 430, 120, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        cadastraUsuario(novoUsuario);
        new Login().setVisible(true);
        dispose();

    }//GEN-LAST:event_btnCadActionPerformed

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
            java.util.logging.Logger.getLogger(cadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNone;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
