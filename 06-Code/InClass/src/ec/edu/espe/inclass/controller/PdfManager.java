package ec.edu.espe.inclass.controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static ec.edu.espe.inclass.controller.DataPersistence.teacher;
import static ec.edu.espe.inclass.view.FrmEnterCourse.position;
import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Stephen Drouet, Developer Bears, DCC-ESPE
 */
public class PdfManager {

    private static String askDirectory(Component parent) {
        JFileChooser fc = new JFileChooser();
        String directory = "";
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setApproveButtonText("Save");
        fc.setDialogTitle("Choose Directory");
        int answer = fc.showOpenDialog(parent);
        if (answer == JFileChooser.APPROVE_OPTION) {
            File fileChoose = fc.getSelectedFile();
            directory = fileChoose.getPath();
        } else {
            directory = "";
        }

        return directory;
    }
    
    
    public static void createGradeRecord(Component parent, JTable table) {
        
        String directory;
        
        directory = askDirectory(parent);
        
        if (!directory.equals("")) {

            try {
                String nrc;
                nrc = String.valueOf(teacher.getCourses().get(position).getNrc());
                FileOutputStream archive;
                File file = new File(directory + "/GradeRecordNrc" + nrc + ".pdf");
                archive = new FileOutputStream(file);
                Font fontType10 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                Font fontType12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archive);
                doc.open();
                Image img = Image.getInstance("src/img/espeLogo.png");

                Paragraph dateParagraph = new Paragraph();
                dateParagraph.add(Chunk.NEWLINE);
                Date date = new Date();
                dateParagraph.add(new Phrase("Date:\n" + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n", fontType12));

                PdfPTable head = new PdfPTable(4);
                head.setWidthPercentage(100);
                head.getDefaultCell().setBorder(0);
                float[] columnHead = new float[]{20F, 20F, 110F, 30F};
                head.setWidths(columnHead);
                head.setHorizontalAlignment(Element.ALIGN_LEFT);

                head.addCell(img);
                head.addCell("");
                head.addCell(new Phrase("UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE \n\n\tGRADE RECORD NRC: " + nrc, fontType12));
                head.addCell(dateParagraph);

                doc.add(head);

                Paragraph info = new Paragraph();
                info.add(Chunk.NEWLINE);
                info.add(new Phrase("ASIGNATURE:  " + teacher.getCourses().get(position).getName() + "\n\n", fontType12));
                doc.add(info);

                PdfPTable gradeRecordStudents = new PdfPTable(8);
                gradeRecordStudents.setWidthPercentage(100);
                gradeRecordStudents.getDefaultCell().setBorder(0);
                float[] columnGradeRecordStudents = new float[]{10F, 20F, 40F, 15F, 15F, 15F, 15F, 20F};
                gradeRecordStudents.setWidths(columnGradeRecordStudents);
                gradeRecordStudents.setHorizontalAlignment(Element.ALIGN_LEFT);

                PdfPCell title1 = new PdfPCell(new Phrase("#", fontType10));
                PdfPCell title2 = new PdfPCell(new Phrase("id", fontType10));
                PdfPCell title3 = new PdfPCell(new Phrase("Student", fontType10));
                PdfPCell title4 = new PdfPCell(new Phrase("Unit1", fontType10));
                PdfPCell title5 = new PdfPCell(new Phrase("Unit2", fontType10));
                PdfPCell title6 = new PdfPCell(new Phrase("Unit3", fontType10));
                PdfPCell title7 = new PdfPCell(new Phrase("Average", fontType10));
                PdfPCell title8 = new PdfPCell(new Phrase("Status", fontType10));

                title1.setBorder(0);
                title2.setBorder(0);
                title3.setBorder(0);
                title4.setBorder(0);
                title5.setBorder(0);
                title6.setBorder(0);
                title7.setBorder(0);
                title8.setBorder(0);

                title1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title6.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title7.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title8.setBackgroundColor(BaseColor.LIGHT_GRAY);

                gradeRecordStudents.addCell(title1);
                gradeRecordStudents.addCell(title2);
                gradeRecordStudents.addCell(title3);
                gradeRecordStudents.addCell(title4);
                gradeRecordStudents.addCell(title5);
                gradeRecordStudents.addCell(title6);
                gradeRecordStudents.addCell(title7);
                gradeRecordStudents.addCell(title8);

                for (int i = 0; i < table.getRowCount(); i++) {
                    String num = table.getValueAt(i, 0).toString();
                    String id = table.getValueAt(i, 1).toString();
                    String name = table.getValueAt(i, 2).toString();
                    String unit1 = table.getValueAt(i, 3).toString();
                    String unit2 = table.getValueAt(i, 4).toString();
                    String unit3 = table.getValueAt(i, 5).toString();
                    String average = table.getValueAt(i, 6).toString();
                    String status = table.getValueAt(i, 7).toString();

                    gradeRecordStudents.addCell(new Phrase(num, fontType10));
                    gradeRecordStudents.addCell(new Phrase(id, fontType10));
                    gradeRecordStudents.addCell(new Phrase(name, fontType10));
                    gradeRecordStudents.addCell(new Phrase(unit1, fontType10));
                    gradeRecordStudents.addCell(new Phrase(unit3, fontType10));
                    gradeRecordStudents.addCell(new Phrase(unit2, fontType10));
                    gradeRecordStudents.addCell(new Phrase(average, fontType10));
                    gradeRecordStudents.addCell(new Phrase(status, fontType10));
                }

                doc.add(gradeRecordStudents);
                doc.close();
                archive.close();
                JOptionPane.showMessageDialog(null, "Pdf successfully created");

            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        }
    }
    
    public static void createAttendaceRecord(Component parent, JTable table) {
        
        String directory;
        
        directory = askDirectory(parent);
        
        if (!directory.equals("")) {

            try {
                String nrc;
                nrc = String.valueOf(teacher.getCourses().get(position).getNrc());
                FileOutputStream archive;
                File file = new File(directory + "/AttendanceRecordNrc" + nrc + ".pdf");
                archive = new FileOutputStream(file);
                Font fontType10 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                Font fontType12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archive);
                doc.open();
                Image img = Image.getInstance("src/img/espeLogo.png");

                Paragraph dateParagraph = new Paragraph();
                dateParagraph.add(Chunk.NEWLINE);
                Date date = new Date();
                dateParagraph.add(new Phrase("Date:\n" + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n", fontType12));

                PdfPTable head = new PdfPTable(4);
                head.setWidthPercentage(100);
                head.getDefaultCell().setBorder(0);
                float[] columnHead = new float[]{20F, 20F, 110F, 30F};
                head.setWidths(columnHead);
                head.setHorizontalAlignment(Element.ALIGN_LEFT);

                head.addCell(img);
                head.addCell("");
                head.addCell(new Phrase("UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE \n\n\tATTENDANCE RECORD NRC: " + nrc, fontType12));
                head.addCell(dateParagraph);

                doc.add(head);

                Paragraph info = new Paragraph();
                info.add(Chunk.NEWLINE);
                info.add(new Phrase("ASIGNATURE:  " + teacher.getCourses().get(position).getName() + "\n\n", fontType12));
                doc.add(info);

                PdfPTable attendanceRecord = new PdfPTable(5);
                attendanceRecord.setWidthPercentage(100);
                attendanceRecord.getDefaultCell().setBorder(0);
                float[] columnAttendanceRecord = new float[]{10F, 20F, 30F, 20F, 20F};
                attendanceRecord.setWidths(columnAttendanceRecord);
                attendanceRecord.setHorizontalAlignment(Element.ALIGN_LEFT);

                PdfPCell title1 = new PdfPCell(new Phrase("#", fontType10));
                PdfPCell title2 = new PdfPCell(new Phrase("id", fontType10));
                PdfPCell title3 = new PdfPCell(new Phrase("Student", fontType10));
                PdfPCell title4 = new PdfPCell(new Phrase("Assistance Persent", fontType10));
                PdfPCell title5 = new PdfPCell(new Phrase("Status", fontType10));

                title1.setBorder(0);
                title2.setBorder(0);
                title3.setBorder(0);
                title4.setBorder(0);
                title5.setBorder(0);

                title1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title5.setBackgroundColor(BaseColor.LIGHT_GRAY);

                attendanceRecord.addCell(title1);
                attendanceRecord.addCell(title2);
                attendanceRecord.addCell(title3);
                attendanceRecord.addCell(title4);
                attendanceRecord.addCell(title5);

                for (int i = 0; i < table.getRowCount(); i++) {
                    String num = table.getValueAt(i, 0).toString();
                    String id = table.getValueAt(i, 1).toString();
                    String name = table.getValueAt(i, 2).toString();
                    String assistancePersent = table.getValueAt(i, 3).toString();
                    String status = table.getValueAt(i, 4).toString();

                    attendanceRecord.addCell(new Phrase(num, fontType10));
                    attendanceRecord.addCell(new Phrase(id, fontType10));
                    attendanceRecord.addCell(new Phrase(name, fontType10));
                    attendanceRecord.addCell(new Phrase(assistancePersent, fontType10));
                    attendanceRecord.addCell(new Phrase(status, fontType10));
                }

                doc.add(attendanceRecord);
                doc.close();
                archive.close();
                JOptionPane.showMessageDialog(null, "Pdf successfully created");

            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        }
    }
    
    
    public static void createTutorshipRecord(Component parent, JTable table) {
        
        String directory;
        
        directory = askDirectory(parent);
        
        if (!directory.equals("")) {

            try {
                FileOutputStream archive;
                File file = new File(directory + "/TutorshipRecordNrc" + ".pdf");
                archive = new FileOutputStream(file);
                Font fontType10 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
                Font fontType12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archive);
                doc.open();
                Image img = Image.getInstance("src/img/espeLogo.png");

                Paragraph dateParagraph = new Paragraph();
                dateParagraph.add(Chunk.NEWLINE);
                Date date = new Date();
                dateParagraph.add(new Phrase("Date:\n" + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n", fontType12));

                PdfPTable head = new PdfPTable(4);
                head.setWidthPercentage(100);
                head.getDefaultCell().setBorder(0);
                float[] columnHead = new float[]{20F, 20F, 110F, 30F};
                head.setWidths(columnHead);
                head.setHorizontalAlignment(Element.ALIGN_LEFT);

                head.addCell(img);
                head.addCell("");
                head.addCell(new Phrase("UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE \n\n\tTUTORSHIPS RECORD NRC: ", fontType12));
                head.addCell(dateParagraph);

                doc.add(head);

                Paragraph info = new Paragraph();
                info.add(Chunk.NEWLINE);
                info.add(Chunk.NEWLINE);
                doc.add(info);

                PdfPTable tutorshipRecord = new PdfPTable(6);
                tutorshipRecord.setWidthPercentage(100);
                tutorshipRecord.getDefaultCell().setBorder(0);
                float[] columnTutorshipRecord = new float[]{10F, 20F, 30F, 20F, 20F, 30F};
                tutorshipRecord.setWidths(columnTutorshipRecord);
                tutorshipRecord.setHorizontalAlignment(Element.ALIGN_LEFT);

                PdfPCell title1 = new PdfPCell(new Phrase("#", fontType10));
                PdfPCell title2 = new PdfPCell(new Phrase("id", fontType10));
                PdfPCell title3 = new PdfPCell(new Phrase("Student", fontType10));
                PdfPCell title4 = new PdfPCell(new Phrase("Career", fontType10));
                PdfPCell title5 = new PdfPCell(new Phrase("Course Name", fontType10));
                PdfPCell title6 = new PdfPCell(new Phrase("Date", fontType10));

                title1.setBorder(0);
                title2.setBorder(0);
                title3.setBorder(0);
                title4.setBorder(0);
                title5.setBorder(0);
                title6.setBorder(0);

                title1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                title6.setBackgroundColor(BaseColor.LIGHT_GRAY);

                tutorshipRecord.addCell(title1);
                tutorshipRecord.addCell(title2);
                tutorshipRecord.addCell(title3);
                tutorshipRecord.addCell(title4);
                tutorshipRecord.addCell(title5);
                tutorshipRecord.addCell(title6);

                for (int i = 0; i < table.getRowCount(); i++) {
                    String num = table.getValueAt(i, 0).toString();
                    String id = table.getValueAt(i, 1).toString();
                    String name = table.getValueAt(i, 2).toString();
                    String carerr = table.getValueAt(i, 3).toString();
                    String courseName = table.getValueAt(i, 4).toString();
                    String day = table.getValueAt(i, 5).toString();
                    
                    tutorshipRecord.addCell(new Phrase(num, fontType10));
                    tutorshipRecord.addCell(new Phrase(id, fontType10));
                    tutorshipRecord.addCell(new Phrase(name, fontType10));
                    tutorshipRecord.addCell(new Phrase(carerr, fontType10));
                    tutorshipRecord.addCell(new Phrase(courseName, fontType10));
                    tutorshipRecord.addCell(new Phrase(day, fontType10));
                }

                doc.add(tutorshipRecord);
                doc.close();
                archive.close();
                JOptionPane.showMessageDialog(null, "Pdf successfully created");

            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        }
    }

}
