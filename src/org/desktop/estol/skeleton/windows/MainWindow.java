package org.desktop.estol.skeleton.windows;

import java.awt.event.KeyEvent;
import org.desktop.estol.skeleton.applicationlogic.MainLogic;
import org.desktop.estol.skeleton.commons.NotificationIcon;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
//import org.desktop.estol.skeleton.magic.gameWindows.GameWindow;
import org.desktop.estol.skeleton.system.windowloader.LoadWindow;

/**
 *
 * @author estol
 */
public class MainWindow extends javax.swing.JFrame {
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow()
    { //throws Exception {
        initComponents();
        //setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) /2);
        NotificationIcon.initSystrayIcon();
        ml = new MainLogic(currentEventListModel, pastEventListModel);
        ml.setInstance(ml);
        //throw new Exception();
        //hideTimePanel();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jtp_ListHolderTabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jl_CurrentEventList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jl_PassedEventList = new javax.swing.JList();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        m_NewEvent = new javax.swing.JMenuItem();
        m_About = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        m_ExitButton = new javax.swing.JMenuItem();
        SettingsMenu = new javax.swing.JMenu();
        Preferences = new javax.swing.JMenuItem();
        DebugMenu = new javax.swing.JMenu();
        FireDebugMethod = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        DebugConsole = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deadline - Szabó Péter NDIUBF");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(423, 600));
        setName("JFrame"); // NOI18N

        jtp_ListHolderTabPane.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jtp_ListHolderTabPane.setName(""); // NOI18N

        jl_CurrentEventList.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        jl_CurrentEventList.setModel(currentEventListModel);
        jl_CurrentEventList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jl_CurrentEventList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jl_CurrentEventListKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jl_CurrentEventList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtp_ListHolderTabPane.addTab("Current events", jPanel1);

        jl_PassedEventList.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        jl_PassedEventList.setModel(pastEventListModel);
        jl_PassedEventList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jl_PassedEventList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtp_ListHolderTabPane.addTab("Past events", jPanel2);

        MenuBar.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        FileMenu.setText("File");
        FileMenu.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        m_NewEvent.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        m_NewEvent.setText("New event...");
        m_NewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_NewEventActionPerformed(evt);
            }
        });
        FileMenu.add(m_NewEvent);

        m_About.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        m_About.setText("About");
        m_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_AboutActionPerformed(evt);
            }
        });
        FileMenu.add(m_About);
        FileMenu.add(jSeparator2);

        m_ExitButton.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        m_ExitButton.setText("Exit (terminate application)");
        m_ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_ExitButtonActionPerformed(evt);
            }
        });
        FileMenu.add(m_ExitButton);

        MenuBar.add(FileMenu);

        SettingsMenu.setText("Settings");
        SettingsMenu.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        Preferences.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        Preferences.setText("Preferences");
        Preferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferencesActionPerformed(evt);
            }
        });
        SettingsMenu.add(Preferences);

        MenuBar.add(SettingsMenu);

        DebugMenu.setText("Debug");
        DebugMenu.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        MenuBar.add(Box.createHorizontalGlue());

        FireDebugMethod.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        FireDebugMethod.setText("THE TRIGGER");
        FireDebugMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireDebugMethodActionPerformed(evt);
            }
        });
        DebugMenu.add(FireDebugMethod);
        DebugMenu.add(jSeparator1);

        DebugConsole.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        DebugConsole.setText("Debug Console");
        DebugConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DebugConsoleActionPerformed(evt);
            }
        });
        DebugMenu.add(DebugConsole);

        MenuBar.add(DebugMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtp_ListHolderTabPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtp_ListHolderTabPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FireDebugMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireDebugMethodActionPerformed
        JOptionPane.showMessageDialog(null, "BANG!", "BANG BANG!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_FireDebugMethodActionPerformed

    private void DebugConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DebugConsoleActionPerformed
        if (dw != null && dw.isVisible()) {
            dw.setVisible(false);
        } else {
            if (dw == null) {
                dw = new DebugWindow();
            }
            new LoadWindow(dw);
        }
    }//GEN-LAST:event_DebugConsoleActionPerformed

    private void m_ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_ExitButtonActionPerformed
        LoadWindow.Terminate();
    }//GEN-LAST:event_m_ExitButtonActionPerformed

    private void PreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreferencesActionPerformed
        if (p != null && p.isVisible()) {
            p.setVisible(false);
        } else {
            if (p == null) {
                p = new Preferences(ml);
            }
            new LoadWindow(p);
        }
    }//GEN-LAST:event_PreferencesActionPerformed

    private void m_NewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_NewEventActionPerformed
        if (aew != null && aew.isVisible()) {
            aew.setVisible(false);
        } else {
            if (aew == null) {
                aew = new AddEventWindow(ml);
            }
            new LoadWindow(aew);
        }
    }//GEN-LAST:event_m_NewEventActionPerformed

    private void jl_CurrentEventListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jl_CurrentEventListKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE && !jl_CurrentEventList.isSelectionEmpty())
        {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected item?", "Confirm delete", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                ml.deleteEvent(jl_CurrentEventList.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_jl_CurrentEventListKeyPressed

    private void m_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_AboutActionPerformed
        if (about != null && about.isVisible()) {
            about.setVisible(false);
        } else {
            if (about == null) {
                about = new About();
            }
            new LoadWindow(about);
        }
    }//GEN-LAST:event_m_AboutActionPerformed

    @Override
    public void dispose() {
        LoadWindow.windowDestroyed();
        NotificationIcon.removeSystrayIcon();
        ml.shutdown();
        super.dispose();
    }
    
    private static DebugWindow dw = null;
    private static Preferences p = null;
    private static AddEventWindow aew = null;
    private static About about = null;
    private MainLogic ml;
    protected DefaultListModel currentEventListModel = new DefaultListModel();
    protected DefaultListModel pastEventListModel = new DefaultListModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DebugConsole;
    private javax.swing.JMenu DebugMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem FireDebugMethod;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Preferences;
    private javax.swing.JMenu SettingsMenu;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JList jl_CurrentEventList;
    private javax.swing.JList jl_PassedEventList;
    private javax.swing.JTabbedPane jtp_ListHolderTabPane;
    private javax.swing.JMenuItem m_About;
    private javax.swing.JMenuItem m_ExitButton;
    private javax.swing.JMenuItem m_NewEvent;
    // End of variables declaration//GEN-END:variables
}
