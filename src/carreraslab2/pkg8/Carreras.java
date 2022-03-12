/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carreraslab2.pkg8;

import java.awt.Color;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Diego Carcamo
 */
public class Carreras extends javax.swing.JFrame {

    /**
     * Creates new form Carreras
     */
    DirManager Manager;

    BarraCarrera race;

    boolean isStarted;

    int primerLugar;

    boolean paused;

    String nombrePista;

    int LargoPista;

    boolean ganador;

    ArrayList<Auto> AutosListados;

    public Carreras() {
        isStarted = false;
        ganador = false;
        paused = false;

        AutosListados = new ArrayList<>();

        initComponents();
        Manager = new DirManager();

        UpdateBox();
        race = new BarraCarrera();

    }

    public void CambiarPista() {

        ProgresoCarrera.setMaximum(LargoPista);

        ///solo se deplegaria el nombre
    }

    public void UpdateTable(JTable tabla) {

        int size = tabla.getRowCount();

        DefaultTableModel ModeloAutos = (DefaultTableModel) tabla.getModel();

        TableRowSorter Tr = new TableRowSorter(ModeloAutos);

        tabla.setRowSorter(Tr);

        ArrayList<SortKey> ordenar = new ArrayList<>();
        ordenar.add(new SortKey(3, SortOrder.DESCENDING));

        Tr.toggleSortOrder(3);

    }

    public Color ColowWhielRacing(int code) {

        if (Manager.Exist(code)) {
            Manager.getConductor();
            Manager.getTipo();

            return Manager.getColor();

        }

        return null;

    }

    public void AgregarAuto(String code) {

        DefaultTableModel model = (DefaultTableModel) TablaPos.getModel();

        if (Manager.Exist(Integer.parseInt(code))) {

            String data[] = {BoxAutos.getSelectedItem() + "", Manager.getConductor(), Manager.getTipo() + "", 0 + ""};

            model.addRow(data);

        }

    }

    class Auto extends Thread {

        int min;
        int max;

        public Auto(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public void run() {
            Random rand = new Random();
            while (!ganador) {

                int avance = rand.nextInt() * max + min;

                //Checar Para anadir progreso debo de checar que vayan en primera posicion 
            }

        }

    }

    class BarraCarrera extends Thread {

        //Agregar Distancias,Actualizar tabla, Agregar Barra
        public void run() {

            Random rand = new Random();

            primerLugar = 0;
            int DistanciaTotal;
            String codeGanador = "";
            while (!ganador) {

                for (int y = 0; y < TablaPos.getRowCount(); y++) {
                    int Tipo = Integer.parseInt((String) TablaPos.getModel().getValueAt(y, 2));

                    int Distancia = 0;

                    switch (Tipo) {

                        case 1: {

                            Distancia = 30 + rand.nextInt(190);

                        }
                        case 2: {

                            Distancia = 20 + rand.nextInt(200);

                        }
                        case 3: {

                            Distancia = 40 + rand.nextInt(180);

                        }

                    }

                    int DActual = Integer.parseInt(TablaPos.getModel().getValueAt(y, 3).toString());

                    int code = Integer.parseInt(TablaPos.getValueAt(y, 0).toString());

                    DistanciaTotal = DActual + Distancia;
                    

                    System.out.println(code);

                    ColorActual.setBackground(ColowWhielRacing(code));

                    ProgresoCarrera.setValue(DActual + Distancia);

                    TablaPos.getModel().setValueAt(DActual + Distancia + "", y, 3);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carreras.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (DistanciaTotal > primerLugar) {
                        codeGanador = "El ganador fue le numero:" + code + " Buenisima toreto!!!";
                        primerLugar = DistanciaTotal;

                    }

                    if (primerLugar >= LargoPista) {
                        ganador = true;
                        break;

                    }
                    
                    
                   

                }

                int NewDistance = Integer.parseInt(TablaPos.getModel().getValueAt(0, 3).toString());

                ProgresoCarrera.setValue(NewDistance);

                ProgresoCarrera.setForeground(Color.RED);

                UpdateTable(TablaPos);
                TablaPos.getRowSorter().toggleSortOrder(3);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carreras.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ganador) {

                    JLabel msg = new JLabel(codeGanador);
                    JOptionPane.showMessageDialog(null, msg);

                }
                ProgresoCarrera.setStringPainted(true);

            }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPos = new javax.swing.JTable();
        ProgresoCarrera = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        TipoBox = new javax.swing.JComboBox<>();
        CodeAuto = new javax.swing.JTextField();
        ConductorField = new javax.swing.JTextField();
        CrearAuto = new javax.swing.JButton();
        NombrePista = new javax.swing.JTextField();
        LargoField = new javax.swing.JTextField();
        PistaBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ColorPan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BoxAutos = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        StartBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelLargo = new javax.swing.JLabel();
        NombrePistaLabel = new javax.swing.JLabel();
        ColorActual = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaPos.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "Identificador", "Conductor","Tipo","Distancia"
            }
        ));
        jScrollPane1.setViewportView(TablaPos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 510, 173));

        ProgresoCarrera.setBackground(new java.awt.Color(51, 255, 204));
        getContentPane().add(ProgresoCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 350, 60));

        jButton1.setText("Correr");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        TipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "McQueen", "Convertible", "Nascar" }));
        getContentPane().add(TipoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 102, -1));
        getContentPane().add(CodeAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 95, -1));
        getContentPane().add(ConductorField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 95, -1));

        CrearAuto.setText("Crear");
        CrearAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearAutoActionPerformed(evt);
            }
        });
        getContentPane().add(CrearAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 95, -1));
        getContentPane().add(NombrePista, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 95, -1));
        getContentPane().add(LargoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 95, -1));

        PistaBtn.setText("Agregar Pista");
        PistaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PistaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PistaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        jButton4.setText("Elejir color");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 100, 35));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 500, -1, 73));

        javax.swing.GroupLayout ColorPanLayout = new javax.swing.GroupLayout(ColorPan);
        ColorPan.setLayout(ColorPanLayout);
        ColorPanLayout.setHorizontalGroup(
            ColorPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        ColorPanLayout.setVerticalGroup(
            ColorPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        getContentPane().add(ColorPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 377, -1, -1));

        jLabel1.setText("Color");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 354, 37, -1));

        jLabel2.setText("Numero");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 460, 90, -1));

        jLabel3.setText("Nombre Conductor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 490, -1, -1));

        BoxAutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(BoxAutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 110, -1));

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 100, -1));

        StartBtn.setText("Start");
        StartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBtnActionPerformed(evt);
            }
        });
        getContentPane().add(StartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 70, -1));

        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jLabel5.setText("Largo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));
        getContentPane().add(LabelLargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));
        getContentPane().add(NombrePistaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        javax.swing.GroupLayout ColorActualLayout = new javax.swing.GroupLayout(ColorActual);
        ColorActual.setLayout(ColorActualLayout);
        ColorActualLayout.setHorizontalGroup(
            ColorActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        ColorActualLayout.setVerticalGroup(
            ColorActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(ColorActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 70, 60));

        jLabel6.setText("First Color");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jButton3.setText("Pause");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 70, -1));

        jLabel7.setText("Tristemente no pude Cmabiar el color de la barra :(");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/torer.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 30, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    //Actualiza la caja de orredores
    public void UpdateBox() {

        try {
            ArrayList<String> Corredores = Manager.Cargar();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            for (String items : Corredores) {

                model.addElement(items);

            }

            BoxAutos.setModel(model);

        } catch (IOException ex) {
            Logger.getLogger(Carreras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reset() {

        TablaPos.removeAll();
        ProgresoCarrera.setValue(0);

    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        JColorChooser colorSelect = new JColorChooser();

        JOptionPane.showMessageDialog(null, colorSelect, "Elija un color", JOptionPane.PLAIN_MESSAGE);
        ColorPan.setBackground(colorSelect.getColor());


    }//GEN-LAST:event_jButton4ActionPerformed

    public void CrearAuto(int codigo, String nombreC, int tipo, double r, double g, double b) {
        try {
            if (Manager.AgregarCorredor(codigo, nombreC, tipo, r, g, b)) {

                UpdateBox();

                ColorPan.setBackground(Color.white);

                ConductorField.setText("");

                CodeAuto.setText("");

            } else {

                JLabel msg = new JLabel("No  se puede crear");
                JOptionPane.showMessageDialog(null, msg);

            }
        } catch (IOException ex) {
            Logger.getLogger(Carreras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void CrearAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearAutoActionPerformed
        // TODO add your handling code here:
        double r = ColorPan.getBackground().getRed();
        double g = ColorPan.getBackground().getGreen();
        double b = ColorPan.getBackground().getBlue();

        CrearAuto(Integer.parseInt(CodeAuto.getText()), ConductorField.getText(), TipoBox.getSelectedIndex(), r, g, b);


    }//GEN-LAST:event_CrearAutoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        AgregarAuto(BoxAutos.getSelectedItem().toString());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PistaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PistaBtnActionPerformed
        // TODO add your handling code here:

        try {

            nombrePista = NombrePista.getText();

            LargoPista = Integer.parseInt(LargoField.getText());

            LabelLargo.setText(LargoField.getText());

            NombrePistaLabel.setText(nombrePista);
            CambiarPista();

        } catch (Exception e) {
            
            
            JOptionPane.showMessageDialog(null, "Necesita llenar los campos de la pista");

        }


    }//GEN-LAST:event_PistaBtnActionPerformed

    private void StartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBtnActionPerformed
        // TODO add your handling code here:

        if (!LabelLargo.getText().equals("") && !NombrePistaLabel.equals("")) {

            if (isStarted && paused) {

                race.resume();

            } else {

                if (TablaPos.getRowCount() == 0) {
                    JLabel msg = new JLabel("No hay competidoras");
                    JOptionPane.showConfirmDialog(null, msg);

                } else {
                    race = new BarraCarrera();
                    race.start();
                    ganador = false;
                    isStarted = true;
                    paused = false;

                }

            }

        } else {

            JLabel msg = new JLabel("Falta una pista");
            JOptionPane.showConfirmDialog(null, msg);

        }


    }//GEN-LAST:event_StartBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        paused = true;

        race.suspend();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        reset();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carreras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carreras().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxAutos;
    private javax.swing.JTextField CodeAuto;
    private javax.swing.JPanel ColorActual;
    private javax.swing.JPanel ColorPan;
    private javax.swing.JTextField ConductorField;
    private javax.swing.JButton CrearAuto;
    private javax.swing.JLabel LabelLargo;
    private javax.swing.JTextField LargoField;
    private javax.swing.JTextField NombrePista;
    private javax.swing.JLabel NombrePistaLabel;
    private javax.swing.JButton PistaBtn;
    private javax.swing.JProgressBar ProgresoCarrera;
    private javax.swing.JButton StartBtn;
    private javax.swing.JTable TablaPos;
    private javax.swing.JComboBox<String> TipoBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
