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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dam\\Documents\\GitHub\\JuegoSprite_Cayetano\\resources\\coche1Derecha.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(810, -10, 300, 205);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\dam\\Documents\\GitHub\\JuegoSprite_Cayetano\\resources\\coche2Derecha.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(810, 270, 300, 171);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\dam\\Documents\\GitHub\\JuegoSprite_Cayetano\\resources\\coche3Derecha.png")); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(810, 530, 300, 199);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\dam\\Documents\\GitHub\\JuegoSprite_Cayetano\\resources\\coche4Derecha.png")); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(810, 850, 300, 195);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\dam\\Documents\\GitHub\\JuegoSprite_Cayetano\\resources\\carretera.jpg")); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(2100, 1080));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 2100, 1080);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == 37 && coordenada-20 >=0) {
            coordenada -= 20;
        }
        else if (evt.getKeyCode() == 39 && coordenada+20 <= mitadPantalla*2){
            coordenada += 20;
        }
        try {
            output.writeUTF(Integer.toString(coordenada));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formKeyReleased

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
