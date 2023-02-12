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
import static ec.edu.espe.inclass.controller.DataPersistence.position;
import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        String directory;
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

                String texts[] = {"#", "id", "Students", "Unit1", "Unit2", "Unit3", "Average", "Status"};

                putInformation(texts, gradeRecordStudents, table);

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

                String texts[] = {"#", "id", "Students", "Assistance Persent", "Status"};

                putInformation(texts, attendanceRecord, table);

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

                String texts[] = {"#", "id", "Students", "Career", "Course Name", "Date"};

                putInformation(texts, tutorshipRecord, table);

                doc.add(tutorshipRecord);
                doc.close();
                archive.close();
                JOptionPane.showMessageDialog(null, "Pdf successfully created");

            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(null, "error: " + e);
            }
        }
    }
    
    private static void putInformation(String[] texts, PdfPTable Record, JTable table) {
        ArrayList<PdfPCell> titles = new ArrayList<>();
        Font fontType10 = new Font(Font.FontFamily.TIMES_ROMAN, 10);

        for (String text : texts) {
            titles.add(new PdfPCell(new Phrase(text, fontType10)));
        }

        for (PdfPCell title : titles) {
            title.setBorder(0);
            title.setBackgroundColor(BaseColor.LIGHT_GRAY);
            Record.addCell(title);
        }

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                String data = table.getValueAt(i, j).toString();
                Record.addCell(new Phrase(data, fontType10));
            }
        }
    }

}
