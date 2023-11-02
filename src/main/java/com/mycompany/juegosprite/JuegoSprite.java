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
                    Integer[] coordenadas = {ventana.mitadPantalla, ventana.mitadPantalla, ventana.mitadPantalla, ventana.mitadPantalla};
                    Thread clientThread = new Thread(() -> {
                        try {

                            while (true) {
                                
                                String coordenadasStr = ventana.input.readUTF();
                                
                                String[] coordenadasInput = coordenadasStr.split(",");
                                
                                for (int i = 0; i < coordenadasInput.length; i++) {
                                    
                                    switch (i) {
                                        case 0:
                                            if(Integer.parseInt(coordenadasInput[i])>coordenadas[i]) ventana.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche1Derecha.png")));
                                            if(Integer.parseInt(coordenadasInput[i])<coordenadas[i]) ventana.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche1Izquierda.png")));
                                            ventana.jLabel1.setLocation(Integer.parseInt(coordenadasInput[i]), (int) ventana.jLabel1.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasInput[i]);
                                            break;
                                        case 1:
                                            if(Integer.parseInt(coordenadasInput[i])>coordenadas[i]) ventana.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche2Derecha.png")));
                                            if(Integer.parseInt(coordenadasInput[i])<coordenadas[i]) ventana.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche2Izquierda.png")));
                                            ventana.jLabel2.setLocation(Integer.parseInt(coordenadasInput[i]), (int) ventana.jLabel2.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasInput[i]);
                                            break;
                                        case 2:
                                            if(Integer.parseInt(coordenadasInput[i])>coordenadas[i]) ventana.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche3Derecha.png")));
                                            if(Integer.parseInt(coordenadasInput[i])<coordenadas[i]) ventana.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche3Izquierda.png")));
                                            ventana.jLabel3.setLocation(Integer.parseInt(coordenadasInput[i]), (int) ventana.jLabel3.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasInput[i]);
                                            break;
                                        case 3:
                                            if(Integer.parseInt(coordenadasInput[i])>coordenadas[i]) ventana.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche4Derecha.png")));
                                            if(Integer.parseInt(coordenadasInput[i])<coordenadas[i]) ventana.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche4Izquierda.png")));
                                            ventana.jLabel4.setLocation(Integer.parseInt(coordenadasInput[i]), (int) ventana.jLabel4.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasInput[i]);
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
