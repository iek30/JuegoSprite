/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.juegosprite;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author cayet
 */
public class Ventana extends javax.swing.JFrame{

    public Integer ancho_pantalla;
    public Socket socket;
    public DataInputStream input;
    public DataOutputStream output;
    public int coordenada;
    final int mitadPantalla = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2)-150;
    
    public Ventana() throws IOException {
        initComponents();
        setVisible(true);
        setResizable(false);
        this.socket = new Socket("127.0.0.1",90);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.coordenada = mitadPantalla;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblCoche1 = new javax.swing.JLabel();
        lblCoche2 = new javax.swing.JLabel();
        lblCoche3 = new javax.swing.JLabel();
        lblCoche4 = new javax.swing.JLabel();
        lblBanderaFinal = new javax.swing.JLabel();
        lblFondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrera Coches");
        setSize(new java.awt.Dimension(1920, 1080));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        panel.setLayout(null);

        lblCoche1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoche1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche1Derecha.png"))); // NOI18N
        panel.add(lblCoche1);
        lblCoche1.setBounds(810, 10, 300, 205);

        lblCoche2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoche2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche2Derecha.png"))); // NOI18N
        panel.add(lblCoche2);
        lblCoche2.setBounds(810, 320, 300, 171);

        lblCoche3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoche3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche3Derecha.png"))); // NOI18N
        panel.add(lblCoche3);
        lblCoche3.setBounds(810, 560, 300, 199);

        lblCoche4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoche4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coche4Derecha.png"))); // NOI18N
        panel.add(lblCoche4);
        lblCoche4.setBounds(810, 860, 300, 195);

        lblBanderaFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banderaMeta.png"))); // NOI18N
        panel.add(lblBanderaFinal);
        lblBanderaFinal.setBounds(1820, 0, 104, 1060);

        lblFondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carretera.jpg"))); // NOI18N
        lblFondoPantalla.setPreferredSize(new java.awt.Dimension(2100, 1080));
        panel.add(lblFondoPantalla);
        lblFondoPantalla.setBounds(0, 0, 2100, 1180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == 37 && coordenada-20 >=0) {
            coordenada -= 40;
        }
        else if (evt.getKeyCode() == 39 && coordenada+20 <= mitadPantalla*2){
            coordenada += 40;
        }
        try {
            output.writeUTF(Integer.toString(coordenada));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formKeyReleased

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblBanderaFinal;
    public javax.swing.JLabel lblCoche1;
    public javax.swing.JLabel lblCoche2;
    public javax.swing.JLabel lblCoche3;
    public javax.swing.JLabel lblCoche4;
    private javax.swing.JLabel lblFondoPantalla;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
