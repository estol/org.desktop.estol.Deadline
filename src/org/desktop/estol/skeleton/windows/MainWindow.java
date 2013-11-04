package org.desktop.estol.skeleton.windows;

import org.desktop.estol.skeleton.applicationlogic.mainLogic;
import org.desktop.estol.skeleton.commons.NotificationIcon;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
        ml = new mainLogic(currentEventListModel, pastEventListModel);
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
        jp_timePanel = new javax.swing.JPanel();
        js_EventDateTime = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        tf_EventName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_EventDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        bt_Submit = new javax.swing.JButton();
        cb_EventRecurring = new javax.swing.JCheckBox();
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

        jp_timePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Condensed", 0, 12))); // NOI18N

        js_EventDateTime.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        js_EventDateTime.setModel(new javax.swing.SpinnerDateModel());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel1.setText("Date and Time of event");

        tf_EventName.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel2.setText("Event name");

        ta_EventDescription.setColumns(10);
        ta_EventDescription.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        ta_EventDescription.setLineWrap(true);
        ta_EventDescription.setRows(5);
        jScrollPane1.setViewportView(ta_EventDescription);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel3.setText("Event description (optional)");

        bt_Submit.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        bt_Submit.setText("Submit");
        bt_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SubmitActionPerformed(evt);
            }
        });

        cb_EventRecurring.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        cb_EventRecurring.setText("One time event");
        cb_EventRecurring.setEnabled(false);
        cb_EventRecurring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_EventRecurringActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_timePanelLayout = new javax.swing.GroupLayout(jp_timePanel);
        jp_timePanel.setLayout(jp_timePanelLayout);
        jp_timePanelLayout.setHorizontalGroup(
            jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_timePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_timePanelLayout.createSequentialGroup()
                        .addGroup(jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(cb_EventRecurring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(js_EventDateTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_EventName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jp_timePanelLayout.setVerticalGroup(
            jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_timePanelLayout.createSequentialGroup()
                .addGroup(jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(js_EventDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_EventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_timePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_EventRecurring)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(bt_Submit))
        );

        jl_PastEventList.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jl_PastEventList.setName(""); // NOI18N

        jl_CurrentEventList.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        jl_CurrentEventList.setModel(currentEventListModel);
        jl_CurrentEventList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jl_CurrentEventList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jl_PastEventList, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jl_PastEventList))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FireDebugMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireDebugMethodActionPerformed
        //DeadlineCalendar dc = new DeadlineCalendar();
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

    private void bt_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SubmitActionPerformed
        // TODO: find a more elegant solution to escape the function than blank return statements. Maybe override the void type?
        if (new Date().after((Date) js_EventDateTime.getValue()))
        {
            JOptionPane.showMessageDialog(rootPane, "The event can't be in the past!", "User error!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if ("".equals(tf_EventName.getText()))
        {
            JOptionPane.showMessageDialog(rootPane, "Your event doesn't have a title!", "User error!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ml.addDeadlineCalendarEvent((Date)js_EventDateTime.getValue(), tf_EventName.getText(), ta_EventDescription.getText(), false);
        ml.saveDcc();
    }//GEN-LAST:event_bt_SubmitActionPerformed

    private void cb_EventRecurringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_EventRecurringActionPerformed
        if (cb_EventRecurring.isSelected())
        {
            cb_EventRecurring.setText("Recurring event");
        }
        else
        {
            cb_EventRecurring.setText("One time event");
        }
    }//GEN-LAST:event_cb_EventRecurringActionPerformed

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
                p = new Preferences();
            }
            new LoadWindow(p);
        }
    }//GEN-LAST:event_PreferencesActionPerformed

    @Override
    public void dispose() {
        LoadWindow.windowDestroyed();
        NotificationIcon.removeSystrayIcon();
        ml.shutdown();
        super.dispose();
    }
    
    private static DebugWindow dw;
    private static DumpViewer dv;
    private static Preferences p;
    private mainLogic ml;
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
    private javax.swing.JButton bt_Submit;
    private javax.swing.JCheckBox cb_EventRecurring;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JList jl_CurrentEventList;
    private javax.swing.JTabbedPane jl_PastEventList;
    private javax.swing.JPanel jp_timePanel;
    private javax.swing.JSpinner js_EventDateTime;
    private javax.swing.JMenuItem m_NewEvent;
    private javax.swing.JTextArea ta_EventDescription;
    private javax.swing.JTextField tf_EventName;
    // End of variables declaration//GEN-END:variables
}
