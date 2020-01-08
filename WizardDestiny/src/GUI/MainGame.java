/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DirectorTest.Main;
import GameSound.Sound;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ludovicorusso
 */
public class MainGame extends javax.swing.JFrame {
    /**
     * Creates new form MainGame
     */
    private Sound sound;
    
    public MainGame() {
        initComponents();
        sound=new Sound();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jButtonSetting = new javax.swing.JButton();
        JButtonExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wizard Destiny");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setIconImages(null);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        jLabel2.setText("Wizard Destiny");

        jButtonStart.setBackground(new java.awt.Color(0, 66, 0));
        jButtonStart.setFont(new java.awt.Font("Papyrus", 1, 13)); // NOI18N
        jButtonStart.setForeground(new java.awt.Color(255, 255, 255));
        jButtonStart.setText("Start");
        jButtonStart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonStartKeyPressed(evt);
            }
        });

        jButtonSetting.setBackground(new java.awt.Color(0, 66, 0));
        jButtonSetting.setFont(new java.awt.Font("Papyrus", 1, 13)); // NOI18N
        jButtonSetting.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSetting.setText("Setting");
        jButtonSetting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonSettingKeyPressed(evt);
            }
        });

        JButtonExit.setBackground(new java.awt.Color(0, 66, 0));
        JButtonExit.setFont(new java.awt.Font("Papyrus", 1, 13)); // NOI18N
        JButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        JButtonExit.setText("Exit");
        JButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonExitActionPerformed(evt);
            }
        });
        JButtonExit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JButtonExitKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bg.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jButtonSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(JButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jButtonStart)
                .addGap(5, 5, 5)
                .addComponent(jButtonSetting))
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(JButtonExit))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonStartKeyPressed

       if(evt.getKeyCode()==KeyEvent.VK_UP){
           JButtonExit.requestFocus();
           sound.playClip("src/Resources/SoundPack/sfx_sounds_button3.wav");
       }
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
           jButtonSetting.requestFocus();
           sound.playClip("src/Resources/SoundPack/sfx_sounds_button2.wav");
       }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           try {
               Main.main(null);
           } catch (InterruptedException ex) {
               Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
           }
               this.setVisible(false);
               sound.playClip("src/Resources/SoundPack/sfx_menu_select1.wav");
        }
    }//GEN-LAST:event_jButtonStartKeyPressed

    private void jButtonSettingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSettingKeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_UP){
           jButtonStart.requestFocus();
           sound.playClip("src/Resources/SoundPack/sfx_sounds_button1.wav");
       }
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
           JButtonExit.requestFocus();
           sound.playClip("src/Resources/SoundPack/sfx_sounds_button3.wav");
       }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            guiCommand.main(null);
            this.setVisible(false);
            sound.playClip("src/Resources/SoundPack/sfx_menu_select2.wav");
        }
    }//GEN-LAST:event_jButtonSettingKeyPressed

    private void JButtonExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JButtonExitKeyPressed
  
        if(evt.getKeyCode()==KeyEvent.VK_UP){
           jButtonSetting.requestFocus();
           sound.playClip("src/Resources/SoundPack/sfx_sounds_button2.wav");
       }
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
           jButtonStart.requestFocus();
           sound.playClip("src/Resources/SoundPack/sfx_sounds_button3.wav");
       }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            System.exit(0);
            sound.playClip("src/Resources/SoundPack/sfx_menu_select3.wav");
        }
    }//GEN-LAST:event_JButtonExitKeyPressed

    private void JButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_JButtonExitActionPerformed
    
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
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               JFrame frame1=new MainGame();
               frame1.setVisible(true);
               
            }
            
        });
      
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonExit;
    private javax.swing.JButton jButtonSetting;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
