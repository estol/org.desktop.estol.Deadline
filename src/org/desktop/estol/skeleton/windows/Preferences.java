/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.desktop.estol.skeleton.windows;

import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.desktop.estol.skeleton.applicationlogic.Settings;
import org.desktop.estol.skeleton.applicationlogic.WavePlayer;
import org.desktop.estol.skeleton.applicationlogic.mainLogic;
import org.desktop.estol.skeleton.debug.DebugUtilities;
import org.desktop.estol.skeleton.system.windowloader.LoadWindow;

/**
 *
 * @author estol
 */
public class Preferences extends javax.swing.JFrame {

    /**
     * Creates new form Preferences
     */
    public Preferences() {
        initComponents();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        //\u25B8
        detectSoundFiles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        tf_CalendarFilePath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bt_CalendarFileFolder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cb_NotificationSounds = new javax.swing.JComboBox();
        bt_PreviewNotificationSound = new javax.swing.JButton();
        bt_SavePreferences = new javax.swing.JButton();
        bt_DiscardChanges = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferences");
        setAlwaysOnTop(true);
        setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        tf_CalendarFilePath.setEditable(false);
        tf_CalendarFilePath.setFont(new java.awt.Font("Ubuntu Mono", 0, 12)); // NOI18N
        tf_CalendarFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CalendarFilePathActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel1.setText("Calendar file");

        bt_CalendarFileFolder.setFont(new java.awt.Font("Ubuntu Condensed", 0, 12)); // NOI18N
        bt_CalendarFileFolder.setText("Browse");
        bt_CalendarFileFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CalendarFileFolderActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel2.setText("Notification Sound");

        cb_NotificationSounds.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        cb_NotificationSounds.setEditor(null);
        cb_NotificationSounds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_NotificationSoundsActionPerformed(evt);
            }
        });

        bt_PreviewNotificationSound.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        bt_PreviewNotificationSound.setText("Play");
        bt_PreviewNotificationSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PreviewNotificationSoundActionPerformed(evt);
            }
        });

        bt_SavePreferences.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        bt_SavePreferences.setText("Save");
        bt_SavePreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SavePreferencesActionPerformed(evt);
            }
        });

        bt_DiscardChanges.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        bt_DiscardChanges.setText("Discard");
        bt_DiscardChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DiscardChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_SavePreferences, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                        .addComponent(bt_DiscardChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_NotificationSounds, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                            .addComponent(tf_CalendarFilePath, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_CalendarFileFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_PreviewNotificationSound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_CalendarFileFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(tf_CalendarFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_NotificationSounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_PreviewNotificationSound, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_SavePreferences)
                    .addComponent(bt_DiscardChanges))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_CalendarFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CalendarFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_CalendarFilePathActionPerformed

    private void cb_NotificationSoundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_NotificationSoundsActionPerformed
        soundPath = "Sounds" + System.getProperty("file.separator") +cb_NotificationSounds.getSelectedItem();
        DebugUtilities.addDebugMessage(soundPath);
    }//GEN-LAST:event_cb_NotificationSoundsActionPerformed

    private void bt_PreviewNotificationSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PreviewNotificationSoundActionPerformed
        soundPath = "Sounds" + System.getProperty("file.separator") +cb_NotificationSounds.getSelectedItem();
        new WavePlayer().playSound(soundPath);
    }//GEN-LAST:event_bt_PreviewNotificationSoundActionPerformed

    private void bt_CalendarFileFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CalendarFileFolderActionPerformed
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            dccPath = fc.getSelectedFile().getAbsolutePath() + System.getProperty("file.separator") + "dcc.bin";
            tf_CalendarFilePath.setText(dccPath);
        }
    }//GEN-LAST:event_bt_CalendarFileFolderActionPerformed

    private void bt_DiscardChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DiscardChangesActionPerformed
        dispose();
    }//GEN-LAST:event_bt_DiscardChangesActionPerformed

    private void bt_SavePreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SavePreferencesActionPerformed
        settings.addDccPath(dccPath);
        settings.addNotificationSoundPath(soundPath);
        mainLogic.saveSettings(settings);
        /*
        JFrame mainWindow = LoadWindow.getWindow("Main Window");
        if (!mainWindow.isEnabled())
        {
            mainWindow.setEnabled(true);
        }
        */
    }//GEN-LAST:event_bt_SavePreferencesActionPerformed

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
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preferences.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preferences().setVisible(true);
            }
        });
    }
    
    @Override
    public void dispose() {
        LoadWindow.windowDestroyed();
        super.dispose();
    }
    
    private void detectSoundFiles()
    {
        File[] files = new File("Sounds").listFiles();
        for (File file : files)
        {
            if (file.isFile())
            {
                if (file.getName().endsWith(".wav"))
                {
                    cb_NotificationSounds.addItem(file.getName());
                }
            }
        }
    }
    
    private Settings settings = new Settings();
    private String dccPath;
    private String soundPath;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_CalendarFileFolder;
    private javax.swing.JButton bt_DiscardChanges;
    private javax.swing.JButton bt_PreviewNotificationSound;
    private javax.swing.JButton bt_SavePreferences;
    private javax.swing.JComboBox cb_NotificationSounds;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tf_CalendarFilePath;
    // End of variables declaration//GEN-END:variables
}
