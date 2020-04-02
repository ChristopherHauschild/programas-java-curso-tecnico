/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dominio.Comercial;
import dominio.Industrial;
import dominio.Residencial;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/*
    Christopher Hauschild Schott
    31/10/19
*/
public class CadastroConsumidor extends javax.swing.JFrame {

    /**
     * Creates new form CadastroConsumidor
     */
    
    public static String formatarCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
    
    public static String formatarCNPJ(String CNPJ) {
        return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "."
                + CNPJ.substring(5, 8) + "/" + CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
    }
  
    public static String formatarTelefone(String telefone) {
        String bloco1 = telefone.substring(0, 2);
        String bloco2 = telefone.substring(2, 7);
        String bloco3 = telefone.substring(7, 11);
        return ("("+bloco1+") "+bloco2+"-"+bloco3);
    }
    
    public static String formatarTelefone2(String telefone2) {
        String bloco1 = telefone2.substring(0, 2);
        String bloco2 = telefone2.substring(2, 6);
        String bloco3 = telefone2.substring(6, 10);
        return ("("+bloco1+") "+bloco2+"-"+bloco3);
    }
    
        public static boolean testarCNPJ(String CNPJ) {
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

        
    public static boolean testarCPF(String CPF) {
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); 
            }
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
    
    public CadastroConsumidor() {
        initComponents();
        jComboBoxSetor.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonResidencial = new javax.swing.JRadioButton();
        jRadioButtonComercial = new javax.swing.JRadioButton();
        jRadioButtonIndustrial = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCpfCnpj = new javax.swing.JLabel();
        jTextFieldCpfCnpj = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSetor = new javax.swing.JComboBox<>();
        jButtonCancelar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de consumidor");

        jPanel1.setBackground(new java.awt.Color(236, 227, 219));

        buttonGroup1.add(jRadioButtonResidencial);
        jRadioButtonResidencial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonResidencial.setText("Residencial");
        jRadioButtonResidencial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonResidencialMouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButtonComercial);
        jRadioButtonComercial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonComercial.setText("Comercial");
        jRadioButtonComercial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonComercialMouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButtonIndustrial);
        jRadioButtonIndustrial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonIndustrial.setText("Industrial");
        jRadioButtonIndustrial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonIndustrialMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabelCpfCnpj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCpfCnpj.setText("CPF / CNPJ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Telefone");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Setor");

        jComboBoxSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSetor.setSelectedIndex(-1);

        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("CADASTRAR");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jRadioButtonResidencial)
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButtonComercial)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButtonIndustrial))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNome)
                                .addComponent(jLabel1)
                                .addComponent(jLabelCpfCnpj)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jComboBoxSetor, 0, 333, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonResidencial)
                    .addComponent(jRadioButtonComercial)
                    .addComponent(jRadioButtonIndustrial))
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCpfCnpj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:
        String nome = jTextFieldNome.getText();
        String cpf_cnpj = jTextFieldCpfCnpj.getText();
        String telefone = jTextFieldTelefone.getText();
        
        Residencial res = null;
        Comercial com = null;
        Industrial ind = null;
        
        if (jRadioButtonResidencial.isSelected()){
            
            
        if (testarCPF(cpf_cnpj)) {
            
            String cpf = (formatarCPF(cpf_cnpj));
            telefone = (formatarTelefone(telefone));
            
            res = new Residencial(nome, cpf, telefone);

            System.out.println(res);
            Principal.setResidencial(res);
            Principal.atualizarjComboBoxConsumidor();
            
        } else {
            JOptionPane.showMessageDialog(null, "Insira um CPF válido");
        }
            
        }
        
        if (jRadioButtonComercial.isSelected()){
            
            String email = jTextFieldEmail.getText();
            
            if (testarCNPJ(cpf_cnpj)) {
            String cnpj = (formatarCNPJ(cpf_cnpj));
            telefone = (formatarTelefone2(telefone));
            
            com = new Comercial(nome, cnpj, telefone, email);
            
            System.out.println(com);
            Principal.setComercial(com);
            Principal.atualizarjComboBoxConsumidor();
            }
            else{
                JOptionPane.showMessageDialog(null, "Insira um CNPJ Válido");
            }
            
        }
        
        if (jRadioButtonIndustrial.isSelected()){
            
            String email = jTextFieldEmail.getText();
            String setor = jComboBoxSetor.getSelectedItem().toString();
            
            if (testarCNPJ(cpf_cnpj)) {
            String cnpj = (formatarCNPJ(cpf_cnpj));
            telefone = (formatarTelefone2(telefone));
            
            ind = new Industrial(nome, cnpj, telefone, email, setor);
            
            System.out.println(ind);
            Principal.setIndustrial(ind);
            Principal.atualizarjComboBoxConsumidor();
            }
            else{
                JOptionPane.showMessageDialog(null, "Insira um CNPJ Válido");
            }
            
        }
        
        String aviso = "Deseja cadastrar outro consumidor?";
        String titulo = "Confirmação";
        int retorno = JOptionPane.showConfirmDialog(null, aviso, titulo, JOptionPane.YES_NO_OPTION);
        if (retorno == JOptionPane.NO_OPTION){
            this.dispose();
        }
        
        jTextFieldNome.setText("");
        jTextFieldCpfCnpj.setText("");
        jTextFieldEmail.setText("");
        jTextFieldTelefone.setText("");
        
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonResidencialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonResidencialMouseClicked
        // TODO add your handling code here:
        jLabelCpfCnpj.setText("CPF");
    }//GEN-LAST:event_jRadioButtonResidencialMouseClicked

    private void jRadioButtonComercialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonComercialMouseClicked
        // TODO add your handling code here:
        jTextFieldEmail.setEnabled(true);
        jLabelCpfCnpj.setText("CNPJ");
    }//GEN-LAST:event_jRadioButtonComercialMouseClicked

    private void jRadioButtonIndustrialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonIndustrialMouseClicked
        // TODO add your handling code here:
        jTextFieldEmail.setEnabled(true);
        jComboBoxSetor.setEnabled(true);
        jLabelCpfCnpj.setText("CNPJ");
    }//GEN-LAST:event_jRadioButtonIndustrialMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroConsumidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCpfCnpj;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonComercial;
    private javax.swing.JRadioButton jRadioButtonIndustrial;
    private javax.swing.JRadioButton jRadioButtonResidencial;
    private javax.swing.JTextField jTextFieldCpfCnpj;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
