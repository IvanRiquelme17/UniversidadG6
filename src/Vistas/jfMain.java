/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author Martin
 */
public class jfMain extends javax.swing.JFrame {

    /**
     * Creates new form jfMain
     */
    public jfMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane();
        jPanelPrincipal = new javax.swing.JPanel();
        jBFormMateria = new javax.swing.JButton();
        jBFormAlumno = new javax.swing.JButton();
        jBFormInscrip = new javax.swing.JButton();
        jBCargaNotas = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktop.setDesktopManager(null);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelPrincipal.setBackground(new java.awt.Color(9, 96, 62));
        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Universidad Grupo 6", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 71))); // NOI18N
        jPanelPrincipal.setForeground(new java.awt.Color(9, 96, 62));

        jBFormMateria.setBackground(new java.awt.Color(6, 115, 70));
        jBFormMateria.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBFormMateria.setForeground(new java.awt.Color(255, 255, 255));
        jBFormMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Materia.png"))); // NOI18N
        jBFormMateria.setText("Formulario Materias");
        jBFormMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFormMateriaActionPerformed(evt);
            }
        });

        jBFormAlumno.setBackground(new java.awt.Color(6, 115, 70));
        jBFormAlumno.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBFormAlumno.setForeground(new java.awt.Color(255, 255, 255));
        jBFormAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alumno.png"))); // NOI18N
        jBFormAlumno.setText("Formulario Alumnos");
        jBFormAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFormAlumnoActionPerformed(evt);
            }
        });

        jBFormInscrip.setBackground(new java.awt.Color(6, 115, 70));
        jBFormInscrip.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBFormInscrip.setForeground(new java.awt.Color(255, 255, 255));
        jBFormInscrip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Inscripcion.png"))); // NOI18N
        jBFormInscrip.setText("Formulario Inscripci??n");
        jBFormInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFormInscripActionPerformed(evt);
            }
        });

        jBCargaNotas.setBackground(new java.awt.Color(6, 115, 70));
        jBCargaNotas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBCargaNotas.setForeground(new java.awt.Color(255, 255, 255));
        jBCargaNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CargaNota.png"))); // NOI18N
        jBCargaNotas.setText("Carga de Notas");
        jBCargaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargaNotasActionPerformed(evt);
            }
        });

        jBSalir.setBackground(new java.awt.Color(51, 68, 61));
        jBSalir.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(255, 255, 255));
        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salir.png"))); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 71));
        jLabel1.setText("Proyecto Transversal");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/emblem.png"))); // NOI18N

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBFormAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFormMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFormInscrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCargaNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jBFormMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBFormAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBFormInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jBCargaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCargaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargaNotasActionPerformed
        jDesktop.removeAll();
        jDesktop.repaint();
        jifCargaNotas formCargaNotas = new jifCargaNotas();
        formCargaNotas.setVisible(true);
        jDesktop.add(formCargaNotas);
    }//GEN-LAST:event_jBCargaNotasActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBFormAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFormAlumnoActionPerformed
        jDesktop.removeAll();
        jDesktop.repaint();
        jifFormAlumno formAlumno = new jifFormAlumno();
        formAlumno.setVisible(true);
        jDesktop.add(formAlumno);
    }//GEN-LAST:event_jBFormAlumnoActionPerformed

    private void jBFormInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFormInscripActionPerformed
        jDesktop.removeAll();
        jDesktop.repaint();
        jifInscripcion formInscrip = new jifInscripcion();
        formInscrip.setVisible(true);
        jDesktop.add(formInscrip);
    }//GEN-LAST:event_jBFormInscripActionPerformed

    private void jBFormMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFormMateriaActionPerformed
        jDesktop.removeAll();
        jDesktop.repaint();
        jifFormMateria formMateria = new jifFormMateria();
        formMateria.setVisible(true);
        jDesktop.add(formMateria);
    }//GEN-LAST:event_jBFormMateriaActionPerformed

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
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCargaNotas;
    private javax.swing.JButton jBFormAlumno;
    private javax.swing.JButton jBFormInscrip;
    private javax.swing.JButton jBFormMateria;
    private javax.swing.JButton jBSalir;
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
