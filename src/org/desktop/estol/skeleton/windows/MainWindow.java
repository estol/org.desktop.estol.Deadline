package org.desktop.estol.skeleton.windows;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import org.desktop.estol.skeleton.applicationlogic.MainLogic;
import org.desktop.estol.skeleton.commons.NotificationIcon;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.desktop.estol.skeleton.debug.DebugUtilities;
import org.desktop.estol.skeleton.magic.gameWindows.GameWindow;
import org.desktop.estol.skeleton.system.windowloader.LoadWindow;

/**
 *
 * @author estol
 */
public class MainWindow extends javax.swing.JFrame {
    
    private static class gameStartAction extends AbstractAction
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            DebugUtilities.addDebugMessage("gamestart event occured!");
        }
    
    }
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow()
    { //throws Exception {
        initComponents();
        //setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) /2);
        NotificationIcon.initSystrayIcon();
        ml = new MainLogic(currentEventListModel, pastEventListModel);
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
        jl_PastEventList = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jl_CurrentEventList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        m_NewEvent = new javax.swing.JMenuItem();
        SaveMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitButton = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Preferences = new javax.swing.JMenuItem();
        DebugMenu = new javax.swing.JMenu();
        FireDebugMethod = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        DebugConsole = new javax.swing.JMenuItem();
        DumpViewer = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Window");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(30, 30));
        setName("JFrame"); // NOI18N

        jl_PastEventList.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jl_PastEventList.setName(""); // NOI18N

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

        jl_PastEventList.addTab("Current events", jPanel1);

        jList2.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        jList2.setModel(pastEventListModel);
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList2);

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

        jl_PastEventList.addTab("Past events", jPanel2);

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

        SaveMenu.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        SaveMenu.setText("Save");
        SaveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMenuActionPerformed(evt);
            }
        });
        FileMenu.add(SaveMenu);
        FileMenu.add(jSeparator2);

        ExitButton.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        ExitButton.setText("Exit (terminate application)");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        FileMenu.add(ExitButton);

        MenuBar.add(FileMenu);

        jMenu1.setText("Settings");
        jMenu1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        Preferences.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        Preferences.setText("Preferences");
        Preferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferencesActionPerformed(evt);
            }
        });
        jMenu1.add(Preferences);

        MenuBar.add(jMenu1);

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

        DumpViewer.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        DumpViewer.setText("Dump Viewer");
        DumpViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DumpViewerActionPerformed(evt);
            }
        });
        DebugMenu.add(DumpViewer);

        MenuBar.add(DebugMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_PastEventList)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_PastEventList)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FireDebugMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireDebugMethodActionPerformed
        new LoadWindow(new GameWindow());        //DeadlineCalendar dc = new DeadlineCalendar();
        //new Thread(new ObjectStreamWriter(dc, "testfile.object")).run();
        //DebugUtilities.addDebugMessage(new ObjectStreamReader("testfile.object").read().toString());
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

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        LoadWindow.Terminate();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void DumpViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DumpViewerActionPerformed
        if (dv != null && dv.isVisible()) {
            dv.setVisible(false);
        } else {
            if (dv == null) {
                dv = new DumpViewer();
            }
            new LoadWindow(dv);
        }
    }//GEN-LAST:event_DumpViewerActionPerformed

    private void SaveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveMenuActionPerformed
        ml.saveDcc();
    }//GEN-LAST:event_SaveMenuActionPerformed

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

    @Override
    public void dispose() {
        LoadWindow.windowDestroyed();
        NotificationIcon.removeSystrayIcon();
        ml.shutdown();
        super.dispose();
    }
    
    private static DebugWindow dw = null;
    private static DumpViewer dv = null;
    private static Preferences p = null;
    private static AddEventWindow aew = null;
    private MainLogic ml;
    protected DefaultListModel currentEventListModel = new DefaultListModel();
    protected DefaultListModel pastEventListModel = new DefaultListModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DebugConsole;
    private javax.swing.JMenu DebugMenu;
    private javax.swing.JMenuItem DumpViewer;
    private javax.swing.JMenuItem ExitButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem FireDebugMethod;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Preferences;
    private javax.swing.JMenuItem SaveMenu;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JList jl_CurrentEventList;
    private javax.swing.JTabbedPane jl_PastEventList;
    private javax.swing.JMenuItem m_NewEvent;
    // End of variables declaration//GEN-END:variables
}
