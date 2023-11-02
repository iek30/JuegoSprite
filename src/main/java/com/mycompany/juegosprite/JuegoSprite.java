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
                    Integer[] coordenadas = {ventana.MITAD_PANTALLA, ventana.MITAD_PANTALLA, ventana.MITAD_PANTALLA, ventana.MITAD_PANTALLA};
                    Thread clientThread = new Thread(() -> {
                        try {

                            boolean finalizar = true;
                            
                            boolean empezado = false;
                            
                            while (finalizar) {
                                
                                String coordenadasStr = ventana.input.readUTF();
                                
                                String[] coordenadasPuntosInput = coordenadasStr.split(",");
                                
                                if(Integer.parseInt(coordenadasPuntosInput[coordenadasPuntosInput.length-1])>ventana.TIEMPO_RESTANTE) ventana.lblTiempo.setText("Tiempo Preparacion: " + (Integer.parseInt(coordenadasPuntosInput[coordenadasPuntosInput.length-1])-ventana.TIEMPO_RESTANTE));
                                
                                else if(Integer.parseInt(coordenadasPuntosInput[coordenadasPuntosInput.length-1])<ventana.TIEMPO_RESTANTE && empezado==false) {
                                    ventana.coordenada = ventana.MITAD_PANTALLA;
                                    empezado=true;
                                    ventana.lblCoche1.setLocation(ventana.coordenada, (int) ventana.lblCoche1.getLocation().getY());
                                    ventana.lblCoche1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche1Derecha.png")));
                                    ventana.lblCoche2.setLocation(ventana.coordenada, (int) ventana.lblCoche2.getLocation().getY());
                                    ventana.lblCoche2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche2Derecha.png")));
                                    ventana.lblCoche3.setLocation(ventana.coordenada, (int) ventana.lblCoche3.getLocation().getY());
                                    ventana.lblCoche3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche3Derecha.png")));
                                    ventana.lblCoche4.setLocation(ventana.coordenada, (int) ventana.lblCoche4.getLocation().getY());
                                    ventana.lblCoche4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche4Derecha.png")));
                                }
                                
                                else ventana.lblTiempo.setText("Tiempo Restante: " + coordenadasPuntosInput[coordenadasPuntosInput.length-1]);
                                
                                int cont = 0;
                                
                                for (int i = 0; i < coordenadasPuntosInput.length-1; i++) {
                                    
                                    switch (i) {
                                        case 0:
                                            if(Integer.parseInt(coordenadasPuntosInput[i])>coordenadas[i]) ventana.lblCoche1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche1Derecha.png")));
                                            if(Integer.parseInt(coordenadasPuntosInput[i])<coordenadas[i]) ventana.lblCoche1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche1Izquierda.png")));
                                            ventana.lblCoche1.setLocation(Integer.parseInt(coordenadasPuntosInput[i]), (int) ventana.lblCoche1.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasPuntosInput[i]);
                                            break;
                                        case 1:
                                            if(Integer.parseInt(coordenadasPuntosInput[i])>coordenadas[i]) ventana.lblCoche2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche2Derecha.png")));
                                            if(Integer.parseInt(coordenadasPuntosInput[i])<coordenadas[i]) ventana.lblCoche2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche2Izquierda.png")));
                                            ventana.lblCoche2.setLocation(Integer.parseInt(coordenadasPuntosInput[i]), (int) ventana.lblCoche2.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasPuntosInput[i]);
                                            break;
                                        case 2:
                                            if(Integer.parseInt(coordenadasPuntosInput[i])>coordenadas[i]) ventana.lblCoche3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche3Derecha.png")));
                                            if(Integer.parseInt(coordenadasPuntosInput[i])<coordenadas[i]) ventana.lblCoche3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche3Izquierda.png")));
                                            ventana.lblCoche3.setLocation(Integer.parseInt(coordenadasPuntosInput[i]), (int) ventana.lblCoche3.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasPuntosInput[i]);
                                            break;
                                        case 3:
                                            if(Integer.parseInt(coordenadasPuntosInput[i])>coordenadas[i]) ventana.lblCoche4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche4Derecha.png")));
                                            if(Integer.parseInt(coordenadasPuntosInput[i])<coordenadas[i]) ventana.lblCoche4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche4Izquierda.png")));
                                            ventana.lblCoche4.setLocation(Integer.parseInt(coordenadasPuntosInput[i]), (int) ventana.lblCoche4.getLocation().getY());
                                            coordenadas[i] = Integer.parseInt(coordenadasPuntosInput[i]);
                                            break;
                                        default:
                                            cont+=Integer.parseInt(coordenadasPuntosInput[i]);
                                    }
                                    
                                }
                                
                                if(cont%2==0) ventana.lblBanderaFinal.setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width)-100, (int) ventana.lblBanderaFinal.getLocation().getY());
                                
                                else ventana.lblBanderaFinal.setLocation(0, (int) ventana.lblBanderaFinal.getLocation().getY());
                                
                                for (int i = coordenadas.length; i < coordenadasPuntosInput.length-1; i++) {
                                    
                                    switch (i) {
                                        case 4:
                                            ventana.lblCoche1Puntos.setText("Coche 1 = " + coordenadasPuntosInput[i]);
                                            break;
                                        case 5:
                                            ventana.lblCoche2Puntos.setText("Coche 2 = " + coordenadasPuntosInput[i]);
                                            break;
                                        case 6:
                                            ventana.lblCoche3Puntos.setText("Coche 3 = " + coordenadasPuntosInput[i]);
                                            break;
                                        case 7:
                                            ventana.lblCoche4Puntos.setText("Coche 4 = " + coordenadasPuntosInput[i]);
                                            break;
                                        default:
                                            break;
                                    }
                                    
                                }
                                
                                // Procesa coordenadas recibidas
                                System.out.println("Coordenadas recibidas: " + coordenadasStr);
                                
                                if(Integer.parseInt(coordenadasPuntosInput[coordenadasPuntosInput.length-1])==0) {
                                    finalizar=false;
                                    ventana.lblCoche1Puntos.setForeground(new java.awt.Color(0, 0, 0));
                                    ventana.lblCoche2Puntos.setForeground(new java.awt.Color(0, 0, 0));
                                    ventana.lblCoche3Puntos.setForeground(new java.awt.Color(0, 0, 0));
                                    ventana.lblCoche4Puntos.setForeground(new java.awt.Color(0, 0, 0));
                                }
                                
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
