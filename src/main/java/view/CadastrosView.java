/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.mycompany.projetohospitalmaven.ProjetoHospitalMaven;
import controller.AcompanhanteController;
import controller.MedicoController;
import controller.PacienteController;
import controller.UsuarioController;


public class CadastrosView extends javax.swing.JFrame {

    public CadastrosView() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCadastroPaciente = new javax.swing.JButton();
        btCadastroUsuario = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btCadastroEnfermeiro = new javax.swing.JButton();
        btCadastroFarmaceutico = new javax.swing.JButton();
        btCadastroFornecedor = new javax.swing.JButton();
        btCadastroMedico = new javax.swing.JButton();
        btCadastroAcompanhante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btCadastroPaciente.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroPaciente.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroPaciente.setText("Cadastro de Paciente");
        btCadastroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroPacienteActionPerformed(evt);
            }
        });

        btCadastroUsuario.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroUsuario.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroUsuario.setText("Cadastro de Usuário");
        btCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroUsuarioActionPerformed(evt);
            }
        });

        btVoltar.setBackground(new java.awt.Color(0, 204, 204));
        btVoltar.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btCadastroEnfermeiro.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroEnfermeiro.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroEnfermeiro.setText("Cadastro de Enfermeiro");
        btCadastroEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroEnfermeiroActionPerformed(evt);
            }
        });

        btCadastroFarmaceutico.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroFarmaceutico.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroFarmaceutico.setText("Cadastro de Farmacêutico");
        btCadastroFarmaceutico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroFarmaceuticoActionPerformed(evt);
            }
        });

        btCadastroFornecedor.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroFornecedor.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroFornecedor.setText("Cadastro de Fornecedor");
        btCadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroFornecedorActionPerformed(evt);
            }
        });

        btCadastroMedico.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroMedico.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroMedico.setText("Cadastro de Médico");
        btCadastroMedico.setToolTipText("");
        btCadastroMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroMedicoActionPerformed(evt);
            }
        });

        btCadastroAcompanhante.setBackground(new java.awt.Color(0, 204, 204));
        btCadastroAcompanhante.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btCadastroAcompanhante.setText("Cadastro de Acompanhante");
        btCadastroAcompanhante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroAcompanhanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btCadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCadastroPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCadastroEnfermeiro, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btCadastroFornecedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCadastroFarmaceutico, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btCadastroMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btCadastroAcompanhante, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastroFarmaceutico, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastroEnfermeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastroMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCadastroAcompanhante, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroPacienteActionPerformed
        PacienteForm paciente = new PacienteForm(null, true);
        PacienteController pacienteController = new PacienteController(paciente);
       paciente.setVisible(true);
    }//GEN-LAST:event_btCadastroPacienteActionPerformed

    private void btCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroUsuarioActionPerformed
       UsuarioForm usuario = new UsuarioForm(null, true);
       UsuarioController usuarioController = new UsuarioController(usuario);
       usuario.setVisible(true);
    }//GEN-LAST:event_btCadastroUsuarioActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
      ProjetoHospitalMaven principal = new ProjetoHospitalMaven();
      principal.setVisible(true);
      dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastroEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroEnfermeiroActionPerformed
     new EnfermeiroForm().setVisible(true);
    }//GEN-LAST:event_btCadastroEnfermeiroActionPerformed

    private void btCadastroFarmaceuticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroFarmaceuticoActionPerformed
       new FarmaceuticoForm().setVisible(true);
    }//GEN-LAST:event_btCadastroFarmaceuticoActionPerformed

    private void btCadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroFornecedorActionPerformed
      new FornecedorForm().setVisible(true);
    }//GEN-LAST:event_btCadastroFornecedorActionPerformed

    private void btCadastroMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroMedicoActionPerformed
        MedicoForm medico = new MedicoForm(null, true);
        MedicoController medicoController = new MedicoController(medico);
        medico.setVisible(true);
    }//GEN-LAST:event_btCadastroMedicoActionPerformed

    private void btCadastroAcompanhanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroAcompanhanteActionPerformed
        AcompanhanteForm acompanhante = new AcompanhanteForm(null, true);
        AcompanhanteController acompanhanteController = new AcompanhanteController(acompanhante);
        acompanhante.setVisible(true);
    }//GEN-LAST:event_btCadastroAcompanhanteActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastroAcompanhante;
    private javax.swing.JButton btCadastroEnfermeiro;
    private javax.swing.JButton btCadastroFarmaceutico;
    private javax.swing.JButton btCadastroFornecedor;
    private javax.swing.JButton btCadastroMedico;
    private javax.swing.JButton btCadastroPaciente;
    private javax.swing.JButton btCadastroUsuario;
    private javax.swing.JButton btVoltar;
    // End of variables declaration//GEN-END:variables
}
