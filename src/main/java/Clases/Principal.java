/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Clases;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author felix_5bh1a4y
 */
public class Principal extends javax.swing.JFrame {

    long[] tiempos;
    Control control;
    JFrame grafica;
    boolean[] checkedBoxes;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        cambiarImagenes();
        iniciar();
        /*
        System.out.println("Leyendo archivo 10");
        int i  = 10*5*5*5*5*5;
        control.escribir(control.leerArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\Practica6\\"+i+".csv"));
         
        // TODO code application logic here
/*
        int[] arreglo = new int[195312500];
        Random rnd = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rnd.nextInt(300000);
        }

        System.out.println("si se pudo");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rnd.nextInt(300000);
        }
         */
    }

    public void iniciar() {
        checkedBoxes = new boolean[7];
        tiempos = new long[10];
        control = new Control();
        int tamano = 100;
        for (int i = 0; i < 8; i++) {
            control.crearArchivoArreglo(tamano);
            tamano *= 5;
        }
        System.out.println("Valor del ultimo elemento" + tamano);

        tamano = 100;
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 8; i++) {
                crearTiemposOrden(control.ordenamientosGenerales(tamano, j + 1), i);
                tamano *= 5;
            }
            System.out.println("Valor de j"+j);
            System.out.println("Valor obtenido ="+elegirNombre(j+1));
            control.crearArchivoTiempos(tiempos, elegirNombre(j + 1), j + 1);
            tamano = 100;
        }

        grafica = new JFrame();
        grafica.setContentPane(control.obtenerGrafica());
        for (int i = 0; i < 7; i++) {
            checkedBoxes[i] = true;
        }
        botonShell.setSelected(true);
        botonInsercion.setSelected(true);
        botonSeleccion.setSelected(true);
        botonQuicksort.setSelected(true);
        botonSort.setSelected(true);
        botonRadixSort.setSelected(true);
        botonBucketSort.setSelected(true);
    }

    public void cambiarImagenes() {
        titulo.setIcon(new ImageIcon("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Recursos\\Practica6\\titulo.png"));
        principal.setIcon(new ImageIcon("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Recursos\\Practica6\\principal.png"));
        metodos.setIcon(new ImageIcon("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Recursos\\Practica6\\metodos.png"));
    }

    public String elegirNombre(int numMetodo) {
        switch (numMetodo) {
            case 1:
                return "shell";
            case 2:
                return "insercion";
            case 3:
                return "seleccion";
            case 4:
                return "Quicksort";
            case 5:
                return "radixsort";
            case 6:
                return "bucketsort";
            case 7:
                return "sort";
            default:
                return "pokemon";
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

        jButton1 = new javax.swing.JButton();
        botonShell = new javax.swing.JCheckBox();
        botonInsercion = new javax.swing.JCheckBox();
        botonSeleccion = new javax.swing.JCheckBox();
        botonQuicksort = new javax.swing.JCheckBox();
        reiniciar = new javax.swing.JButton();
        botonRadixSort = new javax.swing.JCheckBox();
        botonBucketSort = new javax.swing.JCheckBox();
        botonSort = new javax.swing.JCheckBox();
        titulo = new javax.swing.JLabel();
        principal = new javax.swing.JLabel();
        metodos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Graficar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonShell.setText("Shell");
        botonShell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonShellActionPerformed(evt);
            }
        });

        botonInsercion.setText("Insercion");
        botonInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsercionActionPerformed(evt);
            }
        });

        botonSeleccion.setText("Seleccion");
        botonSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionActionPerformed(evt);
            }
        });

        botonQuicksort.setText("Quicksort");
        botonQuicksort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuicksortActionPerformed(evt);
            }
        });

        reiniciar.setText("Reiniciar");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });

        botonRadixSort.setText("Radixsort");
        botonRadixSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRadixSortActionPerformed(evt);
            }
        });

        botonBucketSort.setText("Bucketsort");
        botonBucketSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBucketSortActionPerformed(evt);
            }
        });

        botonSort.setText("Sort");
        botonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(metodos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(149, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonInsercion)
                            .addComponent(botonBucketSort)
                            .addComponent(botonSort))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonSeleccion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonRadixSort)
                                    .addComponent(botonShell))
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botonQuicksort)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(reiniciar))
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(metodos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonInsercion)
                            .addComponent(botonShell))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonSort)
                            .addComponent(botonRadixSort)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBucketSort)
                            .addComponent(botonSeleccion)
                            .addComponent(reiniciar)))
                    .addComponent(botonQuicksort))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        grafica.setContentPane(control.actualizarGrafica(checkedBoxes));
        grafica.setSize(800, 500);
        grafica.setVisible(true);            // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonShellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonShellActionPerformed
        checkedBoxes[0] = botonShell.isSelected();
        System.out.println("CheckBox de Shell = " + checkedBoxes[0]);
        // TODO add your handling code here:
    }//GEN-LAST:event_botonShellActionPerformed

    private void botonQuicksortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuicksortActionPerformed
        checkedBoxes[3] = botonQuicksort.isSelected();
        System.out.println("CheckBox de Quicksort = " + checkedBoxes[3]);
// TODO add your handling code here:
    }//GEN-LAST:event_botonQuicksortActionPerformed

    private void botonInsercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsercionActionPerformed
        checkedBoxes[1] = botonInsercion.isSelected();
        System.out.println("CheckBox de Insercion = " + checkedBoxes[1]);
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInsercionActionPerformed

    private void botonSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionActionPerformed
        checkedBoxes[2] = botonSeleccion.isSelected();
        System.out.println("CheckBox de Seleccion = " + checkedBoxes[2]);
// TODO add your handling code here:
    }//GEN-LAST:event_botonSeleccionActionPerformed

    private void botonRadixSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRadixSortActionPerformed
        checkedBoxes[4] = botonRadixSort.isSelected();
        System.out.println("CheckBox de radixsort = " + checkedBoxes[4]);       // TODO add your handling code here:
    }//GEN-LAST:event_botonRadixSortActionPerformed

    private void botonBucketSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBucketSortActionPerformed
        checkedBoxes[5] = botonBucketSort.isSelected();
        System.out.println("CheckBox de bucketSort = " + checkedBoxes[5]);        // TODO add your handling code here:
    }//GEN-LAST:event_botonBucketSortActionPerformed

    private void botonSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSortActionPerformed
        checkedBoxes[6] = botonSort.isSelected();
        System.out.println("CheckBox de Seleccion = " + checkedBoxes[6]);        // TODO add your handling code here:
    }//GEN-LAST:event_botonSortActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        iniciar();        // TODO add your handling code here:
    }//GEN-LAST:event_reiniciarActionPerformed

    public void crearTiemposOrden(long tiempo, int pos) {
        tiempos[pos] = tiempo;
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox botonBucketSort;
    private javax.swing.JCheckBox botonInsercion;
    private javax.swing.JCheckBox botonQuicksort;
    private javax.swing.JCheckBox botonRadixSort;
    private javax.swing.JCheckBox botonSeleccion;
    private javax.swing.JCheckBox botonShell;
    private javax.swing.JCheckBox botonSort;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel metodos;
    private javax.swing.JLabel principal;
    private javax.swing.JButton reiniciar;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
