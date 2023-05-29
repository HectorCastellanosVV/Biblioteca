/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Herramientas.ConvertirDate;
import control.ClienteJpaController;
import control.VisitaJpaController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;
import modelo.Visita;

/**
 *
 * @author Hector
 */
public class IngresoCliente extends javax.swing.JFrame {
    private Cliente cliente;
    private ClienteJpaController clienteController;
    private Visita visita;
    private VisitaJpaController visitaController;
    private ConvertirDate cd=new ConvertirDate();
    
    public IngresoCliente() {
        initComponents();
        initComponents();
        EntityManagerFactory emt=Persistence.createEntityManagerFactory("BibliotecaPPU");
        clienteController=new ClienteJpaController(emt);
        visitaController=new VisitaJpaController(emt);
    }

    private void agregarCliente()
    {
        String date;
        LocalDate fechaA=LocalDate.now();
        date=""+fechaA;
        String nombreC=nombrelb.getText();
        String numeroT=numerolb.getText();
        String correoE=correolb.getText();
        Date fecha=cd.ParseFecha(date);
        Date hora=cd.ParseHora(horalb.getText());
        
        cliente=new Cliente();
        cliente.setNombre(nombreC);
        cliente.setNumTelefono(numeroT);
        cliente.setCorreo(correoE);
        
        clienteController.create(cliente);
        cliente.getIdUsuario();
        visita=new Visita();
        visita.setIdUsuario(cliente);
        visita.setFecha(fecha);
        visita.setHoraIngreso(hora);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        horalb = new javax.swing.JTextField();
        nombrelb = new javax.swing.JTextField();
        numerolb = new javax.swing.JTextField();
        correolb = new javax.swing.JTextField();
        panelRound1 = new Herramientas.PanelRound();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(22, 22, 26));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(148, 161, 178));
        jLabel1.setText("HORA DE INGRESO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESO DE CLIENTES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 220, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 161, 178));
        jLabel3.setText("NOMBRE DEL CLIENTE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(148, 161, 178));
        jLabel4.setText("NÚMERO DE TELEFONO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 170, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(148, 161, 178));
        jLabel5.setText("CORREO ELECTRONICO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 170, 30));

        horalb.setBackground(new java.awt.Color(22, 22, 26));
        horalb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        horalb.setForeground(new java.awt.Color(255, 255, 255));
        horalb.setText("00:00:00");
        horalb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        horalb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horalbMouseClicked(evt);
            }
        });
        jPanel1.add(horalb, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 190, 30));

        nombrelb.setBackground(new java.awt.Color(22, 22, 26));
        nombrelb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombrelb.setForeground(new java.awt.Color(255, 255, 255));
        nombrelb.setText("Nombre completo");
        nombrelb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        nombrelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombrelbMouseClicked(evt);
            }
        });
        jPanel1.add(nombrelb, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 190, 30));

        numerolb.setBackground(new java.awt.Color(22, 22, 26));
        numerolb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numerolb.setForeground(new java.awt.Color(255, 255, 255));
        numerolb.setText("000-000-0000");
        numerolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        numerolb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numerolbMouseClicked(evt);
            }
        });
        jPanel1.add(numerolb, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 190, 30));

        correolb.setBackground(new java.awt.Color(22, 22, 26));
        correolb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correolb.setForeground(new java.awt.Color(255, 255, 255));
        correolb.setText("ejepmlo@gmail.com");
        correolb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        correolb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correolbMouseClicked(evt);
            }
        });
        jPanel1.add(correolb, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 190, 30));

        panelRound1.setBackground(new java.awt.Color(127, 90, 240));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Agregar");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nombrelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombrelbMouseClicked
        nombrelb.setText(" ");
    }//GEN-LAST:event_nombrelbMouseClicked

    private void numerolbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numerolbMouseClicked
        numerolb.setText(" ");
    }//GEN-LAST:event_numerolbMouseClicked

    private void correolbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correolbMouseClicked
        correolb.setText(" ");
    }//GEN-LAST:event_correolbMouseClicked

    private void horalbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horalbMouseClicked
        horalb.setText(" ");
    }//GEN-LAST:event_horalbMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        agregarCliente();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(IngresoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correolb;
    private javax.swing.JTextField horalb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombrelb;
    private javax.swing.JTextField numerolb;
    private Herramientas.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
