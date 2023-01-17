package ec.edu.espe.inclass.view;

import ec.edu.espe.inclass.controller.CourseController;
import ec.edu.espe.inclass.controller.DataPersistence;
import static ec.edu.espe.inclass.controller.DataPersistence.teacher;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class FrmEnterCourse extends javax.swing.JFrame {

    /**
     * Creates new form CourseMenu
     */
    public static int position;

    public FrmEnterCourse() {

        initComponents();
        this.setLocationRelativeTo(this);
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
        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnEnrolled = new javax.swing.JButton();
        btnAddGrade = new javax.swing.JButton();
        btnAttendance = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnRecord = new javax.swing.JButton();
        btnAttendanceRecord = new javax.swing.JButton();
        brnAddStudent = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Enter a Course");

        jLabel2.setText("In which course do you want to enter?");

        btnfind.setText("Find");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu:");

        btnEnrolled.setText("Show enrolled students");
        btnEnrolled.setEnabled(false);
        btnEnrolled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrolledActionPerformed(evt);
            }
        });

        btnAddGrade.setText("Add grade");
        btnAddGrade.setEnabled(false);
        btnAddGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGradeActionPerformed(evt);
            }
        });

        btnAttendance.setText("Take attendance");
        btnAttendance.setEnabled(false);
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Student");
        btnRemove.setEnabled(false);

        btnRecord.setText("Get grade record");
        btnRecord.setEnabled(false);
        btnRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordActionPerformed(evt);
            }
        });

        btnAttendanceRecord.setText("Get attendance record");
        btnAttendanceRecord.setEnabled(false);
        btnAttendanceRecord.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                btnAttendanceRecordComponentAdded(evt);
            }
        });
        btnAttendanceRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceRecordActionPerformed(evt);
            }
        });

        brnAddStudent.setText("Add Student");
        brnAddStudent.setEnabled(false);
        brnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnAddStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnfind))
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(brnAddStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddGrade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnrolled, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAttendance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAttendanceRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnEnrolled)
                .addGap(18, 18, 18)
                .addComponent(btnAddGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAttendance)
                .addGap(18, 18, 18)
                .addComponent(brnAddStudent)
                .addGap(18, 18, 18)
                .addComponent(btnRemove)
                .addGap(18, 18, 18)
                .addComponent(btnRecord)
                .addGap(18, 18, 18)
                .addComponent(btnAttendanceRecord)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(23, 23, 23))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttendanceRecordComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_btnAttendanceRecordComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAttendanceRecordComponentAdded

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        // TODO add your handling code here:
        int courseToFind = 0;

        try {
            courseToFind = Integer.parseInt(txtCourse.getText());
            position = getNrcEntered();
        } catch (Exception e) {
            position = -1;
        }                        

        if (position != -1) {
            txtCourse.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Course successfully found", "COURSE FIND", INFORMATION_MESSAGE);
            btnEnrolled.setEnabled(true);
            btnAddGrade.setEnabled(true);
            btnAttendance.setEnabled(true);
            brnAddStudent.setEnabled(true);
            btnRemove.setEnabled(true);
            btnRecord.setEnabled(true);
            btnAttendanceRecord.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Course not exists, try again", "COURSE FIND", ERROR_MESSAGE);
            btnEnrolled.setEnabled(false);
            btnAddGrade.setEnabled(false);
            btnAttendance.setEnabled(false);
            brnAddStudent.setEnabled(false);
            btnRemove.setEnabled(false);
            btnRecord.setEnabled(false);
            btnAttendanceRecord.setEnabled(false);
            txtCourse.setText("");
        }


    }//GEN-LAST:event_btnfindActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        FrmTeacherMenu frmTeacherMenu = new FrmTeacherMenu();
        frmTeacherMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnEnrolledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrolledActionPerformed
        FrmShowEnrolledStudents frmShowEnrolledStudents = new FrmShowEnrolledStudents();
        frmShowEnrolledStudents.setVisible(true);
        FrmShowEnrolledStudents.txtNrcReceive.setText(txtCourse.getText());
        this.setVisible(false);
    }//GEN-LAST:event_btnEnrolledActionPerformed

    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed
        FrmTakeAttendance frmTakeAttendance = new FrmTakeAttendance();
        frmTakeAttendance.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAttendanceActionPerformed

    private void btnAddGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGradeActionPerformed
        FrmAddGrade frmAddGrade = new FrmAddGrade();
        frmAddGrade.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddGradeActionPerformed

    private void btnRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordActionPerformed
        FrmGetGradeRecord frmGetGradeRecord = new FrmGetGradeRecord();
        frmGetGradeRecord.setVisible(true);
        FrmGetGradeRecord.txtNrcReceive.setText(txtCourse.getText());
        this.setVisible(false);
    }//GEN-LAST:event_btnRecordActionPerformed

    private void brnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnAddStudentActionPerformed
        FrmAddStudent frmAddStudent = new FrmAddStudent();
        frmAddStudent.setVisible(true);
    }//GEN-LAST:event_brnAddStudentActionPerformed

    private void btnAttendanceRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceRecordActionPerformed
        FrmGetAttendanceRecord frmGetAttendanceRecord = new FrmGetAttendanceRecord();        
        frmGetAttendanceRecord.setVisible(true);
        FrmGetAttendanceRecord.txtNrcReceive1.setText(txtCourse.getText());
        this.setVisible(false);
    }//GEN-LAST:event_btnAttendanceRecordActionPerformed

    private int getNrcEntered() {
        int positionCourse;
        positionCourse = CourseController.findCourse(teacher.getCourses(), Integer.parseInt(txtCourse.getText()));
        return  positionCourse;
    }

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
            java.util.logging.Logger.getLogger(FrmEnterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEnterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEnterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEnterCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEnterCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnAddStudent;
    private javax.swing.JButton btnAddGrade;
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnAttendanceRecord;
    private javax.swing.JButton btnEnrolled;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnfind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JTextField txtCourse;
    // End of variables declaration//GEN-END:variables
}
