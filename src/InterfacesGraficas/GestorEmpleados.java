/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesGraficas;

import Modelos.Empleadosf1;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.*;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class GestorEmpleados extends javax.swing.JFrame {
     private CardLayout card;
     private List<Empleadosf1> listaGlobal;
     
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestorEmpleados.class.getName());

    public GestorEmpleados(List<Empleadosf1> listaRecibida) {
        initComponents();
        this.listaGlobal = listaRecibida;
        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestor Empleados");
        try {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/jefe-de-equipo.png"));
        this.setIconImage(icon);
    } catch (Exception e) {
        System.out.println("No se pudo cargar el icono: " + e.getMessage());
    }
        setResizable(false);
        
    }

    GestorEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos_f1.dat"))) {
            DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
            oos.writeObject(modelo.getDataVector()); // Guarda el vector de datos de la tabla
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    

    private void cargarDatos() {
       File archivo = new File("datos_f1.dat");
    if (archivo.exists()) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Vector datos = (Vector) ois.readObject();
            DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
            
            for (Object fila : datos) {
                Vector vFila = (Vector) fila;
                modelo.addRow(vFila); 
           
                String nombre = vFila.get(0).toString();
                int edad = Integer.parseInt(vFila.get(1).toString());
                String rol = vFila.get(2).toString();
                String id = vFila.get(3).toString();
                double salario = Double.parseDouble(vFila.get(4).toString());
                
                Modelos.ContratoEmpleados contrato = new Modelos.ContratoEmpleados(new java.util.Date(), 0, salario, 0, rol);
                Modelos.Empleadosf1 emp = new Modelos.Empleadosf1(id, nombre, edad, rol, contrato);
                
                listaGlobal.add(emp);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar: " + e.getMessage());
        }
    }
    }
    private void guardarPilotos() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pilotos_f1.dat"))) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        oos.writeObject(modelo.getDataVector()); 
    } catch (IOException e) {
        System.err.println("Error al guardar pilotos: " + e.getMessage());
    }
    }

    private void cargarPilotos() {
        File archivo = new File("pilotos_f1.dat");
    if (archivo.exists()) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            java.util.Vector datos = (java.util.Vector) ois.readObject();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Object fila : datos) {
                Vector vFila = (Vector) fila;
                modelo.addRow(vFila);
                
                //extraer datos para la listita global
                String nombre = vFila.get(0).toString();
                int edad = Integer.parseInt(vFila.get(1).toString());
                String id = vFila.get(3).toString();
                double salario = Double.parseDouble(vFila.get(4).toString());
                
                Modelos.ContratoEmpleados contrato = new Modelos.ContratoEmpleados(new java.util.Date(), 0, salario, 0, "Piloto");
                Modelos.Empleadosf1 p = new Modelos.Empleadosf1(id, nombre, edad, "Piloto", contrato);
                
                listaGlobal.add(p); 
            }
        } catch (Exception e) {
            System.err.println("Error al cargar pilotos: " + e.getMessage());
        }
    }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPilotos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btEmpleados = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        btEmpleados1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpPilotos.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(66, 66, 87));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        btEmpleados.setBackground(new java.awt.Color(45, 46, 60));
        btEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btEmpleados.setText("Empleados");
        btEmpleados.addActionListener(this::btEmpleadosActionPerformed);

        jButton1.setBackground(new java.awt.Color(45, 46, 60));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pilotos");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PILOTOS");

        jScrollPane1.setBackground(new java.awt.Color(26, 27, 38));

        jTable1.setBackground(new java.awt.Color(26, 27, 38));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del Piloto", "Edad", "Puntuación GNRL", "ID", "Salario"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 102));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");
        jTable1.getAccessibleContext().setAccessibleDescription("");

        jButton2.setBackground(new java.awt.Color(45, 46, 60));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Añadir Piloto");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btEmpleados)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEmpleados)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(jLabel1))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpPilotos.add(jPanel1, "cardPilotos");

        jPanel2.setBackground(new java.awt.Color(66, 66, 87));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

        jButton3.setBackground(new java.awt.Color(45, 46, 60));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Pilotos");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        btEmpleados1.setBackground(new java.awt.Color(45, 46, 60));
        btEmpleados1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btEmpleados1.setForeground(new java.awt.Color(255, 255, 255));
        btEmpleados1.setText("Empleados");
        btEmpleados1.addActionListener(this::btEmpleados1ActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empleados");

        jButton4.setBackground(new java.awt.Color(45, 46, 60));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Añadir Empleado");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jScrollPane2.setBackground(new java.awt.Color(26, 27, 38));

        jTable2.setBackground(new java.awt.Color(26, 27, 38));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del Empleado", "Edad", "Ocupación", "ID", "Salario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionBackground(new java.awt.Color(0, 0, 102));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(btEmpleados1)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jLabel2))
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(btEmpleados1))
                        .addGap(0, 565, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpPilotos.add(jPanel2, "cardEmpleados");

        getContentPane().add(jpPilotos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpleadosActionPerformed
        card = (CardLayout)this.jpPilotos.getLayout();
        card.show(jpPilotos, "cardEmpleados");
    }//GEN-LAST:event_btEmpleadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       card = (CardLayout)this.jpPilotos.getLayout();
       card.show(jpPilotos, "cardPilotos");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        card = (CardLayout)this.jpPilotos.getLayout();
        card.show(jpPilotos, "cardPilotos");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btEmpleados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpleados1ActionPerformed
       card = (CardLayout)this.jpPilotos.getLayout();
       card.show(jpPilotos, "cardEmpleados");
    }//GEN-LAST:event_btEmpleados1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();

    try {
        // 1. Captura y Validación de Datos
        String nombre = javax.swing.JOptionPane.showInputDialog(this, "Nombre del Empleado:");
        if (nombre == null || nombre.trim().isEmpty()) return;

        String edadStr = javax.swing.JOptionPane.showInputDialog(this, "Edad (18-75):");
        if (edadStr == null) return;
        int edad = Integer.parseInt(edadStr); 
        if (edad < 18 || edad > 75) {
            javax.swing.JOptionPane.showMessageDialog(this, "La edad debe estar entre 18 y 75 años.");
            return;
        }

        String ocupacion = javax.swing.JOptionPane.showInputDialog(this, "Ocupación (Ingeniero, Mecánico, etc):");
        if (ocupacion == null || ocupacion.trim().isEmpty()) ocupacion = "General"; //por defecto si deja vacío

        String id = javax.swing.JOptionPane.showInputDialog(this, "ID de Empleado:");
        if (id == null || id.trim().isEmpty()) return;

        String salarioStr = javax.swing.JOptionPane.showInputDialog(this, "Salario Base:");
        if (salarioStr == null) return;
        double salario = Double.parseDouble(salarioStr);
        if (salario < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "El salario no puede ser negativo.");
            return;
        }

        Modelos.ContratoEmpleados contrato = new Modelos.ContratoEmpleados(new java.util.Date(), 0, salario, 0, ocupacion);
        Modelos.Empleadosf1 nuevoEmpleado = new Modelos.Empleadosf1(id, nombre, edad, ocupacion, contrato);
        
        listaGlobal.add(nuevoEmpleado);

        // 4. ACTUALIZACIÓN VISUAL (La Tabla)
        modelo.addRow(new Object[]{
            nuevoEmpleado.getNombre(), 
            nuevoEmpleado.getEdad(), 
            nuevoEmpleado.getRol(), 
            nuevoEmpleado.getId(), 
            salario
        });
  
        javax.swing.JOptionPane.showMessageDialog(this, "Empleado registrado y guardado correctamente.");

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: Ingrese solo números en Edad y Salario.");
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    
    try {
        String nombre = javax.swing.JOptionPane.showInputDialog(this, "Nombre del Piloto:");
        if (nombre == null || nombre.trim().isEmpty()) return;

        String edadStr = javax.swing.JOptionPane.showInputDialog(this, "Edad (16-60):");
        int edad = Integer.parseInt(edadStr);
        
        String puntuacion = javax.swing.JOptionPane.showInputDialog(this, "Puntuación GNRL (0-100):");
        int punt = Integer.parseInt(puntuacion);

        String id = javax.swing.JOptionPane.showInputDialog(this, "ID del Piloto:");
        
        String salarioStr = javax.swing.JOptionPane.showInputDialog(this, "Salario Base:");
        double salario = Double.parseDouble(salarioStr);

        Modelos.ContratoEmpleados contrato = new Modelos.ContratoEmpleados(new java.util.Date(), 0, salario, 0, "Piloto");
        Modelos.Empleadosf1 nuevoPiloto = new Modelos.Empleadosf1(id, nombre, edad, "Piloto", contrato);

        // Guardar en la lista que la Escuderia vera despues
        listaGlobal.add(nuevoPiloto);
        modelo.addRow(new Object[]{nombre, edad, punt, id, salario});
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error en los datos.");
    }
    
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(() -> {new GestorEmpleados(new java.util.ArrayList<>()).setVisible(true);});
        
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEmpleados;
    private javax.swing.JButton btEmpleados1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpPilotos;
    // End of variables declaration//GEN-END:variables
}
