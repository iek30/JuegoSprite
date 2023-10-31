/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegosprite;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cayet
 */
public class JuegoSprite {

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana ventana = new Ventana();
                    Thread clientThread = new Thread(() -> {
                        try {

                            while (true) {
                                
                                String coordenadasStr = ventana.input.readUTF();
                                
                                String[] coordenadas = coordenadasStr.split(",");
                                
                                for (int i = 0; i < coordenadas.length; i++) {
                                    
                                    switch (i) {
                                        case 0:
                                            ventana.jLabel1.setLocation(Integer.parseInt(coordenadas[i]), (int) ventana.jLabel1.getLocation().getY());
                                            break;
                                        case 1:
                                            ventana.jLabel2.setLocation(Integer.parseInt(coordenadas[i]), (int) ventana.jLabel2.getLocation().getY());
                                            break;
                                        case 2:
                                            ventana.jLabel3.setLocation(Integer.parseInt(coordenadas[i]), (int) ventana.jLabel3.getLocation().getY());
                                            break;
                                        case 3:
                                            ventana.jLabel4.setLocation(Integer.parseInt(coordenadas[i]), (int) ventana.jLabel4.getLocation().getY());
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                    
                                }
                                
                                // Procesa coordenadas recibidas
                                System.out.println("Coordenadas recibidas: " + coordenadasStr);
                                
                                
                                
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    // Inicia el hilo del cliente
                    clientThread.start();
                } catch (IOException ex) {
                    Logger.getLogger(JuegoSprite.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
