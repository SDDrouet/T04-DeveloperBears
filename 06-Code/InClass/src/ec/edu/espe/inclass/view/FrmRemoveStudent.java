
package ec.edu.espe.inclass.view;

import ec.edu.espe.inclass.controller.DataPersistence;
import ec.edu.espe.inclass.controller.StudentController;
import ec.edu.espe.inclass.model.Student;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejo
 */
public class FrmRemoveStudent extends javax.swing.JFrame {

    /**
     * Creates new form frmremovestudent
     */
    public FrmRemoveStudent() {
        initComponents();
        refreshTable();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNStudent = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNrcReceive = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 249, 245));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(64, 81, 78));
        jLabel1.setText("REMOVE STUDENT");

        tblStudents.setBackground(new java.awt.Color(48, 227, 202));
        tblStudents.setForeground(new java.awt.Color(0, 0, 0));
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStudents);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(64, 81, 78));
        jLabel2.setText("Type the student's list number you want to delete:");

        txtNStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNStudentActionPerformed(evt);
            }
        });
        txtNStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNStudentKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(64, 81, 78));
        jLabel3.setText("NRC:");

        txtNrcReceive.setEnabled(false);

        btnDelete.setBackground(new java.awt.Color(48, 227, 202));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(64, 81, 78));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 275, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNrcReceive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtNrcReceive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addGap(35, 35, 35))
        );

        jPanel2.setBackground(new java.awt.Color(17, 153, 158));

        btnBack.setBackground(new java.awt.Color(64, 81, 78));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        FrmEnterCourse frmEnterCourse = new FrmEnterCourse();
        frmEnterCourse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNStudentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNStudentKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        char c1 = (char) 0;

        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, c + " is not accepted here", "warning", JOptionPane.WARNING_MESSAGE);
            evt.setKeyChar(c1);
        }
    }//GEN-LAST:event_txtNStudentKeyTyped

    private void txtNStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNStudentActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DataPersistence dataPersistence;                
        dataPersistence = DataPersistence.getInstance();
        String espeId;
        String name;
        int studentNumber;
        int nrc;
        int desicion;
        int result;

        try {
            studentNumber = Integer.parseInt(txtNStudent.getText()) - 1;
            int totalStudents = dataPersistence.getTeacher().getCourses().get(dataPersistence.getPosition()).getStudents().size();
            nrc = dataPersistence.getTeacher().getCourses().get(dataPersistence.getPosition()).getNrc();
            if (studentNumber < totalStudents) {
                espeId = String.valueOf(dataPersistence.getTeacher().getCourses().get(dataPersistence.getPosition()).getStudents().get(studentNumber).getEspeId());
                name = String.valueOf(dataPersistence.getTeacher().getCourses().get(dataPersistence.getPosition()).getStudents().get(studentNumber).getName());
                desicion = JOptionPane.showConfirmDialog(this, "Do you want to delete this student: " + name + " (" + espeId + ")" + " ?", "course delete info", WIDTH);

                if (desicion == 0) {
                    result = StudentController.removeStudent(espeId, nrc);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(this, "Student " + name + " (" + espeId + ")" + " was successfully eliminated", "Student delete information", INFORMATION_MESSAGE);
                        txtNStudent.setText("");
                        refreshTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "operation canceled");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Student not found, try Again\nRemember do you have " + totalStudents + " students in this nrc " + "(" + nrc + ")");
                txtNStudent.setText("");
            }

            dataPersistence.updateData();
            refreshTable();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Can't delete that student\n Error: " + e);
        }        
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRemoveStudent().setVisible(true);
            }
        });
    }

    public final void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        DataPersistence dataPersistence;                
        dataPersistence = DataPersistence.getInstance();
        model.addColumn("#");
        model.addColumn("Name");
        model.addColumn("Espe Id");

        int i = 1;
        for (Student student : dataPersistence.getTeacher().getCourses().get(dataPersistence.getPosition()).getStudents()) {
            model.addRow(new Object[]{i, student.getName(), student.getEspeId()});
            i++;
        }

        tblStudents.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtNStudent;
    public static javax.swing.JTextField txtNrcReceive;
    // End of variables declaration//GEN-END:variables
}
