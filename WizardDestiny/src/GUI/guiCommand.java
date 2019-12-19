/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Commands.DefaultCommand;
import Commands.PersonalizableCommand;
import Commands.SerializzatoreCommand;
import Commands.SourceCommand;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ludovicorusso
 */
public class guiCommand extends javax.swing.JFrame {
    private SourceCommand sc;
    private PersonalizableCommand p;
    private DefaultCommand dc;
    private SerializzatoreCommand sercommand;
    /**
     * Creates new form guiCommand
     */
    public guiCommand() throws IOException  {
        initComponents();
        sc=new SourceCommand();
        p=new PersonalizableCommand(0,0,0,0,0);
        sercommand=new SerializzatoreCommand();
        dc=new DefaultCommand();
        if(sc.getTypeCommand()){
            p=sc.getPersonalizzable();
            textJump.setText(KeyEvent.getKeyText(p.getJump()));
            textBasicAttack.setText(KeyEvent.getKeyText(p.getAttackB()));
            textSpecialAttack.setText(KeyEvent.getKeyText(p.getAttackS()));
            textDx.setText(KeyEvent.getKeyText(p.getDx()));
            textSx.setText(KeyEvent.getKeyText(p.getSx()));            
        }
        else{
            dc=sc.getDefault();
            textJump.setText(KeyEvent.getKeyText(dc.getJump()));
            textBasicAttack.setText(KeyEvent.getKeyText(dc.getAttackB()));
            textSpecialAttack.setText(KeyEvent.getKeyText(dc.getAttackS()));
            textDx.setText(KeyEvent.getKeyText(dc.getDx()));
            textSx.setText(KeyEvent.getKeyText(dc.getSx()));
            p.setJump(dc.getJump());
            p.setSx(dc.getSx());
            p.setDx(dc.getDx());
            p.setAttack_b(dc.getAttackB());
            p.setAttack_s(dc.getAttackS());
                    
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

        textJump = new java.awt.TextField();
        labelJump = new java.awt.Label();
        textDx = new java.awt.TextField();
        labelDx = new java.awt.Label();
        textSx = new java.awt.TextField();
        labelSx = new java.awt.Label();
        textBasicAttack = new java.awt.TextField();
        labelAttack_b = new java.awt.Label();
        textSpecialAttack = new java.awt.TextField();
        labelSpecialAttack = new java.awt.Label();
        button1 = new java.awt.Button();
        btnRestore = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textJump.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textJump.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textJumpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textJumpKeyTyped(evt);
            }
        });

        labelJump.setText("Jump");

        textDx.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textDx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textDxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDxKeyTyped(evt);
            }
        });

        labelDx.setText("Dx");

        textSx.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textSx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSxKeyTyped(evt);
            }
        });

        labelSx.setText("Sx");

        textBasicAttack.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textBasicAttack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textBasicAttackKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBasicAttackKeyTyped(evt);
            }
        });

        labelAttack_b.setText("Basic Attack");

        textSpecialAttack.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textSpecialAttack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSpecialAttackKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSpecialAttackKeyTyped(evt);
            }
        });

        labelSpecialAttack.setText("Special Attack");

        button1.setLabel("Return");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        btnRestore.setLabel("Restore");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelAttack_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelSpecialAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelJump, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textJump, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textBasicAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textSpecialAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textSx, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textDx, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10))
                            .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJump, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textJump, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(textBasicAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textSpecialAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelSx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textSx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(labelAttack_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(labelSpecialAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textJumpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumpKeyTyped
       if(textJump.getText().length()>=1) //Definisce il metodo per consumare un inserimento alla volta;
           evt.consume();
           
    }//GEN-LAST:event_textJumpKeyTyped

    private void textBasicAttackKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBasicAttackKeyTyped
        if(textBasicAttack.getText().length()>=1)
           evt.consume();
        
    }//GEN-LAST:event_textBasicAttackKeyTyped

    private void textSpecialAttackKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSpecialAttackKeyTyped
          if(textSpecialAttack.getText().length()>=1)
            evt.consume();
    }//GEN-LAST:event_textSpecialAttackKeyTyped

    private void textDxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDxKeyTyped
          if(textDx.getText().length()>=1)
            evt.consume();
    }//GEN-LAST:event_textDxKeyTyped

    private void textSxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSxKeyTyped
           if(textSx.getText().length()>=1)
            evt.consume();
    }//GEN-LAST:event_textSxKeyTyped

    private void textJumpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textJumpKeyPressed
        try {
            p.setJump(evt.getKeyCode());
            textJump.setText(KeyEvent.getKeyText(p.getJump()));
            sercommand.save(p);
        } catch (IOException ex) {
            Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_textJumpKeyPressed

    private void textBasicAttackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBasicAttackKeyPressed
       try {
            p.setAttack_b(evt.getKeyCode());
            textBasicAttack.setText(KeyEvent.getKeyText(p.getAttackB()));
            sercommand.save(p);
        } catch (IOException ex) {
            Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_textBasicAttackKeyPressed

    private void textSpecialAttackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSpecialAttackKeyPressed
         try {
            p.setAttack_s(evt.getKeyCode());
            textSpecialAttack.setText(KeyEvent.getKeyText(p.getAttackS()));
            sercommand.save(p);
        } catch (IOException ex) {
            Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_textSpecialAttackKeyPressed

    private void textDxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDxKeyPressed
        try {
            p.setDx(evt.getKeyCode());
            textDx.setText(KeyEvent.getKeyText(p.getDx()));
            sercommand.save(p);
        } catch (IOException ex) {
            Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_textDxKeyPressed

    private void textSxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSxKeyPressed
         try {
            p.setSx(evt.getKeyCode());
            textSx.setText(KeyEvent.getKeyText(p.getSx()));
            sercommand.save(p);
        } catch (IOException ex) {
            Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_textSxKeyPressed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        MainGame.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        File Command=new File("/Resources/personalizzablecommand.dat");
        Command.delete();
        textJump.setText(KeyEvent.getKeyText(dc.getJump()));
        textBasicAttack.setText(KeyEvent.getKeyText(dc.getAttackB()));
        textSpecialAttack.setText(KeyEvent.getKeyText(dc.getAttackS()));
        textDx.setText(KeyEvent.getKeyText(dc.getDx()));
        textSx.setText(KeyEvent.getKeyText(dc.getSx()));
        PersonalizableCommand perco=new PersonalizableCommand(dc.getJump(),dc.getDx(),dc.getSx(),dc.getAttackB(),dc.getAttackS());
        try {
            sercommand.save(perco);
        } catch (IOException ex) {
            Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRestoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new guiCommand().setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(guiCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnRestore;
    private java.awt.Button button1;
    private java.awt.Label labelAttack_b;
    private java.awt.Label labelDx;
    private java.awt.Label labelJump;
    private java.awt.Label labelSpecialAttack;
    private java.awt.Label labelSx;
    private java.awt.TextField textBasicAttack;
    private java.awt.TextField textDx;
    private java.awt.TextField textJump;
    private java.awt.TextField textSpecialAttack;
    private java.awt.TextField textSx;
    // End of variables declaration//GEN-END:variables
}
