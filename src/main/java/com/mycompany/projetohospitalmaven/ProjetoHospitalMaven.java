/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetohospitalmaven;

import controller.AlaController;
import controller.ExameController;
import controller.InternacaoController;
import controller.JornadaController;
import controller.LaboratorioController;
import controller.MedicamentoController;
import controller.QuartoController;
import controller.ReceitaController;

import javax.swing.JFrame;
import view.AlaForm;
import view.AtendimentoForm;
import view.CadastrosView;
import view.ConsultaForm;
import view.ExameForm;
import view.InternacaoForm;
import view.JornadaForm;
import view.LaboratorioForm;
import view.MedicamentoForm;
import view.ProntuarioForm;
import view.QuartoForm;
import view.ReceitaForm;

public class ProjetoHospitalMaven extends javax.swing.JFrame {

    public ProjetoHospitalMaven() {
        initComponents();
  
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btInternacao = new javax.swing.JButton();
        btLaboratorio = new javax.swing.JButton();
        btMedicamento = new javax.swing.JButton();
        btReceita = new javax.swing.JButton();
        btAtendimento = new javax.swing.JButton();
        btCadastros = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();
        btExame = new javax.swing.JButton();
        btAla = new javax.swing.JButton();
        btReceita1 = new javax.swing.JButton();
        btQuarto = new javax.swing.JButton();
        btJornada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAtendimento = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 234, 234));

        btInternacao.setBackground(new java.awt.Color(0, 204, 204));
        btInternacao.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btInternacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cama-hospitalar.png"))); // NOI18N
        btInternacao.setText("Internação");
        btInternacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInternacaoActionPerformed(evt);
            }
        });

        btLaboratorio.setBackground(new java.awt.Color(0, 204, 204));
        btLaboratorio.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/laboratorio.png"))); // NOI18N
        btLaboratorio.setText("Laboratório");
        btLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLaboratorioActionPerformed(evt);
            }
        });

        btMedicamento.setBackground(new java.awt.Color(0, 204, 204));
        btMedicamento.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/medicina.png"))); // NOI18N
        btMedicamento.setText("Medicamento");
        btMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedicamentoActionPerformed(evt);
            }
        });

        btReceita.setBackground(new java.awt.Color(0, 204, 204));
        btReceita.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/receita.png"))); // NOI18N
        btReceita.setText("Receita");
        btReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceitaActionPerformed(evt);
            }
        });

        btAtendimento.setBackground(new java.awt.Color(0, 204, 204));
        btAtendimento.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone.png"))); // NOI18N
        btAtendimento.setText("Atendimento");
        btAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtendimentoActionPerformed(evt);
            }
        });

        btCadastros.setBackground(new java.awt.Color(0, 204, 204));
        btCadastros.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa.png"))); // NOI18N
        btCadastros.setText("Cadastros");
        btCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrosActionPerformed(evt);
            }
        });

        btConsulta.setBackground(new java.awt.Color(0, 204, 204));
        btConsulta.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendario.png"))); // NOI18N
        btConsulta.setText("Consulta");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });

        btExame.setBackground(new java.awt.Color(0, 204, 204));
        btExame.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exame.png"))); // NOI18N
        btExame.setText("Exame");
        btExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExameActionPerformed(evt);
            }
        });

        btAla.setBackground(new java.awt.Color(0, 204, 204));
        btAla.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btAla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cama-hospitalar.png"))); // NOI18N
        btAla.setText("Ala");
        btAla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlaActionPerformed(evt);
            }
        });

        btReceita1.setBackground(new java.awt.Color(0, 204, 204));
        btReceita1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btReceita1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/receita.png"))); // NOI18N
        btReceita1.setText("Prontuário");
        btReceita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceita1ActionPerformed(evt);
            }
        });

        btQuarto.setBackground(new java.awt.Color(0, 204, 204));
        btQuarto.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cama-hospitalar.png"))); // NOI18N
        btQuarto.setText("Quarto");
        btQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuartoActionPerformed(evt);
            }
        });

        btJornada.setBackground(new java.awt.Color(0, 204, 204));
        btJornada.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa.png"))); // NOI18N
        btJornada.setText("Jornada");
        btJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJornadaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/hospital-image.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExame, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAla, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btReceita1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExame, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAla, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReceita1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        menuAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/hospital-icon.png"))); // NOI18N
        menuAtendimento.setToolTipText("");
        menuAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtendimentoActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuAtendimento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrosActionPerformed
        new CadastrosView().setVisible(true);
    }//GEN-LAST:event_btCadastrosActionPerformed

    private void btAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtendimentoActionPerformed
        new AtendimentoForm().setVisible(true);
    }//GEN-LAST:event_btAtendimentoActionPerformed

    private void menuAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtendimentoActionPerformed
        new AtendimentoForm().setVisible(true);
    }//GEN-LAST:event_menuAtendimentoActionPerformed

    private void btExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExameActionPerformed
          ExameForm telaCadastroExame = new ExameForm(null, true);
        ExameController exameController = new ExameController(telaCadastroExame);
        telaCadastroExame.setVisible(true);
        
    }//GEN-LAST:event_btExameActionPerformed

    private void btInternacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInternacaoActionPerformed
        InternacaoForm internacao = new InternacaoForm(null, true);
        InternacaoController internacaoController = new InternacaoController(internacao);
        internacao.setVisible(true);
    }//GEN-LAST:event_btInternacaoActionPerformed

    private void btMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedicamentoActionPerformed
         MedicamentoForm telaCadastroMedicamento = new MedicamentoForm(null, true);
        MedicamentoController controllerCadastroMedicamento = new MedicamentoController(telaCadastroMedicamento);
        telaCadastroMedicamento.setVisible(true);
    }//GEN-LAST:event_btMedicamentoActionPerformed

    private void btLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLaboratorioActionPerformed
       LaboratorioForm telaCadastroLaboratorio = new LaboratorioForm(null, true);
        LaboratorioController controllerCadastroLaboratorio = new LaboratorioController(telaCadastroLaboratorio);
        telaCadastroLaboratorio.setVisible(true);
    }//GEN-LAST:event_btLaboratorioActionPerformed

    private void btReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceitaActionPerformed
     ReceitaForm receita = new ReceitaForm(null, true);
     ReceitaController receitaController = new ReceitaController(receita);
     receita.setVisible(true);
    }//GEN-LAST:event_btReceitaActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        new ConsultaForm().setVisible(true);
    }//GEN-LAST:event_btConsultaActionPerformed

    private void btAlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlaActionPerformed
        AlaForm ala = new AlaForm(null, true);
        AlaController alaController = new AlaController(ala);
        ala.setVisible(true);
    }//GEN-LAST:event_btAlaActionPerformed

    private void btReceita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceita1ActionPerformed
        new ProntuarioForm().setVisible(true);
    }//GEN-LAST:event_btReceita1ActionPerformed

    private void btQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuartoActionPerformed
        QuartoForm quarto = new QuartoForm(null, true);
        QuartoController quartoController = new QuartoController(quarto);
        quarto.setVisible(true);
    }//GEN-LAST:event_btQuartoActionPerformed

    private void btJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJornadaActionPerformed
        JornadaForm jornada = new JornadaForm(null, true);
        JornadaController jornadaController = new JornadaController(jornada);
        jornada.setVisible(true);
    }//GEN-LAST:event_btJornadaActionPerformed

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
            java.util.logging.Logger.getLogger(ProjetoHospitalMaven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjetoHospitalMaven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjetoHospitalMaven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjetoHospitalMaven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjetoHospitalMaven().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAla;
    private javax.swing.JButton btAtendimento;
    private javax.swing.JButton btCadastros;
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btExame;
    private javax.swing.JButton btInternacao;
    private javax.swing.JButton btJornada;
    private javax.swing.JButton btLaboratorio;
    private javax.swing.JButton btMedicamento;
    private javax.swing.JButton btQuarto;
    private javax.swing.JButton btReceita;
    private javax.swing.JButton btReceita1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAtendimento;
    // End of variables declaration//GEN-END:variables
}
