package ec.edu.espe.inclass.view;

import ec.edu.espe.inclass.controller.DataPersistence;
import static ec.edu.espe.inclass.controller.DataPersistence.teacher;
import ec.edu.espe.inclass.controller.StudentController;
import ec.edu.espe.inclass.model.Grade;
import static ec.edu.espe.inclass.controller.DataPersistence.position;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejo
 */
public class FrmAddGrade extends javax.swing.JFrame {

    public FrmAddGrade() {
        initComponents();
        showTableDate(0, 0);
        this.setLocationRelativeTo(this);
    }

    private void showTableDate(int unit, int gradeType) {
        DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
        int numberOfGrades;
        ArrayList<Grade> studentsGrades;
        ArrayList<Object> studentRow;
        studentsGrades = StudentController.getGrades(gradeType, unit);

        emptyTable();

        if (!teacher.getCourses().get(position).getStudents().isEmpty()) {

            numberOfGrades = studentsGrades.get(0).getGradeValues().size();

            for (int i = 0; i < numberOfGrades; i++) {
                model.addColumn("Grade #" + (i + 1));
            }

            for (Grade studentsGrade : studentsGrades) {
                studentRow = buildRow(studentsGrade.getGradeValues(), numberOfGrades);
                model.addRow(studentRow.toArray());
            }

            model.setColumnCount(3 + numberOfGrades);
        }
    }

    private ArrayList<Object> buildRow(ArrayList<Float> studentsGrade, int numberOfGrades) {
        int num = tblGrades.getRowCount();
        ArrayList<Object> studentRow;
        studentRow = new ArrayList<>();

        while (studentsGrade.size() < numberOfGrades) {
            studentsGrade.add(0.0F);
        }

        studentRow.add(String.valueOf(num + 1));
        studentRow.add(teacher.getCourses().get(position).getStudents().get(num).getEspeId());
        studentRow.add(teacher.getCourses().get(position).getStudents().get(num).getName());

        for (Float grade : studentsGrade) {
            studentRow.add(String.valueOf(grade));
        }

        return studentRow;
    }

    private void emptyTable() {
        DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
        model.setRowCount(0);
        model.setColumnCount(3);
        lblAction.setText("");
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
        cmbGradeType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbUnit = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGrades = new javax.swing.JTable();
        lblAction = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Add Grade");

        cmbGradeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homework", "Workshop", "Test", "Exam" }));
        cmbGradeType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGradeTypeItemStateChanged(evt);
            }
        });

        jLabel4.setText("Unit #");

        cmbUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cmbUnit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUnitItemStateChanged(evt);
            }
        });

        jLabel5.setText("Grade:");

        btnAdd.setText("Add new grade");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove last grade");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSave.setText("Save grades");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tblGrades.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "Student", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGrades.setAutoResizeMode(0);
        tblGrades.getTableHeader().setReorderingAllowed(false);
        tblGrades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblGradesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblGrades);
        if (tblGrades.getColumnModel().getColumnCount() > 0) {
            tblGrades.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblGrades.getColumnModel().getColumn(0).setMaxWidth(30);
            tblGrades.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblGrades.getColumnModel().getColumn(1).setMaxWidth(70);
            tblGrades.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblGrades.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        lblAction.setText("Grades wasn´t saved, please use numbers and point(.)");

        jLabel2.setText("Press \"Enter\" before saving");

        btnBack.setBackground(new java.awt.Color(153, 0, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbGradeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAction, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbGradeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove)
                                .addGap(66, 66, 66)))
                        .addComponent(lblAction, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUnitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUnitItemStateChanged
        int unitNumber = cmbUnit.getSelectedIndex();
        int gradeType = cmbGradeType.getSelectedIndex();
        showTableDate(unitNumber, gradeType);
    }//GEN-LAST:event_cmbUnitItemStateChanged

    private void cmbGradeTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGradeTypeItemStateChanged
        int unitNumber = cmbUnit.getSelectedIndex();
        int gradeType = cmbGradeType.getSelectedIndex();
        showTableDate(unitNumber, gradeType);
    }//GEN-LAST:event_cmbGradeTypeItemStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int numberOfGrades = tblGrades.getColumnCount() - 3;
        int numberOfStudents = tblGrades.getRowCount();
        int unitNumber = cmbUnit.getSelectedIndex();
        int gradeType = cmbGradeType.getSelectedIndex();

        tblGrades.selectAll();

        ArrayList<Float> grades;
        ArrayList<ArrayList> studentsGradesValidate;
        ArrayList<Grade> studentsGrades;
        studentsGrades = StudentController.getGrades(gradeType, unitNumber);
        studentsGradesValidate = new ArrayList<>();

        try {
            for (int i = 0; i < numberOfStudents; i++) {
                grades = new ArrayList<>();
                for (int j = 3; j < 3 + numberOfGrades; j++) {
                    grades.add(Float.valueOf((String) tblGrades.getValueAt(i, j)));
                }
                studentsGradesValidate.add(grades);
            }

            for (int i = 0; i < numberOfStudents; i++) {
                grades = studentsGradesValidate.get(i);
                studentsGrades.get(i).setGradeValues(grades);
            }

            DataPersistence.updateStudentsInDB(teacher.getCourses().get(position));

            JOptionPane.showMessageDialog(this, "Grades was saved", "Grades", INFORMATION_MESSAGE);
        } catch (Exception e) {
            lblAction.setText("Grades wasn´t saved, please use numbers and point(.)");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
        int unitNumber = cmbUnit.getSelectedIndex();
        int gradeType = cmbGradeType.getSelectedIndex();
        int numberOfGrades = tblGrades.getColumnCount() - 3;
        ArrayList<Grade> studentsGrades;
        studentsGrades = StudentController.getGrades(gradeType, unitNumber);
        model.addColumn("Grade #" + (numberOfGrades + 1));

        for (Grade studentGrades : studentsGrades) {
            studentGrades.getGradeValues().add(0.0F);
        }

        lblAction.setText("Grades was added");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblGrades.getModel();
        int unitNumber = cmbUnit.getSelectedIndex();
        int gradeType = cmbGradeType.getSelectedIndex();
        int numberOfGrades = tblGrades.getColumnCount() - 3;
        ArrayList<Grade> studentsGrades;

        int desicion = JOptionPane.showConfirmDialog(this, "Do you want to delete the last grade?", "Grade delete info", WIDTH);

        if (desicion == 0) {
            if (numberOfGrades > 0) {
                lblAction.setText("Grades was deleted");
                studentsGrades = StudentController.getGrades(gradeType, unitNumber);

                model.setColumnCount(2 + numberOfGrades);

                for (Grade studentGrades : studentsGrades) {
                    studentGrades.getGradeValues().remove(numberOfGrades - 1);
                }

            } else {
                lblAction.setText("No grades to remove");
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FrmEnterCourse frmEnterCourse = new FrmEnterCourse();
        frmEnterCourse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblGradesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGradesKeyTyped
        char c = evt.getKeyChar();
        char c1 = (char)0;
        if (!Character.isDigit(c) && c!= KeyEvent.VK_PERIOD && c != KeyEvent.VK_DELETE) {                      
            evt.setKeyChar(c1);
        }
    }//GEN-LAST:event_tblGradesKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddGrade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbGradeType;
    private javax.swing.JComboBox<String> cmbUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAction;
    private javax.swing.JTable tblGrades;
    // End of variables declaration//GEN-END:variables
}
