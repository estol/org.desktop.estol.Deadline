/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.desktop.estol.skeleton.magic.gameWindows;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.desktop.estol.skeleton.applicationlogic.WavePlayer;
import org.desktop.estol.skeleton.commons.NumericUtilities;
import org.desktop.estol.skeleton.system.windowloader.LoadWindow;

/**
 *
 * @author estol
 */
public class GamePreferences extends javax.swing.JFrame {

    /**
     * Creates new form GamePreferences
     */
    public GamePreferences(WavePlayer wp) {
        initComponents();
        init(wp);
    }

    private void init(WavePlayer wp)
    {
        this.wp = wp;
        js_VolumeSlider.addChangeListener(new volumeChangeListener(this.wp, this));
        lab_gain.setText(NumericUtilities.roundFloat(wp.getVolume()) + "");
    }
    
    protected synchronized final void displayGain()
    {
        lab_gain.setText(Float.toString(wp.getVolume()));
    }
    
    private static class volumeChangeListener implements ChangeListener
    {
        WavePlayer wp;
        GamePreferences gp;
        
        volumeChangeListener(WavePlayer wp, GamePreferences gp)
        {
            this.wp = wp;
            this.gp = gp;
        }
        
        @Override
        public void stateChanged(ChangeEvent e)
        {
            JSlider volumeSlider = (JSlider)e.getSource();
            wp.setVolume((double)(volumeSlider.getValue() / 100));
            gp.displayGain();
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

        js_VolumeSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        cb_ToggleMusic = new javax.swing.JCheckBox();
        lab_gain = new javax.swing.JLabel();
        cb_ToggleAllSound = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("You found the hidden game's preferences!");

        js_VolumeSlider.setPaintTicks(true);
        js_VolumeSlider.setValue(50);

        jLabel1.setText("Current gain:");

        cb_ToggleMusic.setSelected(true);
        cb_ToggleMusic.setText("Untick to disable music");

        lab_gain.setText("Not Available");

        cb_ToggleAllSound.setSelected(true);
        cb_ToggleAllSound.setText("Untick to disable all sounds");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(js_VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_ToggleMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_ToggleAllSound, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(20, 20, 20)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_gain, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lab_gain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(js_VolumeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_ToggleMusic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ToggleAllSound)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GamePreferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePreferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePreferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePreferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePreferences(null).setVisible(true);
            }
        });
    }
    
    @Override
    public void dispose()
    {
        LoadWindow.windowDestroyed();
        super.dispose();
    }
    
    private WavePlayer wp;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_ToggleAllSound;
    private javax.swing.JCheckBox cb_ToggleMusic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider js_VolumeSlider;
    private javax.swing.JLabel lab_gain;
    // End of variables declaration//GEN-END:variables
}
