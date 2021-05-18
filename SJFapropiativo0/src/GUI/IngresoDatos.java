/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLASES.Planificacion;
import CLASES.Proceso;
import CLASES.RangosProceso;
import Logica.LPlanificacion;
import Logica.LProceso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class IngresoDatos extends javax.swing.JFrame {

    /**
     * Creates new form IngresoDatos
     */
    LPlanificacion ObjLogPlanificacion = new LPlanificacion();
    LProceso ObjLogProceso = new LProceso();
    Planificacion Plan = new Planificacion();
    ArrayList<Proceso> ArrayProcesos = new ArrayList<Proceso>();
    ArrayList<RangosProceso> ARangosFinal = new ArrayList<RangosProceso>();
    public int contN = 0;
    public int indice;
    public int tmaxLl = 0;

    public IngresoDatos() {
        initComponents();
        this.jButtonAnadir.setEnabled(false);
        this.jButtonEliminar.setEnabled(false);
        this.jButtonPlanificar.setEnabled(false);
       
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTllegada = new javax.swing.JTextField();
        jTextFieldRafaga = new javax.swing.JTextField();
        jButtonAnadir = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonPlanificar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextGantt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Jtextpromespera = new javax.swing.JTextField();
        jtextpromretorno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Proceso", "Tiempo Llegada", "Rafaga CPU"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 450, 120));

        jLabel1.setText("Tiempo Llegada");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, -1));

        jLabel2.setText("Rafaga CPU");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        jTextFieldTllegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTllegadaActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTllegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 70, -1));

        jTextFieldRafaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRafagaActionPerformed(evt);
            }
        });
        jTextFieldRafaga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRafagaKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldRafaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 70, -1));

        jButtonAnadir.setText("Anadir");
        jButtonAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAnadirMouseClicked(evt);
            }
        });
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 70, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 70, -1));

        jButtonPlanificar.setText("Planificar");
        jButtonPlanificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlanificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPlanificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 80, 40));

        jTextGantt.setEditable(false);
        jTextGantt.setColumns(20);
        jTextGantt.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jTextGantt.setRows(5);
        jScrollPane3.setViewportView(jTextGantt);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 750, 60));

        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Proceso", "Tiempo espera", "Tiempo retorno"
            }
        ));
        jTableResult.setEnabled(false);
        jScrollPane2.setViewportView(jTableResult);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 450, 170));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Promedio Tiempo espera: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        jLabel4.setText("Promedio Tiempo Retorno:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        Jtextpromespera.setEditable(false);
        jPanel1.add(Jtextpromespera, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 80, 30));

        jtextpromretorno.setEditable(false);
        jPanel1.add(jtextpromretorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 80, 30));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 3, 24)); // NOI18N
        jLabel5.setText("SFJ Apropiativo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoprueba.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 320, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 840, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTllegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTllegadaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldTllegadaActionPerformed

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        // TODO add your handling code here:
        String[] Nombres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        if (this.jTextFieldTllegada.getText().length() == 0) {
            this.jTextFieldTllegada.setText("0");
        }
        ArrayProcesos = ObjLogProceso.AgregarProcesos(Nombres[contN], Integer.parseInt(this.jTextFieldTllegada.getText()), Integer.parseInt(this.jTextFieldRafaga.getText()));
        contN++;
        try {
            ListarProcesos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        this.jButtonPlanificar.setEnabled(true);
        this.jButtonEliminar.setEnabled(true);
        this.jButtonAnadir.setEnabled(false);
        this.jTextFieldTllegada.setText(null);
        this.jTextFieldRafaga.setText(null);
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButtonAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAnadirMouseClicked
        // TODO add your handling code here:
        //contN++;
    }//GEN-LAST:event_jButtonAnadirMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        indice = this.jTable1.getSelectedRow();
        this.jTable1.removeAll();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        ArrayProcesos.remove(indice);
        try {
            ListarProcesos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonPlanificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlanificarActionPerformed
        // TODO add your handling code here:
        tmaxLl = ObjLogProceso.TiempoLlMax(ArrayProcesos);
        System.out.println("TIEMPO LLEGADA MAX ES: " + tmaxLl);
        ARangosFinal = ObjLogPlanificacion.PlanificacionP(ArrayProcesos);
        ListarGantt(ARangosFinal);
        try {
            ListarResult();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        presentarCalculo();
        
    }//GEN-LAST:event_jButtonPlanificarActionPerformed

    public void presentarCalculo(){
        Plan = ObjLogPlanificacion.Calculo(ArrayProcesos);
        this.Jtextpromespera.setText(String.valueOf(Plan.promTE) );
        this.jtextpromretorno.setText(String.valueOf(Plan.promTR));
    }
    private void jTextFieldRafagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRafagaActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextFieldRafagaActionPerformed

    private void jTextFieldRafagaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRafagaKeyTyped
        // TODO add your handling code here:
        if (this.jTextFieldRafaga.getText().length() == 0){
         this.jButtonAnadir.setEnabled(true);   
        }
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
            this.jButtonAnadir.setEnabled(false);
        }
        
    }//GEN-LAST:event_jTextFieldRafagaKeyTyped

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
            java.util.logging.Logger.getLogger(IngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoDatos().setVisible(true);
            }
        });
    }

    
    public void ListarResult() throws ClassNotFoundException {
        //Como el método de la BL retorna un ArrayList de la clase Estudiantes
        //Aqui lo recuperamos
        
        Object columnas[] = {"Proceso", "Tiempo espera", "Tiempo Retorno"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        this.jTableResult.setModel(modelo);

        ArrayProcesos = ObjLogPlanificacion.LlenarRangosTiempos(ArrayProcesos, ARangosFinal);
        Plan = ObjLogPlanificacion.Calculo(ArrayProcesos);
        
        for (Proceso objeto : ArrayProcesos) {
            //String id=String.valueOf(objeto.getStrCodigo());
//            String nombre = objeto.getNombre();
//            int tLlegada = objeto.getTllegada();
//            int rafaga = objeto.getRCPU();

            String modeloTemp[] = {objeto.nombre, String.valueOf(objeto.Tespera), String.valueOf(objeto.Tretorno)};
            modelo.addRow(modeloTemp);
        }

    }
    
    public void ListarGantt(ArrayList<RangosProceso> ListaRP) {
        String result = "";
        String rangos = "    0";
        String resultf = "";
        for (RangosProceso RP : ListaRP) {
            result = String.format("%s    |    %s", result, RP.getNombre());

            if ((RP.getNombre().equals("TM")) && !(RP.getNizq() >= 10)) {
                rangos = String.format("%s          %s", rangos, String.valueOf(RP.getNder()));//10 esp
            } else if ((RP.getNizq() >= 10) && !(RP.getNombre().equals("TM"))){
                rangos = String.format("%s        %s", rangos, String.valueOf(RP.getNder()));//8 esp
            } else {
                rangos = String.format("%s         %s", rangos, String.valueOf(RP.getNder()));//9 esp
            }
            resultf = String.format("%s\n%s", result, rangos);

            //Listargant(ArrayProcesos(        )
        }
        this.jTextGantt.setText(resultf);
        //this.jTextGantt.setText(rangos);
    }

    public void ListarProcesos() throws ClassNotFoundException, SQLException {
        //Como el método de la BL retorna un ArrayList de la clase Estudiantes
        //Aqui lo recuperamos

        Object columnas[] = {"Proces", "Tiempo Llegada", "Rafaga CPU"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        this.jTable1.setModel(modelo);

        for (Proceso objeto : ArrayProcesos) {
            //String id=String.valueOf(objeto.getStrCodigo());
            String nombre = objeto.getNombre();
            int tLlegada = objeto.getTllegada();
            int rafaga = objeto.getRCPU();

            String modeloTemp[] = {nombre, String.valueOf(tLlegada), String.valueOf(rafaga)};
            modelo.addRow(modeloTemp);
        }

    }

    public void Listargant(ArrayList<Proceso> Procesos) {
        
        String[] columnas = new String[Procesos.size()];
        for (int i = 0; i < Procesos.size(); i++) {
            columnas[i] = Procesos.get(i).getNombre();
            System.out.println(columnas[i]);

        }

        DefaultTableModel modelo1 = new DefaultTableModel(null, columnas);
       

        String[] modelo2 = new String[Procesos.size()];
        String modeloTemp[];
        modeloTemp = new String[Procesos.size()];
        for (int i = 0; i < Procesos.size(); i++) {
            
            modeloTemp[i] = String.valueOf(Procesos.get(i).getTllegada());
          

            modelo2 = modeloTemp;
            System.out.println(modelo2[i]);
        }
        modelo1.addRow(modelo2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtextpromespera;
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonPlanificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableResult;
    private javax.swing.JTextField jTextFieldRafaga;
    private javax.swing.JTextField jTextFieldTllegada;
    private javax.swing.JTextArea jTextGantt;
    private javax.swing.JTextField jtextpromretorno;
    // End of variables declaration//GEN-END:variables
}
